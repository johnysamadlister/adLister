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




DROP DATABASE team_adlister_db;

DROP TABLE team_adlister_db.users;


SELECT * FROM users;

SELECT * FROM users LIMIT 2,2;
SELECT * FROM users LIMIT 4;

SELECT * FROM ads JOIN users ON users.id = ads.user_id WHERE ads.title LIKE '%samscamp%' OR ads.description LIKE '%samscamp%' OR users.username LIKE '%samscamp%';





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


SELECT * FROM ads
    JOIN ads_cat ON ads_cat.ad_id = ads.id
    JOIN category ON category.id = ads_cat.category_id
    JOIN users ON users.id = ads.user_id where user_id = 5;

select ads.title, ads.description, ads.img, category.category_name, users.username
from ads
join ads_cat on ads_cat.ad_id = ads.id
join category on category.id = ads_cat.category_id
join users on users.id = ads.user_id;

select ads.title, ads.description, users.username, category.category_name
from ads
join users on users.id = ads.user_id
join ads_cat on ads_cat.ad_id = ads.id
join category on category.id = ads_cat.category_id;
