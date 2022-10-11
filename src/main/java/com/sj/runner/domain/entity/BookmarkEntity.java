package com.sj.runner.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "bookmark")
public class BookmarkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private MemberEntity member;

    @ManyToOne
    @JoinColumn
    private RecordEntity record;

    private LocalDateTime createDate;

    @Builder
    public BookmarkEntity(Long id, BookmarkEntity book, LocalDateTime createDate){
        this.id= id;
        this.createDate = createDate;
    }
}
