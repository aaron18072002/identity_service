package com.aaron.identity_service.repository;

import com.aaron.identity_service.entity.Permission;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {

    @Query(value = "SELECT * FROM permissions ", nativeQuery = true)
    List<Permission> getAllPermissions();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM permissions WHERE permission_name = :name", nativeQuery = true)
    void deletePermissionByName(@Param("name") String name);

}
