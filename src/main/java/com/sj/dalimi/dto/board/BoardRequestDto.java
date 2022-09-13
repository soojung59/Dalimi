package com.sj.dalimi.dto.board;

import com.sj.dalimi.entity.board.Board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardRequestDto {
    private String id;
    private String name;

    public Board toEntity(){
        return Board.builder().name(name).build();
    }
}
