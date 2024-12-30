package com.aaron.identity_service.service;

import com.aaron.identity_service.dto.request.PermissionCreateRequest;
import com.aaron.identity_service.dto.response.PermissionResponse;
import com.aaron.identity_service.entity.Permission;
import com.aaron.identity_service.mapper.PermissionMapper;
import com.aaron.identity_service.repository.PermissionRepository;
import com.aaron.identity_service.repository.dao.PermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;

    private final PermissionDao permissionDao;

    private final PermissionMapper permissionMapper;

    @Autowired
    public PermissionService(PermissionRepository permissionRepository, PermissionDao permissionDao, PermissionMapper permissionMapper) {
        this.permissionRepository = permissionRepository;
        this.permissionDao = permissionDao;
        this.permissionMapper = permissionMapper;
    }

    public PermissionResponse createPermission(PermissionCreateRequest request) {
        Permission permission = this.permissionMapper.toPermission(request);

        var result =  this.permissionDao.create(permission);

        return this.permissionMapper.toPermissionResponse(result);
    }

    public List<PermissionResponse> getAllPermissions() {
        return this.permissionRepository.getAllPermissions()
                .stream().map(permission -> {
                    return this.permissionMapper.toPermissionResponse(permission);
                })
                .toList();
    }

    public void deletePermission(String permissionName) {
        this.permissionRepository.deletePermissionByName(permissionName);

        return;
    }

}
