package com.aaron.identity_service.controller;

import com.aaron.identity_service.dto.request.UserUpdateRequest;
import com.aaron.identity_service.dto.request.UserCreationRequest;
import com.aaron.identity_service.dto.response.ApiResponse;
import com.aaron.identity_service.dto.response.UserResponse;
import com.aaron.identity_service.entity.User;
import com.aaron.identity_service.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    public final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ApiResponse<UserResponse> create(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();

        apiResponse.setResult(this.userService.createUser(request));

        return apiResponse;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponse>> getAll() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        List<UserResponse> users = this.userService.getAllUsers();

        log.info("current username: {}", users);
        authentication.getAuthorities().stream()
                .forEach(authority -> log.info("authority: {}", authority));

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("userId") String userId) {
        UserResponse userReponse = this.userService.getUserById(userId);

        return new ResponseEntity<>(userReponse, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request) {
        UserResponse userResponse = this.userService.updateUser(userId,request);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") String userId) {
        this.userService.deleteUser(userId);

        return new ResponseEntity<>("Deleted user successfully!",HttpStatus.OK);
    }

}
