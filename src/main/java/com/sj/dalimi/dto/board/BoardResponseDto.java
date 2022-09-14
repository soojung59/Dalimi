package com.sj.dalimi.dto.board;

import com.sj.dalimi.entity.board.Board;

import lombok.Getter;

// @Getter
public class BoardResponseDto {
    private String id;
    private String name;

    public BoardResponseDto(Board board) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public void BoardRequestDto(Board entity){
    }

    @Override
    public String toString(){
        return "id: " + id + "name: " + name;
    }
}
