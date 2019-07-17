CREATE DATABASE day10_UserLogin;
USE day10_UserLogin;
CREATE TABLE USER(
  id INT PRIMARY KEY AUTO_INCREMENT,
  username varchar(32) unique not null,
  password varchar(32) not null
);