package com.sj.dalimi.controller;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.sj.dalimi.entity.RunnerEntity;
import com.sj.dalimi.repository.RunnerReository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor //view 페이지가 필요없는  api응답에 어울리는 어노테이션 (autowired 비권장, bean주입)
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public String list(){
        return "list.html";
    }
    @GetMapping("/post")
    public String write(){
        return "write.html";
    }
    @PostMapping("/post")
    public String write(RecordDto recordDto){
//        Service.savePost(recordDto);
    }

    @RequestMapping(value = "/hi")
    @ResponseBody
    public String test(){
        return "hiTest";
    }
}
