CREATE DATABASE Library IF NOT EXISTS;

SHOW DATABASES;

USE Library;

CREATE TABLE member(
	MemberID INT AUTO_INCREMENT PRIMARY KEY,
	Name VARCHAR(255),
	Password VARCHAR(255),
	CheckOutCount INT DEFAULT 0,
	Fine INT DEFAULT 0
);

SHOW TABLES;

INSERT INTO member (Name, Password) VALUES ("Hari Prasad", "hari345"), ("Gokul", "23gokuL"), ("Krishnan", "Hkris65");

SELECT * FROM member;