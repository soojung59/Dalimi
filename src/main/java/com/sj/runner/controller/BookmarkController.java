package com.sj.runner.controller;

import com.sj.runner.dto.BookmarkDto;
import com.sj.runner.service.BookmarkService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@AllArgsConstructor
public class BookmarkController {

    private BookmarkService bookmarkService;

    @PostMapping("/user/bookmark")
    public void bookmark(Model model, BookmarkDto bookmarkDto){
        bookmarkService.saveBookmark(bookmarkDto);
    }

}
