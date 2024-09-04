package com.example.dmc.domain.auth.presentation.dto.request;


import jakarta.persistence.Column;

public record RegisterRequest

        (String accountId,
         String password,
         @Column(length = 4)
         String name,
         String introduce)
{


}
