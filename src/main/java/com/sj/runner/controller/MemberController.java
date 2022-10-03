package com.sj.runner.controller;

import com.sj.runner.dto.MemberDto;
import com.sj.runner.dto.RecordDto;
import com.sj.runner.service.MemberService;
import com.sj.runner.service.RecordService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Slf4j
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

    @GetMapping("/signup")
    public String dispSignup(){
        return "member/signup";
    }

    @PostMapping("/signup")
    public String execSignup(@Valid MemberDto memberDto, Errors errors, Model model){
        log.info("te2");
        if(errors.hasErrors()){
            model.addAttribute("memberDto", memberDto);
            Map<String, String> validatorResult = memberService.validateHandling(errors);
            for(String key: validatorResult.keySet()){
                model.addAttribute(key,validatorResult.get(key));
            }
            return "member/signup";
        }
        memberService.joinUser(memberDto);
        return "user/login";
    }

    @GetMapping("/user/login")
    public String dispLogin(){
        return "member/login";
    }
    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "redirect:/";
    }
    @GetMapping("/user/logout/result")
    public String Logout() {
        return "redirect:/";
    }

    @GetMapping("/user/denied") //접근 거부 페이지
    public String disDenied(){
        return "/denied";
    }

    @GetMapping("/user/info")
    public String dispMyInfo(Principal principal, Model model){
        MemberDto memberDto = memberService.getInfo(principal.getName());
        model.addAttribute("memberDto", memberDto);
        return "member/myinfo";
    }


    @GetMapping("/user/update")
    public String updateMyInfo(Principal principal, Model model){
        MemberDto memberDto = memberService.getInfo(principal.getName());
        model.addAttribute("memberDto", memberDto);
        return "/member/myinfo_update";
    }

    @PostMapping("/user/update")
    public String updateMyInfo( MemberDto memberDto){
        memberService.joinUser(memberDto);
        return "redirect:/user/info";
    }

    @PostMapping("/user/delete")
    public String deleteUser(MemberDto memberDto){
//        memberService.deleteUser(memberDto);
        return "/";
    }

    @GetMapping("/admin")
    public String dispAdmin(){
        return "/admin";
    }
}
