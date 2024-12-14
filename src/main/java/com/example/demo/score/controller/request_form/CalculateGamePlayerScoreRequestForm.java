package com.example.demo.score.controller.request_form;

import com.example.demo.score.service.request.CalculateGamePlayerScoreRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CalculateGamePlayerScoreRequestForm {
    private final long gameId;

    public CalculateGamePlayerScoreRequest toCalculateGamePlayerScoreRequest() {
        return new CalculateGamePlayerScoreRequest(this.gameId);
    }
}
