package com.example.dmc.domain.user.facade;


import com.example.dmc.domain.user.domain.User;
import com.example.dmc.domain.user.domain.repository.UserRepository;
import com.example.dmc.domain.user.exception.NotAuthenticationException;
import com.example.dmc.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    public User CurrentUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()){
            throw new NotAuthenticationException("인증되지 않는 유저입니다");
        }

        String accountId = authentication.getName();

        return userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
