package com.example.demo.board.service;

import com.example.demo.board.entity.Board;
import com.example.demo.board.service.request.CreateBoardRequest;
import com.example.demo.board.service.response.ListBoardResponse;
import com.example.demo.board.service.response.ReadBoardResponse;

import java.util.List;

public interface BoardService {
    List<ListBoardResponse> list();

    Board register(CreateBoardRequest createBoardRequest);

    ReadBoardResponse read(Long boardId);

    public boolean delete(Long boardId);

//    Board modify(Long boardId, RequestBoardForm requestBoardForm);
}
