INSERT INTO easy_tickets (userId, name, age, email, address, phone, sport, ticket) VALUES 
(1, 'Jon', 33, 'jon@gmail.com', 'Toronto', 45678, 'BasketBall', 'Adult - $20'),
(2, 'Dixant', 20, 'dixant@gmail.com', 'Milton', 111222, 'Football', 'Adult - $20'),
(2, 'Dixant', 20, 'dixant@gmail.com', 'Milton', 100002, 'Cricket', 'Adult - $20'),
(3, 'Xd', 12, 'xd@gmail.com', 'Kitchner', 1234, 'Cricket', 'Children - $10'),
(3, 'Xd', 12, 'xd@gmail.com', 'Kitchner', 56755565, 'Soccer', 'Children - $10'),
(4, 'Ton', 55, 'ton@gmail.com', 'ottawa', 10001, 'Soccer', 'Adult - $20'),
(4, 'Ton', 55, 'ton@gmail.com', 'ottawa', 12323, 'Football', 'Adult - $20'),
(5, 'Don', 10, 'don@gmail.com', 'Brampton', 112222, 'Badminton', 'Children - $10'),
(5, 'Don', 10, 'don@gmail.com', 'ottawa', 453522, 'Badminton', 'Children - $10'),
(6, 'Gon', 55, 'gon@gmail.com', 'ottawa', 233001, 'Cricket', 'Adult - $20');

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Jon', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Dixant', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Xd', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Ton', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Don', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Gon', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into sec_role (roleName)
values ('ROLE_VENDER');
 
insert into sec_role (roleName)
values ('ROLE_GUEST');
 
insert into user_role (userId, roleId)
values (1, 1);
 
insert into user_role (userId, roleId)
values (2, 2);

insert into user_role (userId, roleId)
values (3, 2);

insert into user_role (userId, roleId)
values (4, 2);

insert into user_role (userId, roleId)
values (5, 2);

insert into user_role (userId, roleId)
values (6, 2);
