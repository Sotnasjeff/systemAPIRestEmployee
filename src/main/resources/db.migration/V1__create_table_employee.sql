create table employee(
    id bigint not null auto_increment,
    name varchar(50) not null,
    cpf varchar(11) not null,
    role_id bigint not null,
    seniority varchar(20) not null,
    wage double not null,
    admission datetime not null,
    primary key(id),
    foreign key(role_id) references role(id)
);