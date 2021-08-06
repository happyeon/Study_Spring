
--MYBOARD
DROP SEQUENCE MYNOSEQ;
DROP TABLE MYBOARD;

CREATE SEQUENCE MYNOSEQ;

CREATE TABLE MYBOARD(
	MYNO NUMBER PRIMARY KEY,
	MYNAME VARCHAR2(500) NOT NULL,
	MYTITLE VARCHAR2(1000) NOT NULL,
	MYCONTENT VARCHAR2(4000) NOT NULL,
	MYDATE DATE NOT NULL
);

INSERT INTO MYBOARD
VALUES(MYNOSEQ.NEXTVAL, '스프링', '개발자에게 봄이 왔다!', '요즘 날씨는 여름이다...', SYSDATE);

SELECT MYNO, MYNAME, MYTITLE, MYCONTENT, MYDATE
FROM MYBOARD
ORDER BY MYNO DESC;


--MYMEMBER
DROP SEQUENCE MYMEMBERSEQ;
DROP TABLE MYMEMBER;

CREATE SEQUENCE MYMEMBERSEQ;

CREATE TABLE MYMEMBER(
	MEMBERNO NUMBER PRIMARY KEY,
	MEMBERID VARCHAR2(1000) NOT NULL,
	MEMBERPW VARCHAR2(1000) NOT NULL,
	MEMBERNAME VARCHAR2(1000) NOT NULL
);

INSERT INTO MYMEMBER
VALUES(MYMEMBERSEQ.NEXTVAL, 'admin', 'admin1234', '관리자');

SELECT MEMBERNO, MEMBERID, MEMBERPW, MEMBERNAME
FROM MYMEMBER
ORDER BY MEMBERNO DESC;