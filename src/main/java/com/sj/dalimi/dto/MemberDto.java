package com.sj.dalimi.dto;

import com.sj.dalimi.domain.entity.MemberEntity;
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
    @NotBlank(message = "비밀번호는 필수")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*.\\W)(?=\\S+$).{8,20}",
    message = "영문 대,소문자, 숫자, 특수기호 포함 8~20글자")
    private String password;
    @NotBlank(message = "닉네임 입력")
    private String nickname;
    private LocalDateTime creLocalDateTime;
    private LocalDateTime modifiedDate;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .nickname(nickname)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password, String nickname){
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}
