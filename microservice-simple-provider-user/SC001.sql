--create database SC001;

use SC001;

show tables;


create table user(
	id bigint not null comment 'ID',
	username varchar(40) comment '登录名',
	name varchar(20) comment '名称',
	age int(3) comment '年龄',
	balance decimal(10,2) comment '收入',
	primary key (id)
) engine=InnoDB default charset=utf8;

insert into user(id, username, name, age, balance) values(1, 'account1', '张三', 20, 100.00);
insert into user(id, username, name, age, balance) values(2, 'account2', '李四', 28, 180.00);
insert into user(id, username, name, age, balance) values(3, 'account3', '王五', 32, 280.00);

select * from user;












