package com.example.demo.board.service;

import com.example.demo.account.entity.Account;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account_profile.entity.AccountProfile;
import com.example.demo.account_profile.repository.AccountProfileRepository;
import com.example.demo.board.entity.Board;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.board.service.request.CreateBoardRequest;
import com.example.demo.board.service.response.ListBoardResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    final private BoardRepository boardRepository;
    final private AccountRepository accountRepository;
    final private AccountProfileRepository accountProfileRepository;

    @Override
    public List<ListBoardResponse> list() {
        List<Board> boardList = boardRepository.findAllWithWriter();
        log.info("boardList: {}", boardList);

        return boardList.stream()
                .map(ListBoardResponse::from) // 정적 메서드 사용
                .toList();
    }

    @Override
    public Board register(CreateBoardRequest createBoardRequest) {
        log.info("accountId: {}", createBoardRequest.getAccountId());

        Account account = accountRepository.findById(createBoardRequest.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account 존재하지 않음"));

        AccountProfile accountProfile = accountProfileRepository.findByAccount(account)
                .orElseThrow(() -> new RuntimeException("AccountProfile not found"));

        return boardRepository.save(createBoardRequest.toBoard(accountProfile));
    }

    @Override
    public Board read(Long boardId) {
        return null;
    }

    @Override
    public void delete(Long boardId) {

    }

//    @Override
//    public Board modify(Long boardId, RequestBoardForm requestBoardForm) {
//        return null;
//    }
}
