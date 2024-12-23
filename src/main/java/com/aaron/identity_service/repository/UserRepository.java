package com.aaron.identity_service.repository;

import com.aaron.identity_service.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<User> getAllUsers();

    @Query(value = "SELECT * FROM users AS U WHERE U.user_id LIKE :userId", nativeQuery = true)
    Optional<User> getUserById(@Param("userId") String id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users WHERE user_id LIKE :userId", nativeQuery = true)
    void deleteUserById(@Param("userId") String id);

    @Query(value = "SELECT COUNT(*) FROM users AS U WHERE U.username LIKE :username", nativeQuery = true)
    int existsUserByUsername(@Param("username") String username);

}
