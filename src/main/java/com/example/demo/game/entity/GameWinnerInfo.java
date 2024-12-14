package com.example.demo.game.entity;

import com.example.demo.player.entity.Player;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class GameWinnerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "game_id", unique = true)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    public GameWinnerInfo() {}

    public GameWinnerInfo(Game game, Player player) {
        this.game = game;
        this.player = player;
    }
}
