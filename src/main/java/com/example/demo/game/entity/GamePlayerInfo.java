package com.example.demo.game.entity;

import com.example.demo.player.entity.Player;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class GamePlayerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    public GamePlayerInfo() {}

    public GamePlayerInfo(Game game, Player player) {
        this.game = game;
        this.player = player;
    }
}
