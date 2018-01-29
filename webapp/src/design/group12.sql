DROP TABLE UserInfo;
DROP TABLE Cal;
DROP TABLE Route;

SELECT* FROM UserInfo;
SELECT* FROM Cal;
SELECT* FROM Route;

SELECT* FROM UserInfo Where Id='aaa';
SELECT id FROM UserInfo;

CREATE TABLE UserInfo(
	Id VARCHAR(16),
	Birth DATE,
	Sex INTEGER,
	Height INTEGER,
	PRIMARY KEY (Id)
);
CREATE TABLE Cal(
	Id VARCHAR(16),
	Date DATE,
	Weight FLOAT,
	Cal INTEGER, /*摂取したカロリー*/
	FOREIGN KEY(Id) REFERENCES UserInfo
);
CREATE TABLE Route(
	Id VARCHAR(16),
	Date DATE,
	No INT, /*回数*/
	Distance INT,
	Start TIME,
	Finish TIME,
	PRIMARY KEY(No),
	FOREIGN KEY(Id) REFERENCES UserInfo
);

INSERT INTO UserInfo(Id,Birth,Sex,Height) VALUE ('kosentarou','2017-12-4',0,160);
INSERT INTO Cal(Id,Date,Weight,Cal) VALUE ('kosentarou','2017-12-11',54.3,123);
INSERT INTO Route(Id,Date,No,Distance,Start,Finish) VALUE ('kosentarou','2017-12-11',1,10,'12:10:00','12:20:00');

INSERT INTO Cal(Id,Date,Weight,Cal) VALUE ('ito','2017-12-11',54.3,123);
INSERT INTO Route(Id,Date,No,Distance,Start,Finish) VALUE ('ito','2017-12-11',1,10,'12:10:00','12:20:00');

INSERT INTO Cal(Id,Date,Weight,Cal) VALUE ('mori','2017-12-11',54.3,123);


DELETE FROM UserInfo WHERE Id='aa';
DELETE FROM Cal WHERE Id='kosentarou';
DELETE FROM Route WHERE Id='kosentarou';