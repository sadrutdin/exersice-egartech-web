
create table product_info
(
	id serial not null
		constraint product_info_pk
			primary key,
	serial_id varchar(36) not null,
	product_name varchar(60) not null,
	product_description varchar(100),
	serial_date date,
	details_id int
);

comment on table product_info is 'инфо о продуктах из xml';

create table created_orders
(
	id serial not null		constraint created_orders_pkey			primary key,
	customer_name varchar(90) not null,
	customer_address varchar(90) not null,
	sum bigint not null,
	created_datetime timestamp default now() not null,
	details_id integer-- references created_orders_details(order_id)
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
);

comment on column created_orders_details.serial_id is 'Серийный номер товара';

alter table created_orders_details owner to postgres;
