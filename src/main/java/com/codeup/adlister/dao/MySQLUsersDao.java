package com.codeup.adlister.dao;

import com.codeup.adlister.dao.interfaces.Users;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao() {
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
    public User findByEmail(String email) {
        String query = "SELECT * FROM team_adlister_db.users WHERE email = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by email", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM team_adlister_db.users WHERE username = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public void banUser(Long id){
        System.out.println(id);
        String query = "UPDATE team_adlister_db.users SET banned = TRUE WHERE id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }  catch (SQLException e){
            throw new RuntimeException("Error banning user", e);
        }
    }

    @Override
    public void unBanUser(Long id){
        String query = "UPDATE team_adlister_db.users SET banned = FALSE WHERE id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }  catch (SQLException e){
            throw new RuntimeException("Error reinstating user", e);
        }
    }

    @Override
    public User findById(long id) {
        String query = "SELECT * FROM team_adlister_db.users WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by ID", e);
        }
    }
    @Override
    public User deleteUser(long id){
        String query = "DELETE FROM team_adlister_db.users WHERE id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e){
            throw new RuntimeException("Error deleting a user by ID", e);
        }
    }
    @Override
    public User updateUser(String column, String value, long id){
        String query = "UPDATE team_adlister_db.users SET ? = ? where id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, column);
            stmt.setString(2, value);
            stmt.setLong(3, id);
            return extractUser(stmt.executeQuery());
        }  catch (SQLException e){
            throw new RuntimeException("Error updating user information", e);
        }
    }

    @Override
    public List<User> list() throws SQLException {
        String query = "SELECT * FROM team_adlister_db.users";
        PreparedStatement stmt = connection.prepareStatement(query);
        return createUsersFromResults(stmt.executeQuery());
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO team_adlister_db.users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private List<User> createUsersFromResults(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(extractUser(rs));
        }
        return users;
    }


    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getBoolean("admin"),
            rs.getBoolean("banned")
        );
    }

}
