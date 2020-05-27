delete from employee_asset;
delete from asset;
delete from employee;
delete from department;
delete from role;
delete from type;
delete from user_authority;
delete from user;
delete from authority;

insert into employee(id,name,surname,oib,email,date_of_birth,department_id,role_id, date_of_employment)
values(1,'Stjepan','Zivkovic','70705544242','szivk@tvz.hr',NOW(),1,2, NOW());
	
insert into employee(id,name,surname,oib,email,date_of_birth,department_id,role_id, date_of_employment)
values(2,'Miroslav','Vranic','67678811221','miro@tvz.hr',NOW(),1,2, NOW());

insert into employee(id,name,surname,oib,email,date_of_birth,department_id,role_id, date_of_employment)
values(3,'Tin','Topolovec','98765432112','tin@tvz.hr',NOW(),1,2, NOW());


insert into department(id,name)
values (1,'IT');

insert into role(id,name)
values(1,'korisnik');

insert into asset(id,name,serial_number,product_number,type_id,date_of_purchase, inventory_number,status,date_of_disposal)
values(1,'LENOVO','123456','654321', 1, NOW(),'111554','1', NOW());

insert into type(id,name)
values(1,'laptop');

insert into employee_asset(employee_id,asset_id)
values (1,1);

insert into user (id, username, password, first_name, last_name)
                values (1, 'admin', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'admin', 'admin'); -- password je 'test'
insert into user (id, username, password, first_name, last_name)
                values (2, 'user', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'user', 'user'); -- password je 'test'
insert into authority (id, name) 
                values (1, 'ADMIN');
insert into authority (id, name) 
                values (2, 'USER');
insert into user_authority (user_id, authority_id) 
                values (1, 1);
insert into user_authority (user_id, authority_id)
                values (2, 2);