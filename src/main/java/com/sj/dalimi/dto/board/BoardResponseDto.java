package com.sj.dalimi.dto.board;

import com.sj.dalimi.entity.board.Board;

import lombok.Getter;

@Getter
public class BoardResponseDto {
    private String id;
    private String name;

    public void BoardRequestDto(Board entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }

    @Override
    public String toString(){
        return "id: " + id + "name: " + name;
    }
}
