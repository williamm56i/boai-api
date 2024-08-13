INSERT INTO SYS_USER (ACCOUNT, USER_NAME, EMAIL, CREATE_ID, CREATE_DATE, UPDATE_ID, UPDATE_DATE)
VALUES ('B0132', 'Tony', 'tony@gmail.com', 'SYS', NOW(), null, null);
INSERT INTO SYS_USER (ACCOUNT, USER_NAME, EMAIL, CREATE_ID, CREATE_DATE, UPDATE_ID, UPDATE_DATE)
VALUES ('GUEST', 'Guest', 'guest@gmail.com', 'SYS', NOW(), null, null);

INSERT INTO SYS_REL_USER_ROLE (ACCOUNT, ROLE_ID, CREATE_ID, CREATE_DATE)
VALUES ('B0132', 'ROLE_ADMIN', 'SYS' NOW());
INSERT INTO SYS_REL_USER_ROLE (ACCOUNT, ROLE_ID, CREATE_ID, CREATE_DATE)
VALUES ('GUEST', 'ROLE_GUEST', 'SYS' NOW());

INSERT INTO ABOUT_INFO (ID, TITLE, SUBTITLE, IMAGE, CONTENT, ENABLE, CREATE_ID, CREATE_DATE, UPDATE_ID, UPDATE_DATE)
VALUES ('0', '我支持，台灣無毒', '讓台灣成為無毒家園，反毒教育從小做起', '/boardgame.jpg', '讓台灣成為無毒家園，反毒教育從小做起讓台灣成為無毒家園，反毒教育從小做起', 'Y', 'system', NOW(), null, null);
INSERT INTO ABOUT_INFO (ID, TITLE, SUBTITLE, IMAGE, CONTENT, ENABLE, CREATE_ID, CREATE_DATE, UPDATE_ID, UPDATE_DATE)
VALUES ('1', '運算思維聯盟', '建立孩子解決問題的能力，從運算思維開始', '/little_scientist1.jpg', '建立孩子解決問題的能力，從運算思維開始建立孩子解決問題的能力，從運算思維開始', 'Y', 'system', NOW(), null, null);
INSERT INTO ABOUT_INFO (ID, TITLE, SUBTITLE, IMAGE, CONTENT, ENABLE, CREATE_ID, CREATE_DATE, UPDATE_ID, UPDATE_DATE)
VALUES ('2', '就是市集 All Hands', '由大量的閱讀，建立良好的思維', '/book.jpg', '由大量的閱讀，建立良好的思由大量的閱讀，建立良好的思', 'Y', 'system', NOW(), null, null);
INSERT INTO ABOUT_INFO (ID, TITLE, SUBTITLE, IMAGE, CONTENT, ENABLE, CREATE_ID, CREATE_DATE, UPDATE_ID, UPDATE_DATE)
VALUES ('3', '青銀共煮', '惜食，福利，跨世代共煮交流', '/cook.jpg', '惜食，福利，跨世代共煮交流惜食，福利，跨世代共煮交流', 'Y', 'system', NOW(), null, null);