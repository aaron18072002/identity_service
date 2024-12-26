package com.aaron.identity_service.mapper;

import com.aaron.identity_service.dto.request.UserCreationRequest;
import com.aaron.identity_service.dto.request.UserUpdateRequest;
import com.aaron.identity_service.dto.response.UserResponse;
import com.aaron.identity_service.entity.Role;
import com.aaron.identity_service.entity.User;
import com.aaron.identity_service.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User toUser(UserCreationRequest request) {
        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());

        user.setRole(this.roleRepository.findRoleByName("USER"));

        return user;
    }

    @Override
    public void updateUser(User user, UserUpdateRequest request) {
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
    }

    @Override
    public UserResponse toUserReponse(User user) {
        return UserResponse.builder()
                .withUserId(user.getUserId())
                .withUsername(user.getUsername())
                .withDob(user.getDob())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withPassword(user.getPassword())
                .withRole(user.getRole())
                .build();
    }
}
