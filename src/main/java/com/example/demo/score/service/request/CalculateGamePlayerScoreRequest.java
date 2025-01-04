package com.example.demo.score.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CalculateGamePlayerScoreRequest {
    private final long gameId;
}
