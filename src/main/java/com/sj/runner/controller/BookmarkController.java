package com.sj.runner.controller;

import com.sj.runner.domain.entity.MemberEntity;
import com.sj.runner.dto.BookmarkDto;
import com.sj.runner.dto.MemberDto;
import com.sj.runner.service.BookmarkService;
import com.sj.runner.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@Controller
@AllArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;
    private final MemberService memberService;

    @PostMapping("/user/bookmark")
    public ResponseEntity<String> addBookmark (Principal principal, MemberDto member,
                                               Long record){
        System.out.println("start");
        if(principal != null){
            member = memberService.getInfo(principal.getName());
        }
        System.out.println("bookmark");
        boolean result = false;

        if(member != null){
            result = bookmarkService.addBookmark(MemberEntity.builder().build(), record)   ;
            System.out.println("1:"+  result);
        }
        System.out.println("2:"+  result);
        return result? new ResponseEntity<>(HttpStatus.OK): new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
