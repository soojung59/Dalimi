package com.sj.dalimi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sj.dalimi.dto.board.BoardRequestDto;
import com.sj.dalimi.service.BoardService;

@SpringBootTest
class boardtest {

	@Autowired
	private BoardService boardservice;

	@Test
	@GetMapping("/hi")
	@ResponseBody
	public String testText(){
		return "testText";
	}
}

}
