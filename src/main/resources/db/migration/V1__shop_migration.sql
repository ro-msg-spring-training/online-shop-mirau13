drop table if exists base_entity;
drop table if exists customer;
drop table if exists hibernate_sequence;
drop table if exists hibernate_sequences;
drop table if exists location;
drop table if exists my_order;
drop table if exists order_revenue;
drop table if exists order_detail;
drop table if exists product;
drop table if exists product_category;
drop table if exists revenue;
drop table if exists stock;
drop table if exists supplier;
create table base_entity (id integer not null, primary key (id)) engine=InnoDB;
create table customer (id integer not null, email_address varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
create table hibernate_sequences (sequence_name varchar(255) not null, next_val bigint, primary key (sequence_name)) engine=InnoDB;
insert into hibernate_sequences(sequence_name, next_val) values ('default',0);
create table location (id integer not null, address_city varchar(255), address_country varchar(255), address_county varchar(255), address_street varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table my_order (id integer not null, address_city varchar(255), address_country varchar(255), address_county varchar(255), address_street varchar(255), created_at datetime, customer_id integer, shipped_from_id integer, primary key (id)) engine=InnoDB;
create table order_revenue (revenue_id integer not null, order_id integer not null) engine=InnoDB;
create table order_detail (id integer not null, quantity integer, my_order_id integer, product_id integer, primary key (id)) engine=InnoDB;
create table product (id integer not null, description varchar(255), image_url varchar(255), name varchar(255), price decimal(19,2), weight double precision, product_category_id integer, supplier_id integer, primary key (id)) engine=InnoDB;
create table product_category (id integer not null, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB;
create table revenue (id integer not null, date date, sum decimal(19,2), location_id integer, primary key (id)) engine=InnoDB;
create table stock (id integer not null, quantity integer, location_id integer, product_id integer, primary key (id)) engine=InnoDB;
create table supplier (id integer not null, name varchar(255), primary key (id)) engine=InnoDB;
alter table my_order add constraint FKfl2uk880wx9xddhjl29ns9yh8 foreign key (customer_id) references customer (id);
alter table my_order add constraint FKam4dpsmrvavvug1okepe8oqpi foreign key (shipped_from_id) references location (id);
alter table order_revenue add constraint FK4lc0il1wuxfdlxduxldkc2suf foreign key (order_id) references my_order (id);
alter table order_revenue add constraint FK8hn2ni9kmftog189bv5jeidya foreign key (revenue_id) references revenue (id);
alter table order_detail add constraint FKk5xeeb16q3qqp23u00uuab0n4 foreign key (my_order_id) references my_order (id);
alter table order_detail add constraint FKb8bg2bkty0oksa3wiq5mp5qnc foreign key (product_id) references product (id);
alter table product add constraint FKcwclrqu392y86y0pmyrsi649r foreign key (product_category_id) references product_category (id);
alter table product add constraint FK2kxvbr72tmtscjvyp9yqb12by foreign key (supplier_id) references supplier (id);
alter table revenue add constraint FK6xukepd8ssa1ok6iakkhp83p7 foreign key (location_id) references location (id);
alter table stock add constraint FK6t3m0kaf6fubuus331gf7xmn8 foreign key (location_id) references location (id);
alter table stock add constraint FKjghkvw2snnsr5gpct0of7xfcf foreign key (product_id) references product (id);