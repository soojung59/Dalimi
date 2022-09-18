package com.sj.dalimi.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Table(name = "runner")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunnerEntity extends TimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long runner_id;

    @Column(length = 10, nullable = false)
    private String email;

    @Column(length = 10, nullable = false)
    private String nickname;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String level;

    @Column(length = 10, nullable = false)
    private String running;

    @Column(length = 10, nullable = false)
    private String time;


    @Column(length = 10, nullable = false)
    private String withdrawal_date;

    @Builder
    public RunnerEntity(Long runner_id, String email, String password, String nickname,String level,String running, String time,  String withdrawal_date){
        this.runner_id = runner_id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.level = level;
        this.running = running;
        this.time = time;
        this.withdrawal_date = withdrawal_date;

    }


}
