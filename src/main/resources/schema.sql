create table if not exists employee (
	id identity auto_increment,
	name varchar(100) not null,
	surname varchar(100) not null,
	oib varchar(11) not null unique,
	email varchar(100) not null,
	date_of_birth date not null,
	department_id bigint,
	role_id bigint,
	date_of_employment date not null,
	constraint fk_department foreign key (department_id) references department(id),
	constraint fk_role foreign key (role_id) references role(id)
);


create table if not exists department(
	id identity auto_increment,
	name varchar(50) not null
);

create table if not exists role(
	id identity auto_increment,
	name varchar(50) not null
);

create table if not exists asset (
	id identity auto_increment,
	name varchar(100) not null,
	serial_number varchar(100) not null,
	product_number varchar(100) not null,
	type_id bigint,
	date_of_purchase date not null,
	inventory_number varchar(50) not null,
	status varchar(20) not null,
	date_of_disposal date not null,
	constraint fk_type foreign key (type_id) references type(id)
);

create table if not exists type (
	id identity auto_increment,
	name varchar(50) not null
);

create table if not exists employee_asset (
    id identity auto_increment,
    employee_id bigint,
    asset_id bigint,
    constraint fk_student foreign key (employee_id) references employee(id),
    constraint fk_course foreign key (asset_id) references asset(id)
);

