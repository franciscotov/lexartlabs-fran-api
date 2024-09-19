package com.lexartlabs.fran.api.controller;

import com.lexartlabs.fran.api.config.auth.TokenProvider;
import com.lexartlabs.fran.api.dto.SignInDataDto;
import com.lexartlabs.fran.api.dto.SignUpDataDto;
import com.lexartlabs.fran.api.entities.User;
import com.lexartlabs.fran.api.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost"}, maxAge = 3600)
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthService service;
    @Autowired
    private TokenProvider tokenService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpDataDto data) {
        service.signUp(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("/signup")
    public ResponseEntity<?> signUp() {
        return ResponseEntity.ok("Hello World Get");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody @Valid SignInDataDto data) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword());
            var authUser = authenticationManager.authenticate(usernamePassword);
            var accessToken = tokenService.generateAccessToken((User) authUser.getPrincipal());
            return ResponseEntity.ok(accessToken);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
