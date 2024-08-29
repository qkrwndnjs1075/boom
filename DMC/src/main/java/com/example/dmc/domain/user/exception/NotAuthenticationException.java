package com.example.dmc.domain.user.exception;


public class NotAuthenticationException extends RuntimeException {

    public NotAuthenticationException(String message){
        super(message);
    }
}
