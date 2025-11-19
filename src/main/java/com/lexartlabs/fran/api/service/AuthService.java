package com.lexartlabs.fran.api.service;

import com.lexartlabs.fran.api.dto.SignUpDataDTO;

public interface AuthService {

    SignUpDataDTO signUp(SignUpDataDTO data);
}
