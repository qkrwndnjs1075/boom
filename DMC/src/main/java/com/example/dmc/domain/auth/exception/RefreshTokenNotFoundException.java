package com.example.dmc.domain.auth.exception;

import com.example.dmc.global.error.exception.ErrorCode;
import com.example.dmc.global.error.exception.PageException;

public class RefreshTokenNotFoundException extends PageException {

    public static final PageException EXCEPTION = new RefreshTokenNotFoundException();

    private RefreshTokenNotFoundException() {
        super(ErrorCode.REFRESH_TOKEN_NOT_FOUND);
    }

}
