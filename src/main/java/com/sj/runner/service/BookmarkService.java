package com.sj.runner.service;

import com.sj.runner.domain.entity.BookmarkEntity;
import com.sj.runner.domain.repository.BookmarkRepository;
import com.sj.runner.domain.repository.MemberRepository;
import com.sj.runner.dto.BookmarkDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@AllArgsConstructor // repository 주입하기 위해 사용
@Service
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;

    public void saveBookmark(BookmarkDto bookmarkDto) {
        bookmarkRepository.save(bookmarkDto.toEntity());

    }

    public void deleteBookmark(BookmarkDto bookmarkDto) {
        bookmarkRepository.delete(bookmarkDto.toEntity());

    }
}

