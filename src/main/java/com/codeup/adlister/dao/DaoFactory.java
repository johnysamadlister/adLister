package com.codeup.adlister.dao;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Categories categoriesDao;
    private static Messages messagesDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao();
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao();
        }
        return usersDao;
    }

    public static Categories getCategoriesDao(){
        if(categoriesDao == null) {
            categoriesDao = new MySQLCategoriesDao();
        }
        return categoriesDao;
    }

    public static Messages getMessagesDao() {
        if(messagesDao == null) {
            messagesDao = new MySQLMessagesDao();
        }
        return messagesDao;
    }

}
