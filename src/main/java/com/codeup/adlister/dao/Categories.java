package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;


public interface Categories {
    Category findByCategory();

    Category insert();
}
