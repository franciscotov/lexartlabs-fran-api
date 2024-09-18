package com.lexartlabs.fran.api.dto;

import com.lexartlabs.fran.api.enums.UserRole;

public class SignUpDataDto {

    String username;
    String password;
    UserRole role;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
