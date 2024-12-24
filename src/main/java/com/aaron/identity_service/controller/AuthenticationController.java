package com.aaron.identity_service.controller;

import com.aaron.identity_service.dto.request.AuthenticationRequest;
import com.aaron.identity_service.dto.response.ApiResponse;
import com.aaron.identity_service.dto.response.AuthenticationResponse;
import com.aaron.identity_service.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/log-in")
    public ApiResponse<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        boolean authenticated = this.authenticationService.authenticate(request);

        var result = new ApiResponse<AuthenticationResponse>();

        result.setResult(AuthenticationResponse.builder()
                .withIsAuthenticated(authenticated)
                .build());

        return result;
    }

}
