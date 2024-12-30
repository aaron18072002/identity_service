package com.aaron.identity_service.dto.response;

import java.util.List;

public class RoleResponse {

    private String roleName;

    List<String> permissions;

    private RoleResponse() {

    }

    private RoleResponse(Builder builder) {
        this.roleName = builder.roleName;
        this.permissions = builder.permissions;
    }

    public static Builder Builder() {
        return new Builder();
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public String getRoleName() {
        return roleName;
    }

    public static class Builder {

        private String roleName;

        List<String> permissions;

        public Builder withRoleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public Builder withPermissions(List<String> permissions) {
            this.permissions = permissions;
            return this;
        }

        public RoleResponse build() {
            return new RoleResponse(this);
        }
    }

}
