package com.aaron.identity_service.dto.request;

public class AuthenticationRequest {

    private String username;
    private String password;

    private AuthenticationRequest() {

    }

    private AuthenticationRequest(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {
        private String username;
        private String password;

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public AuthenticationRequest build() {
            return new AuthenticationRequest(this);
        }

    }

}
