create table users
(
    id       int auto_increment
        primary key,
    username varchar(30)  not null,
    password varchar(120) not null,
    email    varchar(40)  not null,
    role enum('ROLE_ADMIN', 'ROLE_MODERATOR', 'ROLE_SPONSOR', 'ROLE_CUSTOM') not null,
    constraint users_email_uindex
        unique (email)
);