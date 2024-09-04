package com.example.dmc.domain.auth.service;

import com.example.dmc.domain.auth.exception.UserAlreadyTakenException;
import com.example.dmc.domain.auth.presentation.dto.request.RegisterRequest;
import com.example.dmc.domain.user.domain.User;
import com.example.dmc.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterRequest request){
        if(userRepository.existsByAccountId(request.accountId())){
            throw UserAlreadyTakenException.EXCEPTION;
        }

        userRepository.save(
                User.builder()
                        .accountId(request.accountId())
                        .password(passwordEncoder.encode(request.password()))
                        .name(request.name())
                        .introduce(request.introduce())
                        .build());
    }



}
