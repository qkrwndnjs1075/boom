package com.example.dmc.domain.auth.exception;


import com.example.dmc.global.error.exception.ErrorCode;
import com.example.dmc.global.error.exception.PageException;

public class UserNotFoundException extends PageException {

    public static final PageException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}
