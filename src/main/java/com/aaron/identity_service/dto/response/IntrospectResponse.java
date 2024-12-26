package com.aaron.identity_service.dto.response;

public class IntrospectResponse {

    private boolean isValid;

    private IntrospectResponse() {

    }

    private IntrospectResponse(Builder builder) {
        this.isValid = builder.isValid;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean isValid() {
        return isValid;
    }

    public static class Builder {

        private boolean isValid;

        public Builder withIsValid(boolean valid) {
            this.isValid = valid;
            return this;
        }

        public IntrospectResponse build() {
            return new IntrospectResponse(this);
        }
    }

}
