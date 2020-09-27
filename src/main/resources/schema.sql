CREATE TABLE ITEMS(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(128) NOT NULL,
  PRICE NUMERIC NOT NULL,
  DESCRIPTION VARCHAR(256),
  basket_id bigint not null
);

create table users
(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    username        varchar(40) unique not null,
    password        varchar(255) not null
);

create table user_role
(
    id bigint not null,
    roles    varchar(255)
);

create table baskets
(
    id bigint primary key AUTO_INCREMENT,
    user_id bigint not null
);

alter table user_role
    add foreign key (id) references users (ID);

alter table baskets
    add foreign key (user_id) references users (id);

alter table items
    add foreign key (basket_id) references baskets (id);