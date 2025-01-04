package com.example.demo.score.service;

import com.example.demo.dice.entity.GamePlayerDice;
import com.example.demo.dice.repository.DiceRepository;
import com.example.demo.dice.repository.GamePlayerDiceRepository;
import com.example.demo.game.entity.Game;
import com.example.demo.game.entity.GameState;
import com.example.demo.game.repository.GameRepository;
import com.example.demo.player.entity.Player;
import com.example.demo.player.repository.PlayerRepository;
import com.example.demo.score.entity.Score;
import com.example.demo.score.repository.ScoreRepository;
import com.example.demo.score.service.request.CalculateGamePlayerScoreRequest;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {
    final private ScoreRepository scoreRepository;
    final private GameRepository gameRepository;
    final private PlayerRepository playerRepository;
    final private DiceRepository diceRepository;
    final private GamePlayerDiceRepository gamePlayerDiceRepository;

    // 게임을 ID로 조회하는 메서드
    private Game getGameById(Long gameId) {
        return gameRepository.findById(gameId)
                .orElseThrow(() -> new IllegalArgumentException("Game not found"));
    }

    // 게임 ID로 GamePlayerDice 목록을 조회하는 메서드
    private List<GamePlayerDice> getGamePlayerDiceList(Game game) {
        System.out.println("calculateScore() game: " + game);
        return gamePlayerDiceRepository.findByGameIdWithPlayer((long) game.getId());
    }

    // GamePlayerDice에서 Player만 뽑아서 중복을 제거하는 메서드
    private List<Player> extractDistinctPlayers(List<GamePlayerDice> gamePlayerDiceList) {
        System.out.println("calculateScore() gamePlayerDiceList: " + gamePlayerDiceList);
        List<Player> playerList = gamePlayerDiceList.stream()
                .map(GamePlayerDice::getPlayer)
                .distinct()
                .collect(Collectors.toList());

        playerList.forEach(player -> System.out.println("Player id: " + player.getId()));
        return playerList;
    }

    // 게임 ID로 플레이어 점수 정보를 조회하는 메서드
    private Map<Long, Long> getPlayerScores(Game game) {
        List<Object[]> playerScores = gamePlayerDiceRepository.findPlayerScoresByGameId((long) game.getId());

        Map<Long, Long> playerScoreMap = new HashMap<>();
        for (Object[] score : playerScores) {
            Long playerId = (Long) score[0];  // Cast to Long
            Long totalScore = (Long) score[1];

            playerScoreMap.put(playerId, totalScore);
        }

        System.out.println("playerScoreMap: " + playerScoreMap);
        return playerScoreMap;
    }

    // 최고 점수를 찾는 메서드
    private Player findHighestScorer(List<Player> playerList, Map<Long, Long> playerScoreMap) {
        Player highestScorer = null;
        long highestScore = Integer.MIN_VALUE;

        for (Player player : playerList) {
            Long score = playerScoreMap.get(player.getId());
            if (score != null && score > highestScore) {
                highestScore = score;
                highestScorer = player;
            }
        }
        return highestScorer;
    }

    // 승자 or 무승부 판정
    private boolean determineGameResult(Game game, Player highestScorer, Map<Long, Long> playerScoreMap) {
        if (highestScorer != null) {
            long highestScore = playerScoreMap.get(highestScorer.getId());
            long countOfHighestScorers = countHighestScorers(playerScoreMap, highestScore);

            if (countOfHighestScorers > 1) {
                game.setStateFromValue(GameState.DRAW.getValue());
                return true; // 무승부
            }

            game.setStateFromValue(GameState.WINNER.getValue());
            return false; // 승자 결정됨
        }

        game.setStateFromValue(GameState.DRAW.getValue());
        return true; // 무승부
    }

    // 최고 점수 계산
    private long countHighestScorers(Map<Long, Long> playerScoreMap, long highestScore) {
        return playerScoreMap.values().stream()
                .filter(score -> score == highestScore)
                .count();
    }

    // 게임 점수 저장
    private void saveGameScore(Game game, Map<Long, Long> playerScoreMap) {
        for (Map.Entry<Long, Long> entry : playerScoreMap.entrySet()) {
            Long playerId = entry.getKey();
            Long score = entry.getValue();

            Player player = playerRepository.findById(playerId)
                    .orElseThrow(() -> new IllegalArgumentException("Player not found"));

            // Score 엔티티 생성
            Score scoreEntity = new Score(player, game, score.intValue());

            // Score 엔티티를 저장
            scoreRepository.save(scoreEntity);
        }
    }

    // 결과를 출력하는 메서드
    private void printResults(Player highestScorer) {
        if (highestScorer != null) {
            System.out.println("최고점 플레이어: " + highestScorer.getId());
        } else {
            System.out.println("최고점 플레이어가 없습니다.");
        }
    }

    @Override
    public boolean calculateScore(CalculateGamePlayerScoreRequest calculateGamePlayerScoreRequest) {
        Game game = getGameById(calculateGamePlayerScoreRequest.getGameId());
        List<GamePlayerDice> gamePlayerDiceList = getGamePlayerDiceList(game);
        List<Player> playerList = extractDistinctPlayers(gamePlayerDiceList);

        Map<Long, Long> playerScoreMap = getPlayerScores(game);

        Player highestScorer = findHighestScorer(playerList, playerScoreMap);

        boolean isDraw = determineGameResult(game, highestScorer, playerScoreMap);

        gameRepository.save(game);
        saveGameScore(game, playerScoreMap);

        printResults(highestScorer);

        return true;
    }
}
