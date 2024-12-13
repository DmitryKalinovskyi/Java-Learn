package com.education.ztu.DAO;

import com.education.ztu.BaseModel;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IDAO<TModel extends BaseModel> {
    void insert(TModel model) throws SQLException;

    Optional<TModel> findById(int id) throws SQLException;
    List<TModel> getAll() throws SQLException;

    void update(TModel model) throws SQLException;

    void delete(int id) throws SQLException;
}
