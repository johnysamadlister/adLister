package com.codeup.adlister.models;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
    private String img;
    private User user;

    public Ad(){}

    public Ad(long id, long userId, String title, String description, String img) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.img = img;
    }

    public Ad(long userId, String title, String description, String img) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.img = img;
    }

    public Ad(long id ,String title, String description, String img, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.img = img;
        this.user = user;
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
