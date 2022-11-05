package com.sj.runner.controller;

import com.sj.runner.dto.BookmarkDto;
import com.sj.runner.service.BookmarkService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Slf4j
@Controller
@AllArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @PostMapping("/user/bookmark")
    public void  bookmark( BookmarkDto bookmarkDto){
        System.out.println(bookmarkDto);
        bookmarkService.saveBookmark(bookmarkDto);
    }

    @DeleteMapping
    public ResponseEntity<BookmarkDto> unBookmark(@RequestBody @Valid BookmarkDto bookmarkDto){
        bookmarkService.deleteBookmark(bookmarkDto);
        return new ResponseEntity<>(bookmarkDto, HttpStatus.OK);
    }
}
