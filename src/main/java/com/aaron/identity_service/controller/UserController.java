package com.aaron.identity_service.controller;

import com.aaron.identity_service.dto.request.UserUpdateRequest;
import com.aaron.identity_service.dto.request.UserCreationRequest;
import com.aaron.identity_service.dto.response.ApiResponse;
import com.aaron.identity_service.dto.response.UserResponse;
import com.aaron.identity_service.entity.User;
import com.aaron.identity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    public final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ApiResponse<User> create(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult(this.userService.createUser(request));

        return apiResponse;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponse>> getAll() {
        List<UserResponse> users = this.userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("userId") String userId) {
        UserResponse userReponse = this.userService.getUserById(userId);
        return new ResponseEntity<>(userReponse, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request) {
        UserResponse userReponse = this.userService.updateUser(userId,request);
        return new ResponseEntity<>(userReponse, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") String userId) {
        this.userService.deleteUser(userId);
        return new ResponseEntity<>("Deleted user successfully!",HttpStatus.OK);
    }

}
