create table Person (
	id bigint(20) unsigned not null auto_increment,
	name varchar(255) not null,
	address varchar(255) not null,
	primary key (id)
) charset=utf8;

show tables;

desc Person;

select * from Person;