CREATE TABLE Users (
    ID varchar(36) NOT NULL PRIMARY KEY,
    LastName varchar(50),
    FirstName varchar(50),
    loginname varchar(100),
    wechat_account varchar(100),
    phone varchar(25),
    age int,
    email varchar(100),
    birthDay date,
    address varchar(255),   
);
