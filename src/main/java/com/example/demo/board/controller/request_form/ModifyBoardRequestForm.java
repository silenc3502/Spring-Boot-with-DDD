package com.example.demo.board.controller.request_form;

import com.example.demo.board.service.request.CreateBoardRequest;
import com.example.demo.board.service.request.ModifyBoardRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class ModifyBoardRequestForm {
    final private String title;
    final private String content;
    final private String userToken;

    public ModifyBoardRequest toModifyBoardRequest() {
        return new ModifyBoardRequest(title, content);
    }
}
