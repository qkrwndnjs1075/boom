package com.example.dmc.domain.auth.service;

import com.example.dmc.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.dmc.global.security.jwt.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class LogoutService {

    private final JwtTokenProvider jwtTokenProvider;
    private final RedisTemplate<String, String> redisTemplate;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public void logout(String accessToken) {

        String accountId = jwtTokenProvider.getSubjectFromToken(accessToken);

        // Redis에서 해당 사용자의 리프레시 토큰 삭제
        refreshTokenRepository.deleteById(accountId);

        // Access token 무효화 처리 (Redis 블랙리스트에 추가)
        long expiration = jwtTokenProvider.getExpiration(accessToken);
        redisTemplate.opsForValue().set(accessToken, "logout", expiration, TimeUnit.MILLISECONDS);
    }
    }

