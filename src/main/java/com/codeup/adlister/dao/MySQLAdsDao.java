package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;


    public MySQLAdsDao() {
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


    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM team_adlister_db.ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }


    public List<Ad> searchAds(String search) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM team_adlister_db.ads JOIN team_adlister_db.users ON users.id = ads.user_id WHERE ads.title LIKE ? OR ads.description LIKE ? OR users.username LIKE ?");
            stmt.setString(1,"%" + search + "%");
            stmt.setString(2,"%" + search + "%");
            stmt.setString(3,"%" + search + "%");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        }catch (SQLException e){
            throw new RuntimeException("Error searching all ads", e);
        }

    }



    public List<Ad> listEverything() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM team_adlister_db.ads JOIN team_adlister_db.ads_cat ON ads_cat.ad_id = ads.id JOIN team_adlister_db.category ON category.id = ads_cat.category_id JOIN team_adlister_db.users ON users.id = ads.user_id WHERE users.banned = false");
            ResultSet rs = stmt.executeQuery();
            return createMegaAdsFromResults(rs);
        }catch (SQLException e){
            throw new RuntimeException("Error searching all ads", e);
        }

    }


    public List<Ad> listEverythingExceptUser(String username) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM team_adlister_db.ads JOIN team_adlister_db.ads_cat ON ads_cat.ad_id = ads.id JOIN team_adlister_db.category ON category.id = ads_cat.category_id JOIN team_adlister_db.users ON users.id = ads.user_id WHERE users.username != ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return createMegaAdsFromResults(rs);
        }catch (SQLException e){
            throw new RuntimeException("Error searching all ads", e);
        }

    }


    public List<Ad> retrieveAdsByUsername(String username) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM team_adlister_db.ads JOIN team_adlister_db.users ON users.id = ads.user_id WHERE users.username = ?");
            stmt.setString(1,username);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        }catch (SQLException e){
            throw new RuntimeException("Error searching all ads", e);
        }

    }



    public List<Ad> NotUsersAds(String username) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM team_adlister_db.ads JOIN team_adlister_db.users ON users.id = ads.user_id WHERE users.username != ?");
            stmt.setString(1,username);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        }catch (SQLException e){
            throw new RuntimeException("Error searching all ads", e);
        }

    }


    public Ad deleteAd(Long id) {
        String query = "DELETE FROM team_adlister_db.ads WHERE id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            return extractAd(stmt.executeQuery());
        } catch (SQLException e){
            throw new RuntimeException("Error deleting a ad by ID", e);
        }
    }


    public Long insert(Ad ad) {
        try {
                String insertQuery = "INSERT INTO team_adlister_db.ads(user_id, title, description) VALUES (?, ?, ?)";
                PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
                stmt.setLong(1, ad.getUserId());
                stmt.setString(2, ad.getTitle());
                stmt.setString(3, ad.getDescription());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                return rs.getLong(1);
            } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }



    public void updateAd(String titlevalue, String DescriptionValue, String id){
        String query = "UPDATE team_adlister_db.ads SET title = ?, description = ? WHERE id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, titlevalue);
            stmt.setString(2, DescriptionValue);
            stmt.setString(3, id);
            stmt.executeUpdate();
        }  catch (SQLException e){
            throw new RuntimeException("Error updating ad information", e);
        }
    }



    public List<Ad> limit(long limit, long offset) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM team_adlister_db.ads LIMIT ? OFFSET ?");
            stmt.setLong(1,limit);
            stmt.setLong(2, offset);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public List<Ad> addToAds(long limit, long offset, List<Ad> previousAds) {
        PreparedStatement stmt = null;
//        List<Ad> newaddlist = new ArrayList<>();
        try {
//            if (previousAds == null)
            stmt = connection.prepareStatement("SELECT * FROM team_adlister_db.ads LIMIT ? OFFSET ?");
            stmt.setLong(1,limit);
            stmt.setLong(2,offset);
            ResultSet rs = stmt.executeQuery();
            return addAdsToResults(rs, previousAds);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }



    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getString("title"),
            rs.getString("description"),
                rs.getLong("user_id")
        );
    }

    private Ad extractAdCategoryUser(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                DaoFactory.getUsersDao().findById(rs.getLong("user_id")),
                DaoFactory.getCategoriesDao().listbyAdid(rs.getLong("id"))

        );
    }

    private List<Ad> createMegaAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAdCategoryUser(rs));
        }
        return ads;
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    private List<Ad> addAdsToResults(ResultSet rs, List<Ad> previousAds) throws SQLException {
        while (rs.next()) {
            previousAds.add(extractAd(rs));
        }
        return previousAds;
    }
}
