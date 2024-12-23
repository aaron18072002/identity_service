package com.aaron.identity_service.controller;

import com.aaron.identity_service.dto.request.UserCreationRequest;
import com.aaron.identity_service.entity.User;
import com.aaron.identity_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    

}
