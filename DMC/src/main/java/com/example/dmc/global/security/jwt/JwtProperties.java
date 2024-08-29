package com.example.dmc.global.security.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private String header;
    private String prefix;
    private String secret;
    private Long accessExpiration;
    private Long refreshExpiration;

}
