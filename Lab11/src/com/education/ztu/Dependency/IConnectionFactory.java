package com.education.ztu.Dependency;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionFactory {
    Connection getConnection()  throws SQLException;
}
