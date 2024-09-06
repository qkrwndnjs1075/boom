package com.example.dmc.domain.auth.presentation;

import com.example.dmc.domain.auth.presentation.dto.request.LoginRequest;
import com.example.dmc.domain.auth.presentation.dto.request.RefreshTokenRequest;
import com.example.dmc.domain.auth.presentation.dto.request.RegisterRequest;
import com.example.dmc.domain.auth.presentation.dto.response.LoginResponse;
import com.example.dmc.domain.auth.service.LoginService;
import com.example.dmc.domain.auth.service.LogoutService;
import com.example.dmc.domain.auth.service.RegisterService;
import com.example.dmc.domain.auth.service.ReissueService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final RegisterService registerService;
    private final LoginService loginService;
    private final LogoutService logoutService;
    private final ReissueService reissueService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterRequest request){
        registerService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request){
        return loginService.login(request);
    }

    @PostMapping("/logout")
    public void logout(@RequestParam String accessToken){
        logoutService.logout(accessToken);
    }

    @PatchMapping("/reissue")
    public LoginResponse reissue(@RequestBody @Valid RefreshTokenRequest request){
        return reissueService.reissue(request);
    }




}
