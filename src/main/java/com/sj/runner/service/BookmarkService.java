package com.sj.runner.service;

import com.sj.runner.domain.repository.BookmarkRepository;
import com.sj.runner.dto.BookmarkDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor // repository 주입하기 위해 사용
@Service
public class BookmarkService {
    private BookmarkRepository bookmarkRepository;

    public void saveBookmark(BookmarkDto bookmarkDto){
        bookmarkRepository.save(bookmarkDto.toEntity());
    }
}
