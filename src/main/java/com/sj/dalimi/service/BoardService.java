package com.sj.dalimi.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sj.dalimi.dto.board.BoardRequestDto;
import com.sj.dalimi.dto.board.BoardResponseDto;
import com.sj.dalimi.entity.board.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardrepository;

    @Transactional
    public String save (BoardRequestDto boardSaveDto){
        return boardrepository.save(boardSaveDto.toEntity()).getId();
    }


    public BoardResponseDto findById(String id){
        return new BoardResponseDto(boardrepository.findById(id).get());
    }
    
}
