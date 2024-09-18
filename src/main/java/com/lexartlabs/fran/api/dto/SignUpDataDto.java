package com.lexartlabs.fran.api.dto;

import com.lexartlabs.fran.api.enums.UserRole;
import lombok.Data;

@Data
public class SignUpDataDto {

    String username;
    String password;
    UserRole role;
}
