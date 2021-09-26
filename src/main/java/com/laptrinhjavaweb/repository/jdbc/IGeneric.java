package com.laptrinhjavaweb.repository.jdbc;

import java.util.List;

public interface IGeneric<T> {
    List<T> findAll();
    List<T> findByCondition(String sql, Class<T> tClass);
    T findById(Integer id) throws IllegalAccessException, InstantiationException;
}
