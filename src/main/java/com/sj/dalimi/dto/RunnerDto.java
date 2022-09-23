package com.sj.dalimi.dto;

import com.sj.dalimi.domain.entity.RunnerEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RunnerDto {
    private Long runner_id;
    private String email;
    private String nickname;
    private String password;
    private String level;
    private String running;
    private String time;
    private String withdrawal_date;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    public RunnerEntity toEntity(){
        RunnerEntity runnerEntity = RunnerEntity.builder()
                .runner_id(runner_id)
                .email(email)
                .nickname(nickname)
                .password(password)
                .level(level)
                .running(running)
                .time(time)
                .withdrawal_date(withdrawal_date)
                .build();

        return runnerEntity;
    }

    @Builder
    public RunnerDto(Long runner_id, String email,String password, String nickname, String level, String running, String time, String join_date, String withdrawal_date, LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.runner_id = runner_id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.level = level;
        this.running = running;
        this.time = time;
        this.withdrawal_date = withdrawal_date;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
