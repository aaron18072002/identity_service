package com.aaron.identity_service.service;

import com.aaron.identity_service.dto.request.UserCreationRequest;
import com.aaron.identity_service.dto.request.UserUpdateRequest;
import com.aaron.identity_service.dto.response.UserResponse;
import com.aaron.identity_service.entity.User;
import com.aaron.identity_service.exception.AppException;
import com.aaron.identity_service.exception.ErrorCode;
import com.aaron.identity_service.mapper.UserMapper;
import com.aaron.identity_service.repository.UserRepository;
import com.aaron.identity_service.repository.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    // final là immutable ở STACK
    private final UserRepository userRepository;

    private final UserDao userDao;

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserDao userDao, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    public User createUser(UserCreationRequest request) {
        if(this.userRepository.existsUserByUsername(request.getUsername()) > 0) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        User user = this.userMapper.toUser(request);

        return this.userDao.create(user);
    }

    public List<UserResponse> getAllUsers() {
        List<User> users =  this.userRepository.getAllUsers();
        List<UserResponse> userResponses = new ArrayList<>();
        for(User user:users) {
            userResponses.add(this.userMapper.toUserReponse(user));
        }

        return userResponses;
    }

    public UserResponse getUserById(String userId) {
        return this.userMapper.toUserReponse(this.userRepository.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = this.userRepository.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ghi đè lại user vừa fetch
        this.userMapper.updateUser(user, request);

        return this.userMapper.toUserReponse(this.userRepository.save(user));
    }

    public void deleteUser(String userId) {
        this.userRepository.deleteUserById(userId);
        return;
    }

}
