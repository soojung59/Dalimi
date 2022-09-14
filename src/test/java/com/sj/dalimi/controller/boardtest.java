package com.sj.dalimi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sj.dalimi.dto.board.BoardRequestDto;
import com.sj.dalimi.service.BoardService;

@SpringBootTest
class boardtest {

	@Autowired
	private BoardService boardservice;

	@Test
	void save(){
		BoardRequestDto boardsaveDto = new BoardRequestDto();

		boardsaveDto.setId("2");	
		boardsaveDto.setName("아무개");	
		
		String result = boardservice.save(boardsaveDto);
	}

}
