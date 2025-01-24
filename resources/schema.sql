CREATE TABLE easy_tickets (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
userId INT,
name VARCHAR(16),  
age double,
email VARCHAR(30),
address VARCHAR(30),
phone int,
sport VARCHAR(30),
ticket VARCHAR(30));  

create table SEC_USER
(
  userId           BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  userName         VARCHAR(36) NOT NULL UNIQUE,
  encryptedPassword VARCHAR(128) NOT NULL,
  ENABLED           BIT NOT NULL 
) ;


create table SEC_ROLE
(
  roleId   BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  roleName VARCHAR(30) NOT NULL UNIQUE
) ;


create table USER_ROLE
(
  ID      BIGINT NOT NULL Primary Key AUTO_INCREMENT,
  userId BIGINT NOT NULL,
  roleId BIGINT NOT NULL
);

alter table USER_ROLE
  add constraint USER_ROLE_UK unique (userId, roleId);

alter table USER_ROLE
  add constraint USER_ROLE_FK1 foreign key (userId)
  references SEC_USER (userId);
 
alter table USER_ROLE
  add constraint USER_ROLE_FK2 foreign key (roleId)
  references SEC_ROLE (roleId);

