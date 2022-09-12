package com.sj.dalimi.mapper;

import java.util.List;

import com.sj.dalimi.vo.TestVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestMapper {
    List<TestVo> selectTest();
}
