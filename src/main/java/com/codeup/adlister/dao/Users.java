package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.SQLException;


public interface Users {
    User findByEmail (String email);
    User findByUsername(String username);
    User findById (long id);
    Long insert(User user);
    User deleteUser(long id);
    User updateUser(String column, String value, long id);
    User list() throws SQLException;
}
