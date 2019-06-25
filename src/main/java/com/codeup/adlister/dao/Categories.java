package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public interface Categories {
    Category findByCategory();

    void insert(ArrayList<String> category, Long ad_ID) throws SQLException;

    Long retrieveIdByName(String CategoryName);

    List<Category> list();


}
