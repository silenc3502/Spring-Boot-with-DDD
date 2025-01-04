package com.example.demo.dice.service.request;

import com.example.demo.dice.entity.Dice;
import com.example.demo.dice.entity.GamePlayerDice;
import com.example.demo.game.entity.Game;
import com.example.demo.player.entity.Player;
import com.example.demo.utility.RandomGenerator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RollDiceRequest {
    private final long playerId;
    private final long gameId;

    public Dice toDice(int generatedRandomNumber) {
        return new Dice(generatedRandomNumber);
    }

    public GamePlayerDice toGamePlayerDice(Player player, Game game, Dice dice) {
        return new GamePlayerDice(player, game, dice);
    }
}
