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

CREATE TABLE permissions (
	permission_name VARCHAR(30) primary key,
    description VARCHAR(200)
);

CREATE TABLE roles_permissions (
	role_id INT,
    permission_name VARCHAR(30) ,
    
    PRIMARY KEY(role_id, permission_name)
);

ALTER TABLE roles_permissions
ADD CONSTRAINT fk_roles_permissions_roles
foreign key (role_id) references roles(role_id);

ALTER TABLE roles_permissions
ADD CONSTRAINT fk_roles_permissions_permissions
foreign key (permission_name) references permissions(permission_name);

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

-- INSERT INTO permissions(permission_name, description)
--                 VALUES ('UPDATE_DATA','Update date permission');
                
SELECT * FROM permissions;



