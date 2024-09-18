package com.lexartlabs.fran.api.service;


import com.lexartlabs.fran.api.dto.SignUpDataDto;
import com.lexartlabs.fran.api.entities.User;
import com.lexartlabs.fran.api.exceptions.InvalidJwtException;
import com.lexartlabs.fran.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = repository.findByUsername(username);
        return user;
    }

    public UserDetails signUp(SignUpDataDto data) throws InvalidJwtException {

        if (repository.findByUsername(data.getUsername()) != null) {
            throw new InvalidJwtException("Username already exists");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());

        User newUser = new User(data.getUsername(), encryptedPassword, data.getRole());

        return repository.save(newUser);

    }
}