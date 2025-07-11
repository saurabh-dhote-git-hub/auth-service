package com.ssd.auth_service.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ValidateTokenResponse {
    private String username;
    private boolean valid;

    public ValidateTokenResponse(String username, boolean valid) {
        this.username = username;
        this.valid = valid;
    }

}
