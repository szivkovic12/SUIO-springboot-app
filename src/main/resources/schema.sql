create table if not exists employee (
id identity,
name varchar(100) not null,
surname varchar(100) not null,
oib varchar(11) not null unique,
email varchar(100) not null,
date_of_birth date not null,
department_id bigint,
role_id bigint,
date_of_employment date not null
);

