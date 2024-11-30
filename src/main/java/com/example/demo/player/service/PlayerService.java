package com.example.demo.player.service;

import com.example.demo.player.service.request.PlayerCreateRequest;
import com.example.demo.player.service.response.PlayerCreateResponse;
import com.example.demo.player.service.response.PlayerListResponse;

import java.util.List;

public interface PlayerService {
    PlayerCreateResponse createPlayer(PlayerCreateRequest playerCreateRequest);
    List<PlayerListResponse> listPlayer();
}
