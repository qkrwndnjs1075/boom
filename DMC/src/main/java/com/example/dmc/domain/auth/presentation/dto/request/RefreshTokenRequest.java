package com.example.dmc.domain.auth.presentation.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public record RefreshTokenRequest(
        @NotBlank
        String token
)
{

}
