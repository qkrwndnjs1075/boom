package com.example.dmc.domain.presentation.dto.response;

import lombok.Builder;

import java.util.Date;

@Builder
public record LoginResponse(String accessToken, String refreshToken, Date accessExpired, Date refreshExpired)
{

}
