delete from employee;

insert into employee(id,name,surname,oib,email,date_of_birth,department_id,role_id, date_of_employment)
values(1,'Stjepan','Zivkovic','70705544333','szivk@tvz.hr',NOW(),1,2, now());

insert into department(name)
values ('IT');

insert into role(name)
values('korisnik');

insert into type(name)
values('laptop');

insert into asset(name,serial_number,product_number,type_id,date_of_purchase, inventory_number,status,date_of_disposal)
values('LENOVO','123456','654321', 1, NOW(),'111554','1', NOW());

insert into employee_asset(employee_id,asset_id)
values (1,1);

