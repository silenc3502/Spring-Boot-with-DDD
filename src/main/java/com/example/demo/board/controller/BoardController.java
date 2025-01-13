package com.example.demo.board.controller;

import com.example.demo.account.service.AccountService;
import com.example.demo.account_profile.entity.AccountProfile;
import com.example.demo.account_profile.service.AccountProfileService;
import com.example.demo.board.controller.request_form.CreateBoardRequestForm;
import com.example.demo.board.controller.request_form.ListBoardRequestForm;
import com.example.demo.board.controller.request_form.ModifyBoardRequestForm;
import com.example.demo.board.controller.response_form.ListBoardResponseForm;
import com.example.demo.board.entity.Board;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.response.ListBoardResponse;
import com.example.demo.board.service.response.ModifyBoardResponse;
import com.example.demo.board.service.response.ReadBoardResponse;
import com.example.demo.kakao_authentication.service.KakaoAuthenticationService;
import com.example.demo.redis_cache.service.RedisCacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    final private BoardService boardService;
    final private RedisCacheService redisCacheService;

    @GetMapping("/list")
    public ListBoardResponseForm boardList(@ModelAttribute ListBoardRequestForm requestForm) {
        log.info("boardList() -> {}", requestForm);

        ListBoardResponse response = boardService.list(requestForm.toListBoardRequest());

        return ListBoardResponseForm.from(
                List.of(response),  // 하나의 ListBoardResponse 객체를 List로 감싸서 전달
                (int) response.getTotalItems(),
                response.getTotalPages()
        );
    }

    @PostMapping("/create")
    public Board registerBoard (@RequestBody CreateBoardRequestForm createBoardRequestForm) {
        log.info("registerBoard() -> {}", createBoardRequestForm);

        Long accountId = redisCacheService.getValueByKey(createBoardRequestForm.getUserToken());
        log.info("accountId -> {}", accountId);

        return boardService.register(createBoardRequestForm.toCreateBoardRequest(accountId));
    }

    @GetMapping("/{boardId}")
    public ReadBoardResponse readBoard (@PathVariable("boardId") Long boardId) {
        log.info("boardRead(): {}", boardId);

        return boardService.read(boardId);
    }

    @DeleteMapping("/{boardId}")
    public boolean deleteBoard (@PathVariable("boardId") Long boardId) {
        log.info("deleteBoard() - boardId: {}", boardId);

        boolean isDeleted = boardService.delete(boardId);

        if (!isDeleted) {
            throw new RuntimeException("게시글이 존재하지 않거나 이미 삭제되었습니다.");
        }

        return true;
    }

    @PutMapping("/{boardId}")
    public ModifyBoardResponse modifyBoard (@PathVariable("boardId") Long boardId,
                                            @RequestBody ModifyBoardRequestForm modifyBoardRequestForm) {
        log.info("modifyBoard(): " + modifyBoardRequestForm + ", id: " + boardId);

        Long accountId = redisCacheService.getValueByKey(modifyBoardRequestForm.getUserToken());

        return boardService.modify(boardId, accountId, modifyBoardRequestForm.toModifyBoardRequest());
    }
}
