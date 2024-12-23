package com.aaron.identity_service.repository;

import com.aaron.identity_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<User> getAllUsers();

    @Query(value = "SELECT * FROM users AS U WHERE U.user_id = :userId", nativeQuery = true)
    Optional<User> getUserById(@Param("userId") String id);

}
