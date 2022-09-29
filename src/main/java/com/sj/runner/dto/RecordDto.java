package com.sj.runner.dto;

import com.sj.runner.domain.entity.RecordEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RecordDto {
    private Long record_id;
    private Long member_id;
    private Long start_latitude;
    private Long start_hardness;
    private Long arrival_latitude;
    private Long arrival_hardness;
    private LocalDateTime time;
    private String memo;
    private int heart;
    private int level;
    private int view;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    public RecordEntity toEntity(){
        RecordEntity recordEntity = RecordEntity.builder()
                .record_id(record_id)
                .member_id(member_id)
                .start_latitude(start_latitude)
                .start_hardness(start_hardness)
                .arrival_latitude(arrival_latitude)
                .arrival_hardness(arrival_hardness)
                .time(time)
                .memo(memo)
                .heart(heart)
                .level(level)
                .view(view)
                .build();

        return recordEntity;
    }

    @Builder
    public RecordDto(Long record_id, Long member_id, Long start_latitude, Long start_hardness, Long arrival_latitude,Long arrival_hardness, LocalDateTime time, String memo, int level){
        this.record_id = record_id;
        this.member_id = member_id;
        this.start_latitude = start_latitude;
        this.start_hardness = start_hardness;
        this.arrival_latitude = arrival_latitude;
        this.arrival_hardness = arrival_hardness;
        this.time = time;
        this.memo = memo;
        this.level = level;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
