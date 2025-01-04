package com.example.demo.board.service.response;

import com.example.demo.board.entity.Board;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ModifyBoardResponse {
    private final Long boardId;
    private final String title;
    private final String nickname; // AccountProfile의 nickname
    private final String content;
    private final LocalDateTime createDate;
    private final LocalDateTime updateDate;

    // 정적 팩토리 메서드
    public static ModifyBoardResponse from(Board board) {
        return new ModifyBoardResponse(
                board.getBoardId(),
                board.getTitle(),
                board.getWriter().getNickname(),
                board.getContent(),
                board.getCreateDate(),
                board.getUpdateDate()
        );
    }
}
