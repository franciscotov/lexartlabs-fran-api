package com.lexartlabs.fran.api.controller;

import com.lexartlabs.fran.api.dto.LoginData;
import com.lexartlabs.fran.api.entities.User;
import com.lexartlabs.fran.api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        System.out.println("User: " + user);
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginData loginData) {
        System.out.println("Login data: " + loginData);
        var user = userService.findByUsername(loginData.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (userService.passwordMatches(loginData.getPassword(), user.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
