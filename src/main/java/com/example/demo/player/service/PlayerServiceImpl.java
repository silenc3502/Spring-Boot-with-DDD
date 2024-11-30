//package com.example.demo.player.service;
//
//import com.example.demo.dice.entity.Dice;
//import com.example.demo.dice.repository.DiceRepository;
//import com.example.demo.player.controller.response_form.PlayerCreateResponseForm;
//import com.example.demo.player.entity.Player;
//import com.example.demo.player.repository.PlayerRepository;
//import com.example.demo.player.service.request.PlayerCreateRequest;
//import com.example.demo.player.service.response.PlayerCreateResponse;
//import com.example.demo.player.service.response.PlayerListResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class PlayerServiceImpl implements PlayerService {
//    final private PlayerRepository playerRepository;
//    final private DiceRepository diceRepository;
//
//    @Override
//    public PlayerCreateResponse createPlayer(PlayerCreateRequest playerCreateRequest) {
//        Player player = playerCreateRequest.toPlayer();
//        int playerId = playerRepository.create(player);
//
//        if (playerId > 0) {
//            return PlayerCreateResponse.from(player);
//        }
//
//        return new PlayerCreateResponse("", false);
//    }
//
//    @Override
//    public List<PlayerListResponse> listPlayer() {
//        List<Player> playerList = playerRepository.findAll();
//
//        return playerList.stream()
//                .map(player -> {
//                    List<Dice> diceList = diceRepository.findByIdIn(player.getDiceIdList());
//                    return PlayerListResponse.from(player, diceList);  // Player와 Dice 객체들을 사용하여 PlayerListResponse 반환
//                })
//                .collect(Collectors.toList());
//    }
//}
