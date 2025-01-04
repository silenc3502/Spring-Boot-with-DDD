package com.example.demo.board.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class ModifyBoardRequest {
    final private String title;
    final private String content;
}
