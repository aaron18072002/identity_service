package com.aaron.identity_service.dto.response;

public class AuthenticationResponse {

    private String token;

    private boolean authenticated = false;

    private AuthenticationResponse() {

    }

    private AuthenticationResponse(Builder builder) {
        this.token = builder.token;
        this.authenticated = builder.authenticated;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getToken() {
        return token;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public static class Builder {

        private String token;
        private boolean authenticated;

        public Builder withToken(String token) {
            this.token = token;
            return this;
        }

        public Builder withAuthenticated(boolean authenticated) {
            this.authenticated = authenticated;
            return this;
        }

        public AuthenticationResponse build() {
            return new AuthenticationResponse(this);
        }

    }

}
