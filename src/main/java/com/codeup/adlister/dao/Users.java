package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;


public interface Users {
    User findByEmail (String email);
    User findByUsername(String username);
    Long insert(User user);
}
