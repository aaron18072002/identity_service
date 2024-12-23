package com.aaron.identity_service.repository.dao;

import java.util.List;

public interface Dao<T> {

    T create(T entity);

    T update(String entityId,T entity);

}
