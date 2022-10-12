package com.sj.runner.service;

import com.sj.runner.domain.repository.BookmarkRepository;
import com.sj.runner.dto.BookmarkDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor // repository 주입하기 위해 사용
@Service
public class BookmarkService {
    private BookmarkRepository bookmarkRepository;

    public void saveBookmark(BookmarkDto bookmarkDto){
        bookmarkRepository.save(bookmarkDto.toEntity());
    }

    public boolean checkBookmark(Long record, Long member){
        boolean result = false;
        return (bookmarkRepository.findById(record, member)? result=true :result );
    }
}
