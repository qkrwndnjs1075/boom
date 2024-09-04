package com.example.dmc.domain.auth.exception;

import com.example.dmc.global.error.exception.ErrorCode;
import com.example.dmc.global.error.exception.PageException;

public class UserAlreadyTakenException extends PageException {

    public static final PageException EXCEPTION = new UserAlreadyTakenException();

    private UserAlreadyTakenException(){
        super(ErrorCode.USER_ALREADY_TAKEN);
    }
}
