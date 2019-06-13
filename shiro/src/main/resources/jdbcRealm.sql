create database shiro;
use shiro;
create table users (
    id int primary key auto_increment,
    username varchar(50),
    password varchar(32),
    password_salt varchar(32)
);
insert into users (username, password) values ('Jack', '123');

create table user_roles (
    id int primary key auto_increment,
    username varchar(50),
    role_name varchar(50)
);
insert into user_roles (username, role_name) values ('Jack', 'admin');
insert into user_roles (username, role_name) values ('Jack', 'user');

create table roles_permissions (
    id int primary key auto_increment,
    role_name varchar(50),
    permission varchar(100)
);
insert into roles_permissions (role_name, permission) values ('admin', 'user:select');
insert into roles_permissions (role_name, permission) values ('admin', 'user:add');
insert into roles_permissions (role_name, permission) values ('admin', 'user:update');
insert into roles_permissions (role_name, permission) values ('admin', 'user:delete');
insert into roles_permissions (role_name, permission) values ('user', 'user:select');

create table t_users (
                       id int primary key auto_increment,
                       username varchar(50),
                       password varchar(32),
                       password_salt varchar(32)
);
insert into t_users (username, password) values ('Tom', '123');

create table t_user_roles (
                            id int primary key auto_increment,
                            username varchar(50),
                            role_name varchar(50)
);
insert into t_user_roles (username, role_name) values ('Tom', 'admin');
insert into t_user_roles (username, role_name) values ('Tom', 'user');

create table t_roles_permissions (
                                   id int primary key auto_increment,
                                   role_name varchar(50),
                                   permission varchar(100)
);
insert into t_roles_permissions (role_name, permission) values ('admin', 'user:select');
insert into t_roles_permissions (role_name, permission) values ('admin', 'user:add');
insert into t_roles_permissions (role_name, permission) values ('admin', 'user:update');
insert into t_roles_permissions (role_name, permission) values ('admin', 'user:delete');
insert into t_roles_permissions (role_name, permission) values ('user', 'user:select');
