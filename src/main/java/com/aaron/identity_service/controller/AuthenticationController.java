package com.aaron.identity_service.controller;

import com.aaron.identity_service.dto.request.AuthenticationRequest;
import com.aaron.identity_service.dto.request.IntrospectRequest;
import com.aaron.identity_service.dto.response.ApiResponse;
import com.aaron.identity_service.dto.response.AuthenticationResponse;
import com.aaron.identity_service.dto.response.IntrospectResponse;
import com.aaron.identity_service.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

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
        AuthenticationResponse authenticationResponse = this.authenticationService.authenticate(request);

        var result = new ApiResponse<AuthenticationResponse>();

        result.setResult(authenticationResponse);

        return result;
    }

    @PostMapping("/verify-token")
    public ApiResponse<IntrospectResponse> verifyToken(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        IntrospectResponse introspectResponse = this.authenticationService.verifyToken(request);

        ApiResponse<IntrospectResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(introspectResponse);

        return apiResponse;
    }

}
