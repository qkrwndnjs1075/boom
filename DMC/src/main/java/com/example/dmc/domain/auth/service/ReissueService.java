package com.example.dmc.domain.auth.service;

import com.example.dmc.domain.auth.domain.RefreshToken;
import com.example.dmc.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.dmc.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.dmc.domain.auth.presentation.dto.request.RefreshTokenRequest;
import com.example.dmc.domain.auth.presentation.dto.response.LoginResponse;
import com.example.dmc.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReissueService {


    private final JwtTokenProvider jwtTokenProvider;

    private final RefreshTokenRepository refreshTokenRepository;

    public LoginResponse reissue(RefreshTokenRequest request) {

        RefreshToken refreshToken = refreshTokenRepository.findByToken(request.token())
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);

            return jwtTokenProvider.receiveToken(refreshToken.getAccountId());
    }





}
