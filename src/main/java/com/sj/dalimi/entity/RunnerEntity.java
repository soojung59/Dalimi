package com.sj.dalimi.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Table(name = "runner")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long runner_id;

    @Column
    private String email;

    @Column
    private String nickname;

    @Column
    private String password;

    @Column
    private String Level;

    @Column
    private String running;

    @Column
    private String time;

    @Column
    private String join_date;

    @Column
    private String withdrawal_date;

}
