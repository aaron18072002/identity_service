package com.aaron.identity_service.controller;

import com.aaron.identity_service.dto.response.ApiResponse;

import com.aaron.identity_service.dto.response.RoleResponse;
import com.aaron.identity_service.entity.Role;
import com.aaron.identity_service.service.RoleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    public final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/getAll")
    public ApiResponse<List<RoleResponse>> getAll() {
        List<RoleResponse> roleResponses = this.roleService.getAllRoles();

        ApiResponse<List<RoleResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(roleResponses);

        return apiResponse;
    }

}
