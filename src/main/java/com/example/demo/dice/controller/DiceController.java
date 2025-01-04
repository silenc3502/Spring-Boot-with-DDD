package com.example.demo.dice.controller;

import com.example.demo.dice.controller.request_form.RollDiceRequestForm;
import com.example.demo.dice.entity.Dice;
import com.example.demo.game.controller.request_form.CreateGameRequestForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dice.service.DiceService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/dice")
public class DiceController {
    final private DiceService diceService;

    @GetMapping("/test")
    public String diceTest() {
        log.info("diceTest() called");

        return "diceTest() called";
    }

    @PostMapping("/roll")
    public Dice rollDice(@RequestBody RollDiceRequestForm rollDiceRequestForm) {
        log.info("rollDice() called");

        Dice acquiredDice = diceService.rollDice(rollDiceRequestForm.toRollDiceRequest());

        return acquiredDice;
    }
}
