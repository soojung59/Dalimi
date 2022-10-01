package com.sj.runner.dto;

import com.sj.runner.domain.entity.MemberEntity;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    @Email(message = "이메일 형식에 맞지 않네요")
    @NotBlank(message = "이메일은 필수")
    private String email;
    private Long id;
    @NotBlank(message = "닉네임 입력")
    private String nickname;
    @NotBlank(message = "비밀번호는 필수")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*.\\W)(?=\\S+$).{8,20}",message = "영문 대,소문자, 숫자, 특수기호 포함 8~20글자")
    private String password;

    private int level;
    private int runningDistance;
    private LocalDateTime runningTime;
    private LocalDateTime joinDate;
    private LocalDateTime modifiedDate;
    private LocalDateTime withdrawalDate;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .nickname(nickname)
                .password(password)
                .runningDistance(runningDistance)
                .runningTime(runningTime)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password,  String nickname, int level, int runningDistance, LocalDateTime runningTime){
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.level = level;
        this.runningDistance = runningDistance;
        this.runningTime = runningTime;
    }
}
