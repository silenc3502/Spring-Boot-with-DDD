package com.example.demo.player.repository;

import com.example.demo.player.entity.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository {
    static List<Player> playerList = new ArrayList<>();

    @Override
    public int create(Player player) {
        playerList.add(player);

        if (player != null) {
            return player.getId();
        }

        return 0;
    }

    @Override
    public List<Player> findAll() {
        return new ArrayList<>(playerList);
    }

    @Override
    public List<Player> findByIdIn(List<Integer> playerIdList) {

        return playerList.stream()
                .filter(player -> playerIdList.contains(player.getId()))
                .collect(Collectors.toList());
    }
}
