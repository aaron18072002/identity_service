package com.aaron.identity_service.dto.request;

public class IntrospectRequest {

    private String token;

    private IntrospectRequest() {

    }

    private IntrospectRequest(Builder builder) {
        this.token = builder.token;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getToken() {
        return token;
    }

    public static class Builder {

        private String token;

        public Builder withToken(String token) {
            this.token = token;
            return this;
        }

        public IntrospectRequest build() {
            return new IntrospectRequest(this);
        }
    }

}
