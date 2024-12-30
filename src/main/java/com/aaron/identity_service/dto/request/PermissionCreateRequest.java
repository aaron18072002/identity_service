package com.aaron.identity_service.dto.request;

public class PermissionCreateRequest {

    private String permissionName;
    private String description;

    private PermissionCreateRequest() {

    }

    private PermissionCreateRequest(Builder builder) {
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

        public PermissionCreateRequest build() {
            return new PermissionCreateRequest(this);
        }

    }

}
