package com.codecool.bookify.Service;

import java.util.List;

public interface HelperService<T> {

    public List<T> getAll();

    public T getById(Long id);

    public void update(T newObject, Long id);

    public void insert(T object);

    public void delete(Long id);
}
