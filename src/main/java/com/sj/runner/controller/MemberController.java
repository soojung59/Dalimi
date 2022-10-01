package com.sj.runner.controller;

import com.sj.runner.dto.MemberDto;
import com.sj.runner.dto.RecordDto;
import com.sj.runner.service.MemberService;
import com.sj.runner.service.RecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;
    private final RecordService recordService;


    @GetMapping("/")
    public String index(Model model, @RequestParam(value = "page", defaultValue = "1")Integer pageNum){
        List<RecordDto> runnerList = recordService.getRunnerList(pageNum);
        Integer[] pageList = recordService.getPageList(pageNum);
        model.addAttribute("pageList", pageList);
        model.addAttribute("runnerList", runnerList);
        return "/index";

    }

    @GetMapping("/user/signup")
    public String dispSignup(MemberDto memberDto){
        return "/signup";
    }

    @PostMapping("/user/signup")
    public String execSignup(@Valid MemberDto memberDto, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("memberDto", memberDto);

            Map<String, String> validatorResult = memberService.validateHandling(errors);
            for(String key: validatorResult.keySet()){
                model.addAttribute(key,validatorResult.get(key));
            }
            return "/signup";
        }
        memberService.joinUser(memberDto);
        return "redirect:/user/login";
    }


    @GetMapping("/user/login")
    public String dispLogin(){
        return "/login";
    }

    @GetMapping("/user/login/result")
    public String disLoginResult(){
        return "/loginSuccess";
    }

    @GetMapping("/user/logout/result")
    public String dispLogout(){
        return "/logout";
    }

    @GetMapping("/user/denied") //접근 거부 페이지
    public String disDenied(){
        return "/denied";
    }

    @GetMapping("/user/info/{no}")
    public String dispMyInfo(@PathVariable("no")Long id, Model model){
        MemberDto memberDto = memberService.getInfo(id);
        model.addAttribute("memberDto", memberDto);
        return "/myinfo";
    }

    @GetMapping("/admin")
    public String dispAdmin(){
        return "/admin";
    }
}
