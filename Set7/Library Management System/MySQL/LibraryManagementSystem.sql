CREATE DATABASE Library IF NOT EXISTS;

SHOW DATABASES;

USE Library;

CREATE TABLE member(
	MemberID INT AUTO_INCREMENT PRIMARY KEY,
	Name VARCHAR(255) NOT NULL,
	Password VARCHAR(255) NOT NULL,
	CheckOutCount INT DEFAULT 0,
	Fine INT DEFAULT 0
);

SHOW TABLES;

INSERT INTO member (Name, Password) VALUES ("Hari Prasad", "hari345"), ("Gokul", "23gokuL"), ("Krishnan", "Hkris65");

SELECT * FROM member;

CREATE TABLE book(
	BookID INT AUTO_INCREMENT PRIMARY KEY,
	Title VARCHAR(255) NOT NULL,
	Author VARCHAR(255) NOT NULL,
	SubjectCategory VARCHAR(255) NOT NULL,
	PublicationDate VARCHAR(255) NOT NULL,
	RackNumber INT NOT NULL,
	NoOfBookItems INT NOT NULL
);

INSERT INTO book (Title, Author, SubjectCategory, PublicationDate, RackNumber, NoOfBookItems) VALUES ("Wish I Could Tell You", "Durjoy Datta","Fiction", "4 October 2019", 1, 10), ("The Monk Who Sold His Ferrari", "Robin Sharma", "Fiction", "25 September 2003", 1, 10), ("The Alchemist", "Paulo Coelho", "Quest,Adventure,Fantasy", "17 October 2005", 1, 1), ("To Kill a Mockingbird", "Harper Lee", "Thriller,Fiction", "11 July 1960", 2, 15), ("Good Vibes Good Life", "Vex King", "Personal Development,Psychology,Nonfiction,Self Help", "20 January 2019", 2, 20), ("Gray Mountain", "John Grisham", "Thriller", "21 October 2014", 3, 10), ("As a Man Thinketh", "James Allen", "Self Help", "11 January 2006", 3, 30);

SELECT * FROM book WHERE BookID=1;

CREATE TABLE checkout(
	CheckoutID INT AUTO_INCREMENT PRIMARY KEY,
	MemberID INT,
	BookID INT,
	FOREIGN KEY(MemberID) REFERENCES member(MemberID),
	FOREIGN KEY(BookID) REFERENCES book(BookID),
	DueDate DATE
);

INSERT INTO checkout(MemberID, BookID, DueDate) VALUES (1, 2, curdate());

CREATE TABLE reserve(
	ReserveID INT AUTO_INCREMENT,
	MemberID INT,
	BookID INT,
	PRIMARY KEY(ReserveID),
	FOREIGN KEY(MemberID) REFERENCES member(MemberID),
	FOREIGN KEY(BookID) REFERENCES book(BookID)
);

INSERT INTO reserve(MemberID, BookID) VALUES (1, 3);
