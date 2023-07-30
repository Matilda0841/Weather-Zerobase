USE weather1;

# CREATE TABLE MEMO(
#     id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
#     text VARCHAR(50)NOT NULL
# );
#
# SELECT * FROM memo;

# DROP TABLE  MEMO;

CREATE TABLE diary
(
    id          INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    weather     VARCHAR(50)  not null,
    icon        VARCHAR(50)  NOT NULL,
    temperature DOUBLE       NOT NULL,
    text        VARCHAR(500) NOT NULL,
    date        DATE         NOT NULL
);

SELECT *
FROM diary;

CREATE TABLE date_weather
(
    date        DATE        NOT NULL PRIMARY KEY,
    weather     VARCHAR(50) NOT NULL,
    icon        VARCHAR(50) NOT NULL,
    temperature DOUBLE      NOT NULL
)