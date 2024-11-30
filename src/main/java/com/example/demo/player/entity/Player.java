package com.example.demo.player.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Player {
    private static int idCounter = 0;
    private final int id;

    private String nickname;
    private List<Integer> diceIdList;

    public Player(String nickname) {
        this.id = ++idCounter;
        this.nickname = nickname;
        this.diceIdList = new ArrayList<>();
    }

    public void addDiceId(int diceId) {
        this.diceIdList.add(diceId);
    }
}
