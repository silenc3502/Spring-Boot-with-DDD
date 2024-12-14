package com.example.demo.dice.service;

import com.example.demo.dice.entity.Dice;
import com.example.demo.dice.service.request.RollDiceRequest;

public interface DiceService {
    Dice rollDice(RollDiceRequest rollDiceRequest);
}
