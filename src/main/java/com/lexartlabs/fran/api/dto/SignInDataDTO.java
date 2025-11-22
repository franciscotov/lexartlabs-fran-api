package com.lexartlabs.fran.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lexartlabs.fran.api.shared.constants.FieldLengths;
import com.lexartlabs.fran.api.shared.constants.Messages;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignInDataDTO {

    @JsonProperty(value = "username", required = true)
    @NotEmpty(message = Messages.USER_NAME_REQUIRED)
    @Size(max = FieldLengths.USER_NAME_LENGTH, message = Messages.USER_NAME_LENGTH_EXCEEDED)
    private String username;

    @JsonProperty(value = "password", required = true)
    @NotEmpty(message = Messages.USER_PASSWORD_REQUIRED)
    @Size(max = FieldLengths.PASSWORD_LENGTH, message = Messages.USER_PASSWORD_LENGTH_EXCEEDED)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
