-- we don't know how to generate root <with-no-name> (class Root) :(
create table created_orders
(
	id serial not null
		constraint created_orders_pkey
			primary key,
	customer_name varchar(90) not null,
	customer_address varchar(90) not null,
	sum bigint not null,
	created_datetime timestamp default now() not null,
	details integer not null
);

comment on table created_orders is 'Таблица созданных заказов';

comment on column created_orders.id is 'ID заказа';

comment on column created_orders.customer_name is 'Имя покупателя';

comment on column created_orders.customer_address is 'Адрес покупателя';

comment on column created_orders.sum is 'Сумма заказов';

comment on column created_orders.created_datetime is 'Дата создания';

alter table created_orders owner to postgres;

create table created_orders_details
(
	id serial not null
		constraint created_orders_details_pkey
			primary key,
	serial_id varchar(36),
	count integer,
	order_id integer
		constraint created_orders_details_created_orders_id_fk
			references created_orders
);

comment on column created_orders_details.serial_id is 'Серийный номер товара';

alter table created_orders_details owner to postgres;

create table product_info
(
	id serial not null
		constraint product_info_pk
			primary key,
	serial_id varchar(36) not null,
	product_name varchar(60) not null,
	product_description varchar(100),
	serial_date date
);

comment on table product_info is 'инфо о продуктах из xml';

alter table product_info owner to postgres;

create unique index product_info_id_uindex
	on product_info (id);

