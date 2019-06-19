package com.codeup.adlister.models;

public class Category {
    private long id;
    private String category_name;
    private String category_description;

    public Category(long id, String category_name, String category_description) {
        this.id = id;
        this.category_name = category_name;
        this.category_description = category_description;
    }

    public Category(String category_name, String category_description) {
        this.category_name = category_name;
        this.category_description = category_description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_description() {
        return category_description;
    }

    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }
}

