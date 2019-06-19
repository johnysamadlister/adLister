package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLCategoriesDao implements Categories{
    private Connection connection = null;

    public MySQLCategoriesDao() {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    Config.DataBaseUrl,
                    Config.Username,
                    Config.Password
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public Category findByCategory() {
        return null;
    }
}
