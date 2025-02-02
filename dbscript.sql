create database order_service_db;
use order_service_db;

create table orders(
	order_id int primary key auto_increment,
    order_date int,
    delivery_date int,
    order_amount float,
    customer_id int);
