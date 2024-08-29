package com.example.dmc.domain.auth.exception;


import com.example.dmc.global.error.exception.ErrorCode;
import com.example.dmc.global.error.exception.PageException;

public class ExpiredTokenException extends PageException {

    public static final PageException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException(){
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
