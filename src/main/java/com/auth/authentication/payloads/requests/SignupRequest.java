package com.auth.authentication.payloads.requests;

import java.util.Set;

public class SignupRequest {
    private final String username;
    private final String password;
    private final Set<String> roles;

    public SignupRequest(String username, String password, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
