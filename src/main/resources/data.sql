DROP TABLE IF EXISTS PHONE CASCADE;
DROP TABLE IF EXISTS USER_NISUM CASCADE;
CREATE TABLE PHONE (PHONE_ID BIGINT GENERATED BY DEFAULT AS IDENTITY, CITY_CODE VARCHAR(255), COUNTRY_CODE VARCHAR(255), NUMBER VARCHAR(255), USER_ID VARCHAR(255), PRIMARY KEY (PHONE_ID));
CREATE TABLE USER_NISUM (IS_ACTIVE BOOLEAN, CREATED_AT TIMESTAMP(6), LAST_LOGIN TIMESTAMP(6), UPDATED_AT TIMESTAMP(6), EMAIL VARCHAR(255), NAME VARCHAR(255), PASSWORD VARCHAR(255), TOKEN VARCHAR(255), USER_ID VARCHAR(255) NOT NULL, PRIMARY KEY (USER_ID));
ALTER TABLE IF EXISTS PHONE ADD CONSTRAINT FKQCAW46NOBRW33YVK2YHIJY4OO FOREIGN KEY (USER_ID) REFERENCES USER_NISUM;

INSERT INTO USER_NISUM (USER_ID,IS_ACTIVE, CREATED_AT, LAST_LOGIN, UPDATED_AT, EMAIL, NAME, PASSWORD, TOKEN)
    VALUES ('433f9846-60a0-463d-9b23-934b2b04f82c', true, '2023-06-23 12:34:56','2023-06-23 12:34:56','2023-06-23 12:34:56', 'andrey@hotmail.com', 'Andrey', 'andrey123','eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbmRyZXlAaG90bWFpbC5jb20iLCJpYXQiOjE2ODc2NDA2NTR9.h86iqnMm6oMfoa0XVZ1inoiMkPASheZYtPSXKiYylHo');

INSERT INTO PHONE (PHONE_ID, CITY_CODE, COUNTRY_CODE, NUMBER, USER_ID)
    VALUES (3, '1', '57','3123123123','433f9846-60a0-463d-9b23-934b2b04f82c');