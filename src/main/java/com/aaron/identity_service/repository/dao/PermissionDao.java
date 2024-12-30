package com.aaron.identity_service.repository.dao;

import com.aaron.identity_service.entity.Permission;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PermissionDao implements Dao<Permission> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Permission create(Permission entity) {
        String createQuery = """
                INSERT INTO permissions(permission_name, description)
                VALUES (?,?);
                """;
        String get = """
                SELECT * FROM permissions
                WHERE permission_name = ?;
                """;

        Permission permission = null;

        try {
            this.em.createNativeQuery(createQuery)
                    .setParameter(1, entity.getPermissionName())
                    .setParameter(2, entity.getDescription())
                    .executeUpdate();

            permission = (Permission) this.em.createNativeQuery(get, Permission.class)
                    .setParameter(1, entity.getPermissionName())
                    .getSingleResult();
        } catch (RuntimeException e) {
            throw new RuntimeException("Create permission failed");
        }

        return permission;
    }

    @Override
    public Permission update(String entityId, Permission entity) {
        return null;
    }

}
