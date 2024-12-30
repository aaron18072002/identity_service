package com.aaron.identity_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "permissions")
public class Permission {

    @Id
    @Column(name = "permission_name", columnDefinition = "VARCHAR(30)")
    private String permissionName;

    @Column(name = "description", columnDefinition = "VARCHAR(200)")
    private String description;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "permission")
    private Set<RolePermission> rolePermissions;

    public Set<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(Set<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
