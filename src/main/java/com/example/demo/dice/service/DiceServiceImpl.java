package com.example.demo.dice.service;

import com.example.demo.dice.entity.Dice;
import com.example.demo.dice.repository.DiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class DiceServiceImpl implements DiceService {
    final private DiceRepository diceRepository;

    @Override
    public Dice rollDice() {
        long randomNumber = (long)(Math.random() * 6) + 1;
        Dice dice = new Dice(randomNumber);
        Dice createdDice = diceRepository.save(dice);

        return createdDice;
    }
}
