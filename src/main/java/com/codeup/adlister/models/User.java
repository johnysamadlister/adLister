package com.codeup.adlister.models;

public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private String img;

    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, long id){
        this.id = id;
        this.username = username;
    }

    public User(long id,String username, String email, String password, String img) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.img = img;
    }


    public User(String username, String email, String password, String img) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.img = img;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
