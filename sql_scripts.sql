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

CREATE TABLE roles (
	role_id INT auto_increment primary key,
    role_name VARCHAR(20)
);

ALTER TABLE users
ADD COLUMN role_id INT;

ALTER TABLE users
ADD CONSTRAINT fk_role
FOREIGN KEY (role_id) REFERENCES roles(role_id);

SELECT * FROM users;

SELECT LAST_INSERT_ID();

truncate users;

SELECT ifnull(false) FROM users AS U WHERE U.username LIKE 'abc';

INSERT INTO roles(role_name)
VALUE ('USER'),
	  ('ADMIN');
      
SELECT * FROM roles;




