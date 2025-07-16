package com.ssd.auth_service.controller;

import com.ssd.auth_service.dto.AuthRequest;
import com.ssd.auth_service.dto.AuthResponse;
import com.ssd.auth_service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    private int count = 1;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) throws UnknownHostException {
        System.out.printf("Call: %d - %s \n", count++, LocalDateTime.now());
        return ResponseEntity.ok(authService.login(request));
    }
}

