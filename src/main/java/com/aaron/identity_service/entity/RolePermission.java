package com.aaron.identity_service.entity;

import com.aaron.identity_service.entity.keys.KeyRolePermission;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "roles_permissions")
public class RolePermission {

    @EmbeddedId
    private KeyRolePermission keys;

    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "permission_name", insertable = false, updatable = false)
    private Permission permission;

    public KeyRolePermission getKeys() {
        return keys;
    }

    public void setKeys(KeyRolePermission keys) {
        this.keys = keys;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
    
}
