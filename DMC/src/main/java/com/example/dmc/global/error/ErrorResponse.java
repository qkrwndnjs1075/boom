package com.example.dmc.global.error;


import com.example.dmc.global.error.exception.ErrorCode;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE) //싱글턴 패턴
public class ErrorResponse {

    private String message;
    private Integer status;
    private LocalDateTime timestamp;
    private String description;

    public static ErrorResponse of(ErrorCode errorCode, String description){

        return ErrorResponse.builder()
                .message(errorCode.getMessage())
                .status(errorCode.getStatusCode())
                .timestamp(LocalDateTime.now())
                .description(description)
                .build();
    }

    public static ErrorResponse of(int statusCode, String description){

        return ErrorResponse.builder()
                .description(description)
                .status(statusCode)
                .timestamp(LocalDateTime.now())
                .description(description)
                .build();
    }
}
