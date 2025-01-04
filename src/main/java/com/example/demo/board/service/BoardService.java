package com.example.demo.board.service;

import com.example.demo.board.entity.Board;
import com.example.demo.board.service.request.CreateBoardRequest;
import com.example.demo.board.service.request.ListBoardRequest;
import com.example.demo.board.service.request.ModifyBoardRequest;
import com.example.demo.board.service.response.ListBoardResponse;
import com.example.demo.board.service.response.ModifyBoardResponse;
import com.example.demo.board.service.response.ReadBoardResponse;

import java.util.List;

public interface BoardService {
    ListBoardResponse list(ListBoardRequest request);

    Board register(CreateBoardRequest createBoardRequest);

    ReadBoardResponse read(Long boardId);

    public boolean delete(Long boardId);

    ModifyBoardResponse modify(Long boardId, Long accountId, ModifyBoardRequest modifyBoardRequest);
}
