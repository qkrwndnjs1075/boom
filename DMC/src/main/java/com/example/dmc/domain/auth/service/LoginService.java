package com.example.dmc.domain.auth.service;

import com.example.dmc.domain.auth.exception.PasswordMismatchException;
import com.example.dmc.domain.auth.exception.UserNotFoundException;
import com.example.dmc.domain.auth.presentation.dto.request.LoginRequest;
import com.example.dmc.domain.auth.presentation.dto.response.LoginResponse;
import com.example.dmc.domain.user.domain.User;
import com.example.dmc.domain.user.domain.repository.UserRepository;
import com.example.dmc.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public LoginResponse login(LoginRequest request){

        if(userRepository.existsByAccountId(request.accountId())){
            User user = userRepository.findByAccountId(request.accountId())
                    .orElseThrow(()-> UserNotFoundException.EXCEPTION);

            if(!passwordEncoder.matches(request.password(),user.getPassword()))
                throw PasswordMismatchException.EXCEPTION;
        }
        return jwtTokenProvider.receiveToken(request.accountId());
    }

}
