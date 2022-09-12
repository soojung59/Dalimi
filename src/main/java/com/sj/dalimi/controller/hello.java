package com.sj.dalimi.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sj.dalimi.service.TestService;
import com.sj.dalimi.vo.TestVo;

@Controller
@MapperScan(value={"com.sj.dalimi.service"})
@SpringBootApplication
public class hello {
    
    // @RequestMapping(value = "/home")
    // public String test(){
    //     return "hello.html";
    // }
    @Autowired
    private TestService testService;
    
    @RequestMapping(value = "/test")
    public ModelAndView test() throws Exception{
        ModelAndView mav = new ModelAndView("test");

        List<TestVo> testList = testService.selectTest();
        mav.addObject("list", testList);

        return mav;
    }
    
}