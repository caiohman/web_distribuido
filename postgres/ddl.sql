create table users (
id bigserial ,
name varchar(50) not null ,
username varchar(50) not null unique,
userpassword varchar(255) not null unique,
primary key(id)
);

