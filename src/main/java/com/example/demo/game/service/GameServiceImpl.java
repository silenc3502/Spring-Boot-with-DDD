package com.example.demo.game.service;


import com.example.demo.dice.repository.DiceRepository;
import com.example.demo.game.entity.Game;
import com.example.demo.game.entity.GameState;
import com.example.demo.game.repository.GameRepository;
import com.example.demo.game.service.request.CheckGameRequest;
import com.example.demo.game.service.request.CreateGameRequest;
import com.example.demo.game.service.request.RecordGameWinnerRequest;
import com.example.demo.game.service.response.CheckGameResponse;
import com.example.demo.game.service.response.CreateSimpleGameResponse;
import com.example.demo.game.service.response.RecordGameWinnerResponse;
import com.example.demo.player.entity.Player;
import com.example.demo.player.repository.PlayerRepository;
import com.example.demo.player.service.response.PlayerCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    final private GameRepository gameRepository;
    final private PlayerRepository playerRepository;
    final private DiceRepository diceRepository;

    @Override
    public CreateSimpleGameResponse createSimpleGame(CreateGameRequest createGameRequest) {
        Game game = gameRepository.save(createGameRequest.toGame());

        return CreateSimpleGameResponse.from(game.getId());
    }

//    private List<Player> findPotentialWinners(List<Player> playerList) {
//        int highestSum = 0;
//        List<Player> potentialWinners = new ArrayList<>();
//
//        for (Player player : playerList) {
//            int diceSum = calculateDiceSum(player);
//
//            if (diceSum > highestSum) {
//                highestSum = diceSum;
//                potentialWinners.clear();
//                potentialWinners.add(player);
//                continue;
//            }
//
//            if (diceSum == highestSum) {
//                potentialWinners.add(player);
//            }
//        }
//
//        return potentialWinners;
//    }
//
//    private int calculateDiceSum(Player player) {
//        return player.getDiceIdList().stream().mapToInt(Integer::intValue).sum();
//    }
//
//    @Override
//    public RecordGameWinnerResponse recordGameWinner(RecordGameWinnerRequest gameCheckWinnerRequest) {
//        Optional<Game> maybeGame = gameRepository.findById(gameCheckWinnerRequest.getGameId());
//
//        if (maybeGame.isEmpty()) {
//            return RecordGameWinnerResponse.gameNotFound();
//        }
//
//        Game game = maybeGame.get();
//        List<Integer> playerIdList = game.getPlayerIdList();
//
//        if (playerIdList.isEmpty()) {
//            return RecordGameWinnerResponse.noPlayers();
//        }
//
//        List<Player> playerList = playerRepository.findByIdIn(playerIdList);
//        List<Player> potentialWinners = findPotentialWinners(playerList);
//
//        if (potentialWinners.size() > 1) {
//            gameRepository.recordGame(game.getId(), DRAW);
//
//            return RecordGameWinnerResponse.draw();
//        }
//
//        Player winner = potentialWinners.get(0);
//        gameRepository.recordGame(game.getId(), winner.getId());
//
//        return RecordGameWinnerResponse.winner(winner.getNickname());
//    }
//
//    @Override
//    public CheckGameResponse checkGame(CheckGameRequest checkGameRequest) {
//        Optional<Game> maybeGame = gameRepository.findById(checkGameRequest.getGameId());
//
//        if (maybeGame.isEmpty()) {
//            return new CheckGameResponse("게임을 찾을 수 없습니다.");
//        }
//
//        Game game = maybeGame.get();
//        int winnerId = game.getWinnerId();
//        System.out.println("winnerId: " + winnerId);
//
//        if (winnerId <= 0) {
//            return new CheckGameResponse("게임의 승자가 없습니다.");
//        }
//
//        return new CheckGameResponse("승자: " + winnerId);
//    }
}
