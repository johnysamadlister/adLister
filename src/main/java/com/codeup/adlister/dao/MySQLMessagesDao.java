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
            throw new RuntimeException("Error retrieving all messages.", e);
        }
    }

    @Override
    public List<Message>limit(long limit, long offset) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM messages LIMIT ?,?");
            ResultSet rs = stmt.executeQuery();
            stmt.setLong(1,limit);
            stmt.setLong(2, offset);
            return createMessagesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all messages.", e);
        }
    }

    @Override
    public List<Message> addToMessages(long limit, long offset, List<Message> previousAds) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM messages LIMIT ?,?");
            ResultSet rs = stmt.executeQuery();
            stmt.setLong(1,limit);
            stmt.setLong(2, offset);
            return addMessagesToResults(rs, previousMessages);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all messages.", e);
        }
    }

    @Override
    public Long insert(Message message) {
        try {
            String insertQuery = "INSERT INTO messages(date, sender_id, recipient_id, message_id, body) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setDate(1, message.getDate());
            stmt.setLong(2, message.getSender_id());
            stmt.setLong(3, message.getRecipient_id());
            stmt.setLong(4, message.getMessage_id());
            stmt.setString(5, message.getBody());
            System.out.println(stmt);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new message.", e);
        }
    }
    private Message extractMessage(ResultSet rs) throws SQLException {
        return new Message(
                rs.getLong("id"),
                rs.getDate("date"),
            rs.getLong("sender_id"),
            rs.getLong("recipient_id"),
            rs.getLong("message_id"),
            rs.getString("body")
//                DaoFactory.getUsersDao().findById(rs.getLong("user_id"))  <-- What is this doing?

        );
    }

    private List<Message> createMessagesFromResults(ResultSet rs) throws SQLException {
        List<Message> messages = new ArrayList<>();
        while (rs.next()) {
            messages.add(extractMessage(rs));
        }
        return messages;
    }

    private List<Message> addMessagesToResults(ResultSet rs, List<Message> previousMessages) throws SQLException {
        while (rs.next()) {
            previousMessages.add(extractMessage(rs));
        }
        return previousMessages;
    }
}
