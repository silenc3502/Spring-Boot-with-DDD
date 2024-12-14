package com.example.demo.score.controller;

import com.example.demo.score.controller.request_form.CalculateGamePlayerScoreRequestForm;
import com.example.demo.score.service.ScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/score")
public class ScoreController {
    final private ScoreService scoreService;

    @PostMapping("/calculate")
    public Boolean calculateGamePlayerScore(@RequestBody CalculateGamePlayerScoreRequestForm calculateGamePlayerScoreRequestForm) {
        log.info("createSimpleGame() called");

        return scoreService.calculateScore(calculateGamePlayerScoreRequestForm.toCalculateGamePlayerScoreRequest());
    }
}
