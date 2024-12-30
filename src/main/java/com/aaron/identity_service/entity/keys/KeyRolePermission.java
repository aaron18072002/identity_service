package com.aaron.identity_service.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class KeyRolePermission implements Serializable {

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "permission_name", columnDefinition = "VARCHAR(30)")
    private String permissionName;

    public KeyRolePermission() {

    }

    public KeyRolePermission(int roleId, String permissionName) {
        this.roleId = roleId;
        this.permissionName = permissionName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyRolePermission that = (KeyRolePermission) o;
        return roleId == that.roleId && permissionName == that.permissionName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, permissionName);
    }

}
