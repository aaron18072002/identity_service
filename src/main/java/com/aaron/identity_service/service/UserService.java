package com.aaron.identity_service.service;

import com.aaron.identity_service.dto.request.UserCreationRequest;
import com.aaron.identity_service.dto.request.UserUpdateRequest;
import com.aaron.identity_service.entity.User;
import com.aaron.identity_service.repository.UserRepository;
import com.aaron.identity_service.repository.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    public User createUser(UserCreationRequest request) {
        User user = new User();

        if(this.userRepository.existsUserByUsername(request.getUsername()) > 0) {
            throw new RuntimeException("Username already exists");
        }

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return this.userDao.create(user);
    }

    public List<User> getAllUsers() {
        return this.userRepository.getAllUsers();
    }

    public User getUserById(String userId) {
        return this.userRepository.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String userId, UserUpdateRequest request) {
        User user = this.getUserById(userId);

        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        return this.userRepository.save(user);
    }

    public void deleteUser(String userId) {
        this.userRepository.deleteUserById(userId);
        return;
    }

}
