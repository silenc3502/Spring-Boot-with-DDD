package com.example.demo.game.service.request;

import com.example.demo.game.entity.Game;
import com.example.demo.game.entity.GameState;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateGameRequest {
    private final int playerCount;

    public Game toGame() {
        return new Game(this.playerCount, GameState.NOT_FINISH);
    }
}
