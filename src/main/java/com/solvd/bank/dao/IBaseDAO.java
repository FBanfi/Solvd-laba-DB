package com.solvd.bank.dao;

import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.sql.SQLException;

public interface IBaseDAO<T> {
    T getEntityById(long id) throws IOException, SQLException, ClassNotFoundException;
    void saveEntity(T entity);
    void updateEntity(@Param("id") long id, @Param("entity") T entity);
    void removeEntity(long id);
}
