package com.sj.runner.dto;

import com.sj.runner.domain.entity.BookmarkEntity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookmarkDto {
    private Long id;
    private LocalDateTime createDate;

    public BookmarkEntity toEntity(){
        return BookmarkEntity.builder()
                .id(id)
                .createDate(createDate)
                .build();
    }
    @Builder
    public BookmarkDto(Long id, LocalDateTime createDate){
        this.id= id;
        this.createDate=createDate;
    }
}
