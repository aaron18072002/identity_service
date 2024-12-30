package com.aaron.identity_service.mapper;

import com.aaron.identity_service.dto.request.PermissionCreateRequest;
import com.aaron.identity_service.dto.response.PermissionResponse;
import com.aaron.identity_service.entity.Permission;
import org.springframework.stereotype.Component;

@Component
public class PermissionMapperImpl implements PermissionMapper {

    @Override
    public Permission toPermission(PermissionCreateRequest request) {
        Permission permission = new Permission();

        permission.setPermissionName(request.getPermissionName());
        permission.setDescription(request.getDescription());

        return permission;
    }

    @Override
    public PermissionResponse toPermissionResponse(Permission permission) {
        return PermissionResponse.builder()
                .withPermissionName(permission.getPermissionName())
                .withDescription(permission.getDescription())
                .build();
    }

}
