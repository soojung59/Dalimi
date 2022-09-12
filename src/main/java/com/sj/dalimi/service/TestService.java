package com.sj.dalimi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.sj.dalimi.mapper.TestMapper;
import com.sj.dalimi.vo.TestVo;


public class TestService {

    @Autowired
    public TestMapper mapper;

    public List<TestVo> selectTest(){
        return mapper.selectTest();
    }
    
}
