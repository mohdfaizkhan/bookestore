DROP TABLE IF EXISTS TEST;
CREATE TABLE BOOK(
  	ID BIGINT(19) PRIMARY KEY,
	AUTHOR	VARCHAR(255),
	DESCRIPTION	VARCHAR(255),
	ISBN	INTEGER(10),
	NAME	VARCHAR(255),
	PRICE	DOUBLE(17),
	TYPE	VARCHAR(255)
);

INSERT INTO BOOK ("ID","AUTHOR", "DESCRIPTION", "ISBN", "NAME", "PRICE","TYPE") VALUES (1,'Faiz Khan','Java Books','00003','Head First Java', 600,'fiction');
INSERT INTO BOOK ("ID","AUTHOR", "DESCRIPTION", "ISBN", "NAME", "PRICE","TYPE") VALUES (2,'Imdad Areeph','Spring Books','00004','Spring In Action', 800,'comic');
INSERT INTO BOOK ("ID","AUTHOR", "DESCRIPTION", "ISBN", "NAME", "PRICE","TYPE") VALUES (3,'ABc Khan','Java Books','00003','Head First', 1000,'fiction');