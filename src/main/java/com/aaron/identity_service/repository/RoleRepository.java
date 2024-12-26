package com.aaron.identity_service.repository;

import com.aaron.identity_service.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "SELECT * FROM roles AS R WHERE R.role_name = :roleName", nativeQuery = true)
    Role findRoleByName(@Param("roleName") String name);

}
