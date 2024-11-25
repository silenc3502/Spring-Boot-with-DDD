package com.example.demo.dice.repository;

import com.example.demo.dice.entity.Dice;

import java.util.List;

public interface DiceRepository {
    int rollDice();

    List<Dice> findByIdIn(List<Integer> diceIdList);
}
