create table role(
    id bigint not null auto_increment,
    name varchar(50) not null
    primary key(id)
);

insert into role values(1,'Analyst')
insert into role values(2,'Manager')
insert into role values(3,'Director')