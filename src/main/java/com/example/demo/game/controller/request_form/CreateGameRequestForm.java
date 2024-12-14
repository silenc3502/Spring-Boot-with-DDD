package com.example.demo.game.controller.request_form;

import com.example.demo.game.service.request.CreateGameRequest;
import com.example.demo.game.service.request.RecordGameWinnerRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateGameRequestForm {
    private final int playerCount;

    public CreateGameRequest toCreateGameRequest() {
        return new CreateGameRequest(this.playerCount);
    }
}
