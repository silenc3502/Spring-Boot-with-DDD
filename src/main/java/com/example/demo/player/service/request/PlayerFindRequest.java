package com.example.demo.player.service.request;

import com.example.demo.player.entity.Player;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PlayerFindRequest {
    private final Long playerId;
}
