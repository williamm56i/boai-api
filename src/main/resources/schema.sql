DROP TABLE IF EXISTS SYS_CODE;
DROP TABLE IF EXISTS SYS_USER;
DROP TABLE IF EXISTS SYS_ROLE;
DROP TABLE IF EXISTS SYS_REL_USER_ROLE;
DROP TABLE IF EXISTS ABOUT_INFO;

CREATE TABLE SYS_CODE (
  SYS_GROUP VARCHAR(10) ,
  SYS_NAME VARCHAR(20) ,
  SYS_VALUE VARCHAR(250) ,
  MEMO VARCHAR(250) ,
  CREATE_ID VARCHAR(10) ,
  CREATE_DATE DATE ,
  UPDATE_ID VARCHAR(10) ,
  UPDATE_DATE DATE,
  PRIMARY KEY(SYS_GROUP,SYS_NAME)
);
CREATE TABLE SYS_USER (
    ACCOUNT VARCHAR(30),
    USER_NAME VARCHAR(100),
    EMAIL VARCHAR(100),
    CREATE_ID VARCHAR(10) ,
    CREATE_DATE DATE ,
    UPDATE_ID VARCHAR(10) ,
    UPDATE_DATE DATE,
    PRIMARY KEY(ACCOUNT)
);
CREATE TABLE SYS_ROLE (
    ROLE_ID VARCHAR(30),
    ROLE_NAME VARCHAR(100),
    CREATE_ID VARCHAR(10) ,
    CREATE_DATE DATE ,
    UPDATE_ID VARCHAR(10) ,
    UPDATE_DATE DATE,
    PRIMARY KEY(ROLE_ID)
);
CREATE TABLE SYS_REL_USER_ROLE (
    ACCOUNT VARCHAR(30),
    ROLE_ID VARCHAR(30),
    CREATE_ID VARCHAR(10) ,
    CREATE_DATE DATE ,
    PRIMARY KEY(ACCOUNT, ROLE_ID)
);
CREATE TABLE ABOUT_INFO (
    ID VARCHAR(3),
    TITLE VARCHAR(60),
    SUBTITLE VARCHAR(150),
    IMAGE VARCHAR(100),
    CONTENT VARCHAR(300),
    ENABLE CHAR(1),
    CREATE_ID VARCHAR(10),
    CREATE_DATE DATE,
    UPDATE_ID VARCHAR(10),
    UPDATE_DATE DATE,
    PRIMARY KEY(ID)
);