package com.aaron.identity_service.dto.response;

public class AuthenticationResponse {

    private boolean isAuthenticated;

    private AuthenticationResponse() {

    }

    private AuthenticationResponse(Builder builder) {
        this.isAuthenticated = builder.isAuthenticated;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public static class Builder {
        private boolean isAuthenticated;

        public Builder withIsAuthenticated(boolean isAuthenticated) {
            this.isAuthenticated = isAuthenticated;
            return this;
        }

        public AuthenticationResponse build() {
            return new AuthenticationResponse(this);
        }

    }

}
