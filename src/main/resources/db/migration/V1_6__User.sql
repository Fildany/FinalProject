CREATE table user
(
    id       bigint primary key auto_increment,
    email    varchar(255) not null unique,
    password varchar(255) not null
)