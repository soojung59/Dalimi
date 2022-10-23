package com.sj.runner.service;

import com.sj.runner.domain.entity.BookmarkEntity;
import com.sj.runner.domain.entity.MemberEntity;
import com.sj.runner.domain.entity.RecordEntity;
import com.sj.runner.domain.repository.BookmarkRepository;
import com.sj.runner.domain.repository.MemberRepository;
import com.sj.runner.domain.repository.RecordRepository;
import com.sj.runner.dto.BookmarkDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@AllArgsConstructor // repository 주입하기 위해 사용
@Service
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    private final RecordRepository recordRepository;

    public boolean addBookmark(MemberEntity member, Long recordId){
        RecordEntity record = recordRepository.findById(recordId).orElseThrow();

        if(isNotAlreadBookmark(member,recordId)){
            bookmarkRepository.save(new BookmarkEntity(record, member));
            return true;
        }
        return false;
    }
    public boolean isNotAlreadBookmark(MemberEntity member, Long record){
        return bookmarkRepository.findByMemberAndRecord(member,record).isEmpty();
    }
}

