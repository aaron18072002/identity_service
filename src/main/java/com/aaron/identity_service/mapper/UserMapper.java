package com.aaron.identity_service.mapper;

import com.aaron.identity_service.dto.request.UserCreateRequest;
import com.aaron.identity_service.dto.request.UserUpdateRequest;
import com.aaron.identity_service.dto.response.UserResponse;
import com.aaron.identity_service.entity.User;

public interface UserMapper {

    /**
     * Convert dto into entity
     * @param request type of dto
     * @return entity
     */
    User toUser(UserCreateRequest request);

    void updateUser(User user, UserUpdateRequest request);

    UserResponse toUserReponse(User user);

}
