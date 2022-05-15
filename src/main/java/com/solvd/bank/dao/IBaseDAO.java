package com.solvd.bank.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface IBaseDAO<T> {
    T getEntityById(long id) throws IOException, SQLException, ClassNotFoundException;
    void saveEntity(T entity);
    void updateEntity(long id, T entity);
    void removeEntity(long id);
}
