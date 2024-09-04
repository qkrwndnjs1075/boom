package com.example.dmc.domain.auth.exception;

import com.example.dmc.global.error.exception.ErrorCode;
import com.example.dmc.global.error.exception.PageException;

public class PasswordMismatchException extends PageException {

    public static final PageException EXCEPTION = new PasswordMismatchException();

    PasswordMismatchException(){
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
