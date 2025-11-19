package com.lexartlabs.fran.api.service.implementation;

import com.lexartlabs.fran.api.dto.SignUpDataDTO;
import com.lexartlabs.fran.api.entities.User;
import com.lexartlabs.fran.api.exceptions.InvalidJwtException;
import com.lexartlabs.fran.api.repository.UserRepository;
import com.lexartlabs.fran.api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements UserDetailsService, AuthService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = repository.findByUsername(username);
        return user;
    }

    @Override
    public SignUpDataDTO signUp(SignUpDataDTO data) {
        if (Optional.ofNullable(repository.findByUsername(data.getUsername())).isPresent()) {
            throw new InvalidJwtException("user_already_exist");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        User newUser = new User(data.getUsername(), encryptedPassword, data.getRole());
        repository.save(newUser);
        return data;
    }
}