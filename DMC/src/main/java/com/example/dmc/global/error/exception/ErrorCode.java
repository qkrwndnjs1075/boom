package com.example.dmc.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {



    EXPIRED_TOKEN(401, "만료된 토큰입니다."),
    INVALID_TOKEN(401, "검증되지 않은 토큰입니다."),
    REFRESH_TOKEN_NOT_FOUND(404, "일치하는 리프레쉬토큰이 존재하지 않습니다."),

    // user
    USER_NOT_FOUND(404, "일치하는 유저가 존재하지 않습니다."),
    USER_MISMATCH(401, "유저가 일치하지 않습니다."),
    PASSWORD_MISMATCH(401, "비밀번호가 일치하지 않습니다."),
    INVALID_USER(401, "유효하지 않는 사용자입니다."),
    USER_ALREADY_TAKEN(401, "이미 유저가 있습니다"),

    //page
    PAGE_NOT_FOUND(404,"게시글이 존재하지 않습니다"),


    // general
    BAD_REQUEST(400, "프론트 탓이 확실하다.."),
    INTERNAL_SERVER_ERROR(500, "서버 탓일 수도 있고.."),

    // key
    INVALID_KEY(401, "잘못된 key입니다.");

    private final int statusCode;
    private final String message;

}
