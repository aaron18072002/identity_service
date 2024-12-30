package com.aaron.identity_service.mapper;

import com.aaron.identity_service.dto.request.PermissionCreateRequest;
import com.aaron.identity_service.dto.response.PermissionResponse;
import com.aaron.identity_service.entity.Permission;

public interface PermissionMapper {

    Permission toPermission(PermissionCreateRequest request);

    PermissionResponse toPermissionResponse(Permission permission);

}
