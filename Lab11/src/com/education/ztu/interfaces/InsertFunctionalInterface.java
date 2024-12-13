package com.education.ztu.interfaces;

import java.sql.PreparedStatement;

@FunctionalInterface
public interface InsertFunctionalInterface<TModel> {
    boolean insert(PreparedStatement preparedInsert, TModel model);
}
