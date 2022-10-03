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
@Table(name = "member")
public class MemberEntity extends TimeEntity {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "member")
    private List<RecordEntity> record;

    @OneToMany(mappedBy = "bookmark")
    private List<BookmarkEntity> bookmark;

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String nickname;

    @Column(length = 100, nullable = true ,columnDefinition = "int(10) default 1")
    private int level;

    @Column(length = 100, nullable = true, columnDefinition = "int(10) default 0")
    private int runningDistance;

    @Column(length = 100, nullable = true, columnDefinition = "int(10) default 0")
    private LocalDateTime runningTime;



    @Builder
    public MemberEntity(Long id, String email, String password, String nickname, int level, int runningDistance, LocalDateTime runningTime){
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.level = level;
        this.runningDistance = runningDistance;
        this.runningTime = runningTime;
    }
}
