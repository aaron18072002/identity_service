package com.aaron.identity_service.controller;

import com.aaron.identity_service.dto.request.PermissionCreateRequest;
import com.aaron.identity_service.dto.response.ApiResponse;
import com.aaron.identity_service.dto.response.PermissionResponse;
import com.aaron.identity_service.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("/getAll")
    public ApiResponse<List<PermissionResponse>> getAll() {
        ApiResponse<List<PermissionResponse>> apiResponse = new ApiResponse<>();
        List<PermissionResponse> responseList =
                this.permissionService.getAllPermissions();

        apiResponse.setResult(responseList);

        return apiResponse;
    }

    @PostMapping("/create")
    public ApiResponse<PermissionResponse> getAll(@RequestBody PermissionCreateRequest request) {
        ApiResponse<PermissionResponse> apiResponse = new ApiResponse<>();

        apiResponse.setResult(this.permissionService.createPermission(request));

        return apiResponse;
    }

    @DeleteMapping("/{permission}")
    public ApiResponse<Void> delete(@PathVariable String permission) {
        this.permissionService.deletePermission(permission);

        return new ApiResponse<>();
    }

}
