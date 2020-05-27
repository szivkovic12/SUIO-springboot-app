delete from employee_asset;
delete from asset;
delete from employee;
delete from department;
delete from role;
delete from type;

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
values(1,'Laptop');
insert into type(id,name)
values(2,'Mobitel');
insert into type(id,name)
values(3,'Tablet');



insert into employee_asset(employee_id,asset_id)
values (1,1);