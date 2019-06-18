CREATE DATABASE IF NOT EXISTS team_adlister_db;
USE team_adlister_db;


# Creates users table
CREATE TABLE IF NOT EXISTS users (
  id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  email    VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  img      TEXT,

  PRIMARY KEY (id)
);


# Creates ads table
CREATE TABLE IF NOT EXISTS ads(
  id        INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id   INT UNSIGNED NOT NULL,
  username  VARCHAR(255) NOT NULL,
  email     VARCHAR(255) NOT NULL,
  password  VARCHAR(255) NOT NULL,
  img       TEXT,

  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES team_adlister_db.users(id)
);


# Creates category table
CREATE TABLE IF NOT EXISTS category(
  id                    INT UNSIGNED NOT NULL AUTO_INCREMENT,
  category_name         varchar(255) NOT NULL,
  category_description  TEXT,

  PRIMARY KEY (id)
);



# Creates relationship between ads and category
CREATE TABLE IF NOT EXISTS ads_cat(
  ad_id   INT UNSIGNED NOT NULL,
  category_id  INT UNSIGNED NOT NULL,
  FOREIGN KEY (ad_id) REFERENCES team_adlister_db.ads(id),
  FOREIGN KEY (category_id) REFERENCES team_adlister_db.category(id)
);


# Use only for deleting whole database,
# DO NOT USE !!
DROP TABLE

DROP DATABASE team_adlister_db;