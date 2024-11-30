//package com.example.demo.player.controller;
//
//import com.example.demo.player.controller.request_form.PlayerCreateRequestForm;
//import com.example.demo.player.controller.response_form.PlayerCreateResponseForm;
//import com.example.demo.player.controller.response_form.PlayerListResponseForm;
//import com.example.demo.player.entity.Player;
//import com.example.demo.player.service.response.PlayerCreateResponse;
//import com.example.demo.player.service.response.PlayerListResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.demo.player.service.PlayerService;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/player")
//public class PlayerController {
//    final private PlayerService playerService;
//
//    @GetMapping("/create")
//    public PlayerCreateResponseForm createPlayer(@ModelAttribute PlayerCreateRequestForm playerCreateRequestForm) {
//        log.info("createPlayer() called!");
//
//        PlayerCreateResponse response = playerService.createPlayer(playerCreateRequestForm.toPlayerCreateRequest());
//        return PlayerCreateResponseForm.from(response);
//    }
//
//    @GetMapping("/list")
//    public List<PlayerListResponseForm> listPlayer() {
//        log.info("listPlayer() called!");
//
//        List<PlayerListResponse> responseList = playerService.listPlayer();
//
//        return responseList.stream()
//                .map(PlayerListResponseForm::from)
//                .collect(Collectors.toList());
//    }
//}
