package com.codeup.adlister.dao;
import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories {
    private Connection connection = null;

    public MySQLCategoriesDao() {
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
    public Category findByCategory() {
        return null;
    }


    @Override
    public void insert(ArrayList<String> categories, Long ad_ID) throws SQLException {
        try {
            for ( String category : categories ) {
                    if (retrieveIdByName(category) != null) {
                        System.out.println(category);
                        String insertQuery = "INSERT INTO ads_cat(ad_id, category_id) VALUES (?, ?)";
                        PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
                        stmt.setLong(1, ad_ID);
                        stmt.setLong(2, retrieveIdByName(category));
                        System.out.println(stmt);
                        stmt.executeUpdate();
                        ResultSet rs = stmt.getGeneratedKeys();
                        rs.next();
                    }}
        }catch (SQLException e){
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public Long retrieveIdByName(String CategoryName) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT id FROM team_adlister_db.category WHERE category_name = ?");
            stmt.setString(1, CategoryName);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getLong(1);
        }catch (SQLException e){
            throw new RuntimeException("Error searching all ID", e);
        }

    }

    @Override
    public List<Category> list() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM category");
            ResultSet rs = stmt.executeQuery();
            return createCategoryFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all Categories.", e);
        }
    }

    public List<Category> listbyAdid(long ad_id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM category JOIN ads_cat ON ads_cat.category_id = category.id WHERE category.id = ?");
            stmt.setLong(1, ad_id);
            ResultSet rs = stmt.executeQuery();
            return createCategoryFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all Categories.", e);
        }
    }


    private List<Category> createCategoryFromResults(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            categories.add(extractCategory(rs));
        }
        return categories;
    }

    private Category extractCategory(ResultSet rs) throws SQLException {
        return new Category(
                rs.getLong("id"),
                rs.getString("category_name"),
                rs.getString("category_description")
        );
    }

}

