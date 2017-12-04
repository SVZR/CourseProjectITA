CREATE DATABASE coinsite DEFAULT CHARACTER SET utf8;
USE coinsite;

CREATE TABLE IF NOT EXISTS user (id INT AUTO_INCREMENT, login VARCHAR(50) UNIQUE NOT NULL, password VARCHAR(50),
                                 email VARCHAR(50) UNIQUE NOT NULL, role VARCHAR(50), PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS metal (id INT AUTO_INCREMENT, name VARCHAR(50) UNIQUE NOT NULL, PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS country (id INT AUTO_INCREMENT, name VARCHAR(50) UNIQUE NOT NULL, PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS theme (id INT AUTO_INCREMENT, name VARCHAR(50) NOT NULL, country_id INT NOT NULL,
  PRIMARY KEY (id), FOREIGN KEY (country_id) REFERENCES country(id));

CREATE TABLE IF NOT EXISTS series (id INT AUTO_INCREMENT, name VARCHAR(50) NOT NULL, theme_id INT NOT NULL,
  PRIMARY KEY (id), FOREIGN KEY (theme_id) REFERENCES theme(id));

CREATE TABLE IF NOT EXISTS coin (id INT AUTO_INCREMENT, name VARCHAR(50) NOT NULL, series_id INT NOT NULL,
                                 releasedate DATE, designer VARCHAR(50), mintedby VARCHAR(50), description_obverse TEXT, description_reverse TEXT,
                                 image VARCHAR(50), PRIMARY KEY(id), FOREIGN KEY (series_id) REFERENCES series(id));

CREATE TABLE IF NOT EXISTS coindescription (id INT AUTO_INCREMENT, coin_id INT NOT NULL, metal_id INT NOT NULL, denomination INT,
                                            weight FLOAT, diameter FLOAT, mintage INT, image_obverse VARCHAR(50) UNIQUE NOT NULL, image_reverse VARCHAR(50) UNIQUE NOT NULL,
  PRIMARY KEY (id), FOREIGN KEY (coin_id) REFERENCES coin(id), FOREIGN KEY (metal_id) REFERENCES metal(id));

CREATE TABLE IF NOT EXISTS user_coindescription (id INT AUTO_INCREMENT, user_id INT NOT NULL, coindescription_id INT NOT NULL, amount INT NOT NULL,
  PRIMARY KEY (id), FOREIGN KEY (user_id) REFERENCES user(id), FOREIGN KEY (coindescription_id) REFERENCES coindescription(id));

CREATE TABLE IF NOT EXISTS sale (id INT AUTO_INCREMENT, user_coin_id INT NOT NULL, cost DECIMAL, PRIMARY KEY (id),
  FOREIGN KEY (user_coin_id) REFERENCES user_coindescription(id));

INSERT INTO user (login, password, email, role) VALUE ('admin', 'admin', 'admin@admin.by', 'ADMINISTRATOR');

INSERT INTO metal (name) VALUE ('gold');
INSERT INTO metal (name) VALUE ('silver');
INSERT INTO metal (name) VALUE ('copper-nikel');

INSERT INTO country (name) VALUE ('Republic of Belarus');
INSERT INTO country (name) VALUE ('Republic of Kazakhstan');
INSERT INTO country (name) VALUE ('Russian Federation');

SELECT * FROM country;

INSERT INTO theme (name, country_id) VALUE ('BELARUS AND THE WORLD COMMUNITY', 1);
INSERT INTO theme (name, country_id) VALUE ('BELARUSIAN HISTORY AND CULTURE', 1);
INSERT INTO theme (name, country_id) VALUE ('SPORTS', 1);
INSERT INTO theme (name, country_id) VALUE ('PROTECTION OF THE ENVIRONMENT', 1);
INSERT INTO theme (name, country_id) VALUE ('MY COUNTRY BELARUS', 1);

SELECT * FROM theme;

INSERT INTO series (name, theme_id) VALUE ('No theme', 1);
INSERT INTO series (name, theme_id) VALUE ('The 60th Anniversary of Liberation of the Republic of Belarus from the nazi invaders', 1);
INSERT INTO series (name, theme_id) VALUE ('The 60th Anniversary of Victory in the Great Patriotic war', 1);
INSERT INTO series (name, theme_id) VALUE ('Tales of the World’s Nations', 1);
INSERT INTO series (name, theme_id) VALUE ('Slavs\' Family Traditions', 1);
INSERT INTO series (name, theme_id) VALUE ('Orthodox Saints', 1);
INSERT INTO series (name, theme_id) VALUE ('Sailing Ships', 1);
INSERT INTO series (name, theme_id) VALUE ('Signs of the Zodiac', 1);
INSERT INTO series (name, theme_id) VALUE ('The Three Musketeers', 1);
INSERT INTO series (name, theme_id) VALUE ('Alexander Pushkin\'s Fairy Tales', 1);
INSERT INTO series (name, theme_id) VALUE ('Operation Bagration', 1);
INSERT INTO series (name, theme_id) VALUE ('Orthodox Churches', 1);
INSERT INTO series (name, theme_id) VALUE ('World of Sculpture Series', 1);
INSERT INTO series (name, theme_id) VALUE ('Orthodox Wonder-working Icons Series', 1);
INSERT INTO series (name, theme_id) VALUE ('Belarus\'s International Festivals Series', 1);
INSERT INTO series (name, theme_id) VALUE ('Magic of Dance', 1);
INSERT INTO series (name, theme_id) VALUE ('The Solar System Series', 1);
INSERT INTO series (name, theme_id) VALUE ('Chinese Calendar', 1);
INSERT INTO series (name, theme_id) VALUE ('Signs of the Zodiac. 2013', 1);
INSERT INTO series (name, theme_id) VALUE ('Orthodox Saints\' Lives Series', 1);
INSERT INTO series (name, theme_id) VALUE ('Zodiac Horoscope', 1);
INSERT INTO series (name, theme_id) VALUE ('Orthodox Saints. 2013', 1);
INSERT INTO series (name, theme_id) VALUE ('Skaryna\'s Way', 1);
INSERT INTO series (name, theme_id) VALUE ('No theme', 2);
INSERT INTO series (name, theme_id) VALUE ('Belarusian Cities', 2);
INSERT INTO series (name, theme_id) VALUE ('Belarusian Architectural Monuments', 2);
INSERT INTO series (name, theme_id) VALUE ('Belarusian Festivals and Rites', 2);
INSERT INTO series (name, theme_id) VALUE ('Strengthening and Defending the State', 2);
INSERT INTO series (name, theme_id) VALUE ('Belarusian Folk Legends', 2);
INSERT INTO series (name, theme_id) VALUE ('Belarusian Folk Trades and Crafts', 2);
INSERT INTO series (name, theme_id) VALUE ('Belarus\' Faiths Series', 2);
INSERT INTO series (name, theme_id) VALUE ('Belts of Slutsk', 2);
INSERT INTO series (name, theme_id) VALUE ('No theme', 3);
INSERT INTO series (name, theme_id) VALUE ('Olympic Belarus', 3);
INSERT INTO series (name, theme_id) VALUE ('No theme', 4);
INSERT INTO series (name, theme_id) VALUE ('Belarusian National Parks and Nature Reserves', 4);
INSERT INTO series (name, theme_id) VALUE ('Belarusian Nature Reserves', 4);
INSERT INTO series (name, theme_id) VALUE ('Bird of the Year', 4);
INSERT INTO series (name, theme_id) VALUE ('Horses', 4);
INSERT INTO series (name, theme_id) VALUE ('Belarusian Flowers', 4);
INSERT INTO series (name, theme_id) VALUE ('Beauty of Flowers', 4);
INSERT INTO series (name, theme_id) VALUE ('Butterflies', 4);
INSERT INTO series (name, theme_id) VALUE ('Revived Plants', 4);
INSERT INTO series (name, theme_id) VALUE ('My country Belarus', 5);

SELECT * FROM series;

INSERT INTO coin (name, series_id, releasedate, designer, mintedby, description_obverse, description_reverse, image) VALUES ('50th Anniversary of UN',
                                                                                                                             1, '19961227', 'A.Zimenko, D.Belitsky (Belarus)', 'The Royal Mint, London,Great Britain', 'features in the center the relief of the State Coat of Arms of the Republic of Belarus with the inscription in two lines beneath: "РЭСПУБЛIКА БЕЛАРУСЬ" (REPUBLIC OF BELARUS); at the bottom – face value, year of issue, precious metals coins – weight of the coin and alloy standard. ', 'features in the center – against the background of a geographic map of the Republic of Belarus – the relief of a hovering stork, in the lower left–hand part – the UN emblem and "50", along the rim – inscriptions separated by geometric ornament: "НАЦЫI, АБ\'ЯДНАНЫЯ ЗА MIP" (NATIONS UNITED FOR PEACE), "1 РУБЕЛЬ"
(1 ROUBLE).', 'http://www.nbrb.by/CoinsBanknotes/images/?id=523');
INSERT INTO coin (name, series_id, releasedate, designer, mintedby, description_obverse, description_reverse, image) VALUES ('cointest1', 2, '19990808',
                                                                                                                             'Somebody', 'Royal mint', 'obverse', 'reverse', 'imageadres1');
INSERT INTO coin (name, series_id, releasedate, designer, mintedby, description_obverse, description_reverse, image) VALUES ('cointest2', 2, '19990808',
                                                                                                                             'Somebody', 'Royal mint', 'obverse', 'reverse', 'imageadres2');
INSERT INTO coin (name, series_id, releasedate, designer, mintedby, description_obverse, description_reverse, image) VALUES ('cointest3', 13, '19990808',
                                                                                                                             'Somebody', 'Royal mint', 'obverse', 'reverse', 'imageadres3');
INSERT INTO coin (name, series_id, releasedate, designer, mintedby, description_obverse, description_reverse, image) VALUES ('cointest4', 5, '19990808',
                                                                                                                             'Somebody', 'Royal mint', 'obverse', 'reverse', 'imageadres4');

SELECT * FROM coin;

INSERT INTO coindescription (coin_id, metal_id, denomination, weight, diameter, mintage, image_obverse, image_reverse) VALUE (1, 1, 1, 8.71, 22.05, 5000, 'http://www.nbrb.by/CoinsBanknotes/images?id=512', 'http://www.nbrb.by/CoinsBanknotes/images?id=514');
INSERT INTO coindescription (coin_id, metal_id, denomination, weight, diameter, mintage, image_obverse, image_reverse) VALUE (1, 2, 1, 30.57, 38.61, 20000, 'http://www.nbrb.by/CoinsBanknotes/images?id=520', 'http://www.nbrb.by/CoinsBanknotes/images?id=522');
INSERT INTO coindescription (coin_id, metal_id, denomination, weight, diameter, mintage, image_obverse, image_reverse) VALUE (1, 3, 1, 28.28, 38.61, 40000, 'http://www.nbrb.by/CoinsBanknotes/images?id=524', 'http://www.nbrb.by/CoinsBanknotes/images?id=526');

SELECT * FROM coindescription;

INSERT INTO user_coindescription (user_id, coindescription_id, amount) VALUE (1, 1, 1);
INSERT INTO user_coindescription (user_id, coindescription_id, amount) VALUE (1, 2, 2);
INSERT INTO user_coindescription (user_id, coindescription_id, amount) VALUE (1, 3, 4);

SELECT * FROM user_coindescription;

INSERT INTO sale (user_coin_id, cost) VALUE (1, 235);
INSERT INTO sale (user_coin_id, cost) VALUE (2, 92);
INSERT INTO sale (user_coin_id, cost) VALUE (3, 40);

SELECT * FROM sale;

DROP TABLE user;
DROP TABLE metal;
DROP TABLE country;
DROP TABLE theme;
DROP TABLE series;
DROP TABLE coin;
DROP TABLE coindescription;
DROP TABLE user_coindescription;
DROP TABLE sale;

DROP DATABASE coinsite;
