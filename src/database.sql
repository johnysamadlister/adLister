


# Stop Here







DROP DATABASE team_adlister_db;










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
    JOIN users ON users.id = ads.user_id;

select ads.title, ads.description, ads.img, category.category_name, users.username
from ads
join ads_cat on ads_cat.ad_id = ads.id
join category on    category.id = ads_cat.category_id
join users on users.id = ads.user_id;

select ads.title, ads.description, users.username, category.category_name
from ads
join users on users.id = ads.user_id
join ads_cat on ads_cat.ad_id = ads.id
join category on category.id = ads_cat.category_id;

SELECT * FROM category JOIN ads_cat ON ads_cat.category_id   = category.id WHERE ad_id = 4;

INSERT INTO category(category_name,category_description) VALUES ('AutoMobile','a road vehicle, typically with four wheels, powered by an internal combustion engine or electric motor and able to carry a small number of people.');
INSERT INTO category(category_name,category_description) VALUES ('Electronic','A device having or operating with the aid of many small components, especially microchips and transistors, that control and direct an electric current.');
INSERT INTO category(category_name,category_description) VALUES ('Tools','a device or implement, especially one held in the hand, used to carry out a particular function.');
INSERT INTO category(category_name,category_description) VALUES ('Job','A paid position of regular employment.');
INSERT INTO category(category_name,category_description) VALUES ('Game','A form of play or sport, especially a competitive one played according to rules and decided by skill, strength, or luck.');
INSERT INTO category(category_name,category_description) VALUES ('Toys','An object for a child to play with, typically a model or miniature replica of something.');

SELECT  FROM category WHERE category_name = 'Toys';

SELECT * FROM users;