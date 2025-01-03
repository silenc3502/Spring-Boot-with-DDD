package com.example.demo.board.controller;

import com.example.demo.account.service.AccountService;
import com.example.demo.account_profile.entity.AccountProfile;
import com.example.demo.account_profile.service.AccountProfileService;
import com.example.demo.board.controller.request_form.CreateBoardRequestForm;
import com.example.demo.board.entity.Board;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.response.ListBoardResponse;
import com.example.demo.kakao_authentication.service.KakaoAuthenticationService;
import com.example.demo.redis_cache.service.RedisCacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    final private BoardService boardService;
    final private AccountProfileService accountProfileService;
    final private RedisCacheService redisCacheService;

    @GetMapping("/list")
    public List<ListBoardResponse> boardList () {
        log.info("boardList()");

        return boardService.list();
    }

    @PostMapping("/create")
    public Board registerBoard (@RequestBody CreateBoardRequestForm createBoardRequestForm) {
        log.info("registerBoard() -> {}", createBoardRequestForm);

        Long accountId = redisCacheService.getValueByKey(createBoardRequestForm.getUserToken());
        log.info("accountId -> {}", accountId);

        return boardService.register(createBoardRequestForm.toCreateBoardRequest(accountId));
    }

    @GetMapping("/{boardId}")
    public Board readBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        return boardService.read(boardId);
    }

    @DeleteMapping("/{boardId}")
    public void deleteBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead()");

        boardService.delete(boardId);
    }

//    @PutMapping("/{boardId}")
//    public Board modifyBoard (@PathVariable("boardId") Long boardId,
//                                 @RequestBody RequestBoardForm requestBoardForm) {
//        log.info("modifyBoard(): " + requestBoardForm + ", id: " + boardId);
//
//        return boardService.modify(boardId, requestBoardForm);
//    }
}
