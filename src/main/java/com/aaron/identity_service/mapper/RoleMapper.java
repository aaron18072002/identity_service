package com.aaron.identity_service.mapper;

import com.aaron.identity_service.dto.response.RoleResponse;
import com.aaron.identity_service.entity.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapper {

    public RoleResponse toRoleResponse(final Role role) {
        List<String> permissions = new ArrayList<>();

        var rolePermissions = role.getRolePermissions();
        if (rolePermissions != null && !rolePermissions.isEmpty()) {
            for (var rolePermission : rolePermissions) {
                permissions.add(rolePermission.getPermission().getPermissionName());
            }
        }

        return RoleResponse.Builder()
                .withRoleName(role.getRoleName())
                .withPermissions(permissions)
                .build();
    }

}
