package com.lexartlabs.fran.api.dto;

public class JwtDTO {
    String accessToken;

    public JwtDTO(String accessToken) {
        this.accessToken = accessToken;
    }
}
