package com.aaron.identity_service.service;

import com.aaron.identity_service.dto.request.AuthenticationRequest;
import com.aaron.identity_service.entity.User;
import com.aaron.identity_service.exception.AppException;
import com.aaron.identity_service.exception.ErrorCode;
import com.aaron.identity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(AuthenticationRequest request) {
        User user = this.userRepository.getUserByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }

}
