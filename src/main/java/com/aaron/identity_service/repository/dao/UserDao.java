package com.aaron.identity_service.repository.dao;

import com.aaron.identity_service.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDao implements Dao<User> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User create(User entity) {
        String query = """
                INSERT INTO users(username,password,first_name,last_name,dob)
                VALUES (?,?,?,?,?)
            """;
        try {
            this.entityManager.createNativeQuery(query, User.class)
                    .setParameter(1, entity.getUsername())
                    .setParameter(2, entity.getPassword())
                    .setParameter(3, entity.getFirstName())
                    .setParameter(4, entity.getLastName())
                    .setParameter(5, entity.getDob())
                    .executeUpdate();

            var id = this.entityManager.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult();
            entity.setUserId(String.valueOf(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        return entity;
    }

}
