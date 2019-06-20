package com.codeup.adlister.dao;

//import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Message;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLMessagesDao implements Messages {
    private Connection connection = null;

    public MySQLMessagesDao() {
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
    public List<Message> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM messages");
            ResultSet rs = stmt.executeQuery();
            return createMessagesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, img) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setString(4, ad.getImg());
            System.out.println(stmt);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new message.", e);
        }
    }
    private Message extractMessaged(ResultSet rs) throws SQLException {
        return new Message(
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getString("img")
        );
    }

    private List<Message> createMessagesFromResults(ResultSet rs) throws SQLException {
        List<Message> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractMessage(rs));
        }
        return ads;
    }
}
