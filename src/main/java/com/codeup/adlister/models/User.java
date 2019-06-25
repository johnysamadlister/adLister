package com.codeup.adlister.models;

public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private Boolean admin = false;
    private Boolean banned = false;

    public User() {}


    public User(String username, long id){
        this.id = id;
        this.username = username;
    }

    public User(Long id ,String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(Long id, String username, String email, String password, boolean admin, boolean banned){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.banned = banned;
    }

    public Boolean isBanned(){
        return banned;
    }

    public Boolean getBanned() { return banned; }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
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
