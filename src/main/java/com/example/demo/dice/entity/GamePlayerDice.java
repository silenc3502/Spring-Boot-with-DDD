package com.example.demo.dice.entity;

import com.example.demo.game.entity.Game;
import com.example.demo.player.entity.Player;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class GamePlayerDice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dice_id", nullable = false)
    private Dice dice;

    public GamePlayerDice(Player player, Game game, Dice dice) {
        this.player = player;
        this.game = game;
        this.dice = dice;
    }

    public GamePlayerDice() {}
}
