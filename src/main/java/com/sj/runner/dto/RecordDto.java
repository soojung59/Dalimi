package com.sj.runner.dto;

import com.sj.runner.domain.entity.MemberEntity;
import com.sj.runner.domain.entity.RecordEntity;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RecordDto {
    private Long record_id;
    private MemberEntity member;
    private Long start_latitude;
    private Long start_hardness;
    private Long arrival_latitude;
    private Long arrival_hardness;
    private String time;
    private String memo;
    private int heart;
    private int level;
    private int view;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    public RecordEntity toEntity(){
        RecordEntity recordEntity = RecordEntity.builder()
                .record_id(record_id)
                .member(member)
                .start_latitude(start_latitude)
                .start_hardness(start_hardness)
                .arrival_latitude(arrival_latitude)
                .arrival_hardness(arrival_hardness)
                .time(time)
                .memo(memo)
                .heart(heart)
                .level(level)
                .view(view)
                .level(level)
                .build();

        return recordEntity;
    }

    @Builder
    public RecordDto(Long record_id, MemberEntity member, Long start_latitude, Long start_hardness, Long arrival_latitude, Long arrival_hardness, String time, String memo, int level,int heart,int view){
        this.record_id = record_id;
        this.member = member;
        this.start_latitude = start_latitude;
        this.start_hardness = start_hardness;
        this.arrival_latitude = arrival_latitude;
        this.arrival_hardness = arrival_hardness;
        this.time = time;
        this.memo = memo;
        this.view = view;
        this.level = level;
        this.heart = heart;
    }
}
