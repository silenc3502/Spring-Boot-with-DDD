package com.example.demo.dice.controller.request_form;

import com.example.demo.dice.service.request.RollDiceRequest;
import com.example.demo.game.service.request.CreateGameRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RollDiceRequestForm {
    private final long playerId;
    private final long gameId;

    public RollDiceRequest toRollDiceRequest() {
        return new RollDiceRequest(this.playerId, this.gameId);
    }
}
