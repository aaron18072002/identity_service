package com.aaron.identity_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role_name", columnDefinition = "VARCHAR(20)")
    private String roleName;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private List<User> users;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private List<RolePermission> rolePermissions;

    public List<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(List<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
