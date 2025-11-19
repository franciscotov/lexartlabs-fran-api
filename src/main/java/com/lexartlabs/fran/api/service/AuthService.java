package com.lexartlabs.fran.api.service;

import com.lexartlabs.fran.api.dto.SignUpDataDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {

    UserDetails signUp(SignUpDataDTO data);
}
