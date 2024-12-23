package com.aaron.identity_service.controller;

import com.aaron.identity_service.dto.request.UserCreationRequest;
import com.aaron.identity_service.entity.User;
import com.aaron.identity_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody UserCreationRequest request) {
        User user = this.userService.createUser(request);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = this.userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
