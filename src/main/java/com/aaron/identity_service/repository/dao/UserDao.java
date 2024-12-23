package com.aaron.identity_service.repository.dao;

import com.aaron.identity_service.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
//            var id = this.entityManager.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult();
//            entity.setUserId(String.valueOf(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return entity;
    }

    @Override
    public User update(String entityId, User entity) {
        String query = """
                UPDATE users
                SET first_name = ?, last_name = ?, dob = ?, password = ?
                WHERE user_id = ?;
                """;
        String getUserQuery = """
                SELECT * FROM user AS U where U.user_id = ?;
                """;
        User userFrDb = null;
        try {
            userFrDb = (User) this.entityManager.createNativeQuery
                            ("SELECT * FROM user AS U where U.user_id = ?", User.class)
                    .setParameter(1, entityId)
                    .getSingleResult();

            this.entityManager.createNativeQuery(query)
                    .setParameter(1, entity.getFirstName())
                    .setParameter(2, entity.getLastName())
                    .setParameter(3, entity.getDob())
                    .setParameter(4, entity.getPassword())
                    .setParameter(5, entityId)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return userFrDb;
    }
}
