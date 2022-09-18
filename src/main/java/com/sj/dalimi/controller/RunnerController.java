package com.sj.dalimi.controller;

import com.sj.dalimi.dto.RunnerDto;
import com.sj.dalimi.service.RunnerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@AllArgsConstructor //view 페이지가 필요없는  api응답에 어울리는 어노테이션 (autowired 비권장, bean주입)
@RequiredArgsConstructor
public class RunnerController {
    private final RunnerService runnerService;

    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no")Long no, Model model)  {
        RunnerDto runnerDto = runnerService.getPost(no);
        model.addAttribute("runnerDto", runnerDto);
        return "detail.html";
    }

    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long runner_id, Model model){
        RunnerDto runnerDto = runnerService.getPost(runner_id);

        model.addAttribute("runnerDto",runnerDto);
        return "update.html";
    }

    @PutMapping("/post/edit/{no}")
    public String update(RunnerDto runnerDto){
        runnerService.savePost(runnerDto);
        return "redirect:/";
    }

    /*게시글 목록*/
    @GetMapping("/")
    public String list(Model model){
        List<RunnerDto> runnerList = runnerService.getRunnerList();
        model.addAttribute("runnerList", runnerList);
        return "list.html";
    }

    @GetMapping("/post")
    public String write(){
        return "write.html";
    }
    @PostMapping("/post")
    public String write(RunnerDto runnerDto){
        runnerService.savePost(runnerDto);
        return  "redirect:/";
    }

    @RequestMapping(value = "/hi")
    public String test(){
        return "index.html";
    }
}
