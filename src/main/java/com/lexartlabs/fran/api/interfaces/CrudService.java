package com.lexartlabs.fran.api.interfaces;

import java.util.List;

public interface CrudService<T> {
    List<T> listAll();

    T getById(Long id);

    T create(T entity);

    T update(T entity);

    void delete(Long id);
}
