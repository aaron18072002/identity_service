package com.aaron.identity_service.service;

import com.aaron.identity_service.dto.response.RoleResponse;
import com.aaron.identity_service.mapper.RoleMapper;
import com.aaron.identity_service.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    @Autowired
    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public List<RoleResponse> getAllRoles() {
        return this.roleRepository.getAllRoles()
                .stream()
                .map(role -> {
                    return this.roleMapper.toRoleResponse(role);
                })
                .toList();
    }

}
