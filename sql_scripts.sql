CREATE DATABASE identity_service;
USE identity_service;

CREATE TABLE users (
	user_id VARCHAR(36) primary KEY DEFAULT(uuid()) ,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(200) NOT NULL,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    dob DATE
);

SELECT * FROM users;

SELECT LAST_INSERT_ID();

truncate users;

SELECT ifnull(false) FROM users AS U WHERE U.username LIKE 'abc';
