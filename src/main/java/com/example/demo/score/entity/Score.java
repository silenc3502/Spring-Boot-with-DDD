package com.example.demo.score.entity;

import com.example.demo.game.entity.Game;
import com.example.demo.player.entity.Player;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @Column(nullable = false)
    private int score;

    public Score(Player player, Game game, int score) {
        this.player = player;
        this.game = game;
        this.score = score;
    }

    public Score() {}
}

