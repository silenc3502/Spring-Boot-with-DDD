package com.example.demo.player.repository;

import com.example.demo.player.entity.Player;

import java.util.List;

public interface PlayerRepository {
    int create(Player player);
    List<Player> findAll();
    List<Player> findByIdIn(List<Integer> playerIdList);
}
