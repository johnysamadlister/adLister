CREATE DATABASE IF NOT EXISTS team_adlister_db;

USE team_adlister_db;

CREATE TABLE IF NOT EXISTS users (
                                   id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                   username VARCHAR(255) NOT NULL,
                                   email    VARCHAR(255) NOT NULL,
                                   password VARCHAR(255) NOT NULL,
                                   img      TEXT,

                                   PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ads(
                                id        INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                user_id   INT UNSIGNED NOT NULL,
                                title  VARCHAR(255) NOT NULL,
                                description TEXT NOT NULL,
                                img       TEXT,

                                PRIMARY KEY (id),
                                FOREIGN KEY (user_id) REFERENCES team_adlister_db.users(id)
);

CREATE TABLE IF NOT EXISTS category(
                                     id                    INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                     category_name         varchar(255) NOT NULL,
                                     category_description  TEXT,
                                     PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ads_cat(
                                    ad_id   INT UNSIGNED NOT NULL,
                                    category_id  INT UNSIGNED NOT NULL,
                                    FOREIGN KEY (ad_id) REFERENCES team_adlister_db.ads(id),
                                    FOREIGN KEY (category_id) REFERENCES team_adlister_db.category(id)
);


-- Creating a table for messages:
DROP TABLE IF EXISTS messages;

CREATE TABLE IF NOT EXISTS messages(
                                    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                    date DATETIME NOT NULL,
                                    sender_id INT UNSIGNED NOT NULL,
                                    recipient_id INT UNSIGNED NOT NULL,
                                    ad_id INT UNSIGNED NOT NULL,
                                    body TEXT NOT NULL,
                                    PRIMARY KEY (id),
                                    FOREIGN KEY (sender_id) REFERENCES team_adlister_db.users(id),
                                    FOREIGN KEY (recipient_id) REFERENCES team_adlister_db.users(id),
                                    FOREIGN KEY (ad_id) REFERENCES team_adlister_db.ads(id)
);

DROP DATABASE team_adlister_db;

DROP TABLE team_adlister_db.users;

SELECT * FROM users WHERE id = 5;
