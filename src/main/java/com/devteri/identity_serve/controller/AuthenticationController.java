package com.devteri.identity_serve.controller;

import com.devteri.identity_serve.dtos.AuthenResponse;
import com.devteri.identity_serve.dtos.AuthenticationRequest;
import com.devteri.identity_serve.exception.ApiResponse;
import com.devteri.identity_serve.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    ApiResponse<AuthenResponse> authentication(@RequestBody AuthenticationRequest request){
        return new ApiResponse<>(200, "check", authenticationService.authenticate(request));
    }
}
