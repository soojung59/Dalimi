package com.sj.runner.dto;

import com.sj.runner.domain.entity.BookmarkEntity;
import com.sj.runner.domain.entity.MemberEntity;
import com.sj.runner.domain.entity.RecordEntity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookmarkDto {
    private Long id;
    private MemberEntity member;
    private RecordEntity record;

    public BookmarkEntity toEntity(){
        return BookmarkEntity.builder()
                .record(record)
                .member(member)
                .build();
    }
    @Builder
    public BookmarkDto(RecordEntity record,MemberEntity member){
        this.member = member;
        this.record = record;
    }
}
