package com.example.dmc.domain.auth.presentation;

import com.example.dmc.domain.auth.presentation.dto.request.LoginRequest;
import com.example.dmc.domain.auth.presentation.dto.request.RegisterRequest;
import com.example.dmc.domain.auth.presentation.dto.response.LoginResponse;
import com.example.dmc.domain.auth.service.LoginService;
import com.example.dmc.domain.auth.service.RegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/atuh")
public class AuthController {

    private final RegisterService registerService;
    private final LoginService loginService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterRequest request){
        registerService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request){
        return loginService.login(request);
    }



}
