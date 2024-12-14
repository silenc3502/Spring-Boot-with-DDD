package com.example.demo.score.service;


import com.example.demo.score.service.request.CalculateGamePlayerScoreRequest;

public interface ScoreService {
    boolean calculateScore(CalculateGamePlayerScoreRequest calculateGamePlayerScoreRequest);
}
