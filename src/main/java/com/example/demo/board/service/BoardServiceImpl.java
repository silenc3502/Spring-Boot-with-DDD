package com.example.demo.board.service;

import com.example.demo.account.entity.Account;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account_profile.entity.AccountProfile;
import com.example.demo.account_profile.repository.AccountProfileRepository;
import com.example.demo.board.entity.Board;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.board.service.request.CreateBoardRequest;
import com.example.demo.board.service.response.ListBoardResponse;
import com.example.demo.board.service.response.ReadBoardResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public ReadBoardResponse read(Long boardId) {
        Optional<Board> maybeBoard = boardRepository.findByIdWithWriter(boardId);

        if (maybeBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        Board board = maybeBoard.get();
        return ReadBoardResponse.from(board);
    }

    @Override
    public boolean delete(Long boardId) {
        // 먼저 게시글이 존재하는지 확인
        Optional<Board> maybeBoard = boardRepository.findById(boardId);
        if (maybeBoard.isPresent()) {
            // 존재한다면 삭제
            boardRepository.deleteById(boardId);
            return !boardRepository.existsById(boardId);  // 삭제 후 존재하지 않으면 true 반환
        }
        return false;  // 존재하지 않으면 false 반환
    }

//    @Override
//    public Board modify(Long boardId, RequestBoardForm requestBoardForm) {
//        return null;
//    }
}
