package com.aaron.identity_service.dto.response;

public class PermissionResponse {

    private String permissionName;
    private String description;

    private PermissionResponse() {

    }

    private PermissionResponse(Builder builder) {
        this.permissionName = builder.permissionName;
        this.description = builder.description;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getDescription() {
        return description;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public static class Builder {

        private String permissionName;
        private String description;

        public Builder withPermissionName(String permissionName) {
            this.permissionName = permissionName;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public PermissionResponse build() {
            return new PermissionResponse(this);
        }

    }

}
