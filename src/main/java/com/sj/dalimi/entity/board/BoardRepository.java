package com.sj.dalimi.entity.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sj.dalimi.dto.board.BoardRequestDto;

public interface BoardRepository extends JpaRepository <Board,String>{
 
    String SELECTLIST = "SELCT * FROM  test_table";

    @Transactional
    @Modifying
    @Query(value = SELECTLIST, nativeQuery = true)
    public int selectList(@Param("BoardRequestDto")BoardRequestDto BoardRequestDto);
}
