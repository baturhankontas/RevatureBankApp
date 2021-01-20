DROP TABLE person;
CREATE TABLE person (
    username VARCHAR2(25),
    password VARCHAR2(25),
    name VARCHAR2(25),
    USER_ID NUMBER(10) PRIMARY KEY,
    sysadmin VARCHAR2(1) CHECK (sysadmin IN('Y','N'))
);


CREATE TABLE accounts(
    accountName VARCHAR2(25),
	BANK_ACCOUNT_ID NUMBER(10),
	currentBalance NUMBER(10),
	USER_ID NUMBER(10)
);

ALTER TABLE accounts ADD CONSTRAINT fk_person_accounts FOREIGN KEY
(USER_ID) REFERENCES person(USER_ID) ON DELETE CASCADE;
------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE add_person(username VARCHAR2, password VARCHAR2, name VARCHAR2, sysadmin VARCHAR2)
IS
BEGIN
INSERT INTO person VALUES (username, password, name, actor_seq.nextval, sysadmin);

END;
-------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE add_accounts(accountName VARCHAR2, USER_ID NUMBER)
IS 
BEGIN
INSERT INTO accounts VALUES(accountName, account_id_seq.nextval, 0, USER_ID);
END;
-------------------------------------------------------------------
ALTER TABLE accounts DROP CONSTRAINT fk_person_accounts;

Select * From Person;
Select * From Accounts;
-------------------------------------------------------------------
CREATE SEQUENCE userid_seq
    START WITH 1
    INCREMENT BY 1;
CREATE SEQUENCE account_id_seq
    START WITH 1
    INCREMENT BY 1;
-------------------------------------------------------------------    
DELETE person;
DELETE accounts;

CALL add_person('super', 'user','SUPERUSER', 'Y');

