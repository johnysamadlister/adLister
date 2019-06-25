package com.codeup.adlister.models;

import java.util.List;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
    private String img;
    private User user;
    private List<Category> ad_categories;

    public Ad(){}

    public Ad(long id, String title, String description,long userId) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }


    public Ad(long id ,String title, String description, User user, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
        this.ad_categories = categories;
    }

    public List<Category> getAd_categories() {
        return ad_categories;
    }

    public void setAd_categories(List<Category> ad_categories) {
        this.ad_categories = ad_categories;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
