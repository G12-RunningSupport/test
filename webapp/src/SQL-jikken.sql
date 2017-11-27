--For gorup12
INSERT INTO UserInfo(Id,Birth,Sex,Height) values ('Yamada','1998-04-02',0,170);
INSERT INTO UserInfo(Id,Birth,Sex,Height) values ('Tanaka','1990-3-31',1,150);
INSERT INTO Cal(Id,Date,Weight,Cal) values ('Yamada','2017-5-16',97,3600);
INSERT INTO Cal(Id,Date,Weight,Cal) values ('Yamada','2017-10-3',65,2400);
INSERT INTO Cal(Id,Date,Weight,Cal) values ('Tanaka','2017-5-3',44,1400);
INSERT INTO Cal(Id,Date,Weight,Cal) values ('Tanaka','2017-7-7',46,2000);
INSERT INTO Cal(Id,Date,Weight,Cal) values ('Tanaka','2017-10-3',43,1000);
INSERT INTO Route(Id,Date,No,Distance,Start,Finish) values ('Yamada','2017-5-16',1,2000,'12:11:32','12:20:01');
INSERT INTO Route(Id,Date,No,Distance,Start,Finish) values ('Yamada','2017-5-16',2,2000,'17:33:00','17:43:01');
INSERT INTO Route(Id,Date,No,Distance,Start,Finish) values ('Tanaka','2017-7-7',1,10000,'19:00:00','20:30:00');
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
	Cal INTEGER,
	PRIMARY KEY (Id,Date)
);
CREATE TABLE Route(
	Id VARCHAR(16),
	Date DATE,
	No INTEGER,
	Distance INTEGER,
	Start TIME,
	Finish TIME,
	PRIMARY KEY (Id, No)
);
--------------------------------------------------------------------------------------------
-- 一旦、既存のテーブルを削除する
DROP TABLE Student;
DROP TABLE Grade;

-- まず、学生を管理する Student という名前のテーブルを作成する
CREATE TABLE Student (
  Id INTEGER,
  Name VARCHAR(128),
  Gpa FLOAT,
  PRIMARY KEY (Id)
);

-- 次に、成績を管理する Grade という名前のテーブルを作成する
CREATE TABLE Grade (
  Class VARCHAR(128),
  Score VARCHAR(1),
  Id INTEGER,
  FOREIGN KEY (Id) REFERENCES Student
);

-- まず、Student テーブルにデータを格納する。
INSERT INTO Student(Id,Name,Gpa) 
  VALUES(12300,'山田太郎',3.5);
INSERT INTO Student(Id,Name,Gpa) 
  VALUES(12301,'鈴木次郎',4.0);
INSERT INTO Student(Id,Name,Gpa) 
  VALUES(12302,'田中三郎',3.8);

-- 次に、Grade テーブルにデータを格納する。
INSERT INTO Grade(Class,Score,Id) 
  VALUES('電子回路','B',12302);
INSERT INTO Grade(Class,Score,Id)
  VALUES('交流理論','A',12300);
INSERT INTO Grade(Class,Score,Id) 
  VALUES('プログラミング','C',12301);
INSERT INTO Grade(Class,Score,Id) 
  VALUES('歴史','A',12302);
