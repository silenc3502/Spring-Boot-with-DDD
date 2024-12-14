package com.example.demo.dice.service;

import com.example.demo.dice.entity.Dice;
import com.example.demo.dice.entity.GamePlayerDice;
import com.example.demo.dice.repository.DiceRepository;
import com.example.demo.dice.repository.GamePlayerDiceRepository;
import com.example.demo.dice.service.request.RollDiceRequest;
import com.example.demo.game.entity.Game;
import com.example.demo.game.repository.GameRepository;
import com.example.demo.player.entity.Player;
import com.example.demo.player.repository.PlayerRepository;
import com.example.demo.utility.RandomGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiceServiceImpl implements DiceService {
    final private DiceRepository diceRepository;
    final private PlayerRepository playerRepository;
    final private GameRepository gameRepository;
    final private GamePlayerDiceRepository gamePlayerDiceRepository;

    final private int MIN = 1;
    final private int MAX = 6;

    private int generateDiceValue() {
        return RandomGenerator.generate(MIN, MAX);
    }

    private Dice saveDice(RollDiceRequest rollDiceRequest, int diceValue) {
        return diceRepository.save(rollDiceRequest.toDice(diceValue));
    }

    private Player findPlayerById(Long playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("Player 찾지 못함"));
    }

    private Game findGameById(Long gameId) {
        return gameRepository.findById(gameId)
                .orElseThrow(() -> new IllegalArgumentException("Game 존재하지 않음"));
    }

    private void saveGamePlayerDice(Player player, Game game, Dice dice) {
        GamePlayerDice gamePlayerDice = new GamePlayerDice(player, game, dice);
        gamePlayerDiceRepository.save(gamePlayerDice);
    }

    @Override
    public Dice rollDice(RollDiceRequest rollDiceRequest) {
        int diceValue = generateDiceValue();

        Dice createdDice = saveDice(rollDiceRequest, diceValue);
        Player player = findPlayerById(rollDiceRequest.getPlayerId());
        Game game = findGameById(rollDiceRequest.getGameId());

        saveGamePlayerDice(player, game, createdDice);

        return createdDice;
    }
}
