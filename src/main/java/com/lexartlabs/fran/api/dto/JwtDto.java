package com.lexartlabs.fran.api.dto;

public class JwtDto {
    String accessToken;

    public JwtDto(String accessToken) {
        this.accessToken = accessToken;
    }
}
