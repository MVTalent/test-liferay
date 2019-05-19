create table ZSKP_Kind (
	id_ bigserial primary key,
	code_ VARCHAR(75) not null,
	name VARCHAR(75) not null
);

insert into ZSKP_Kind (code_, name) values ('absence', 'Отсутствие');
insert into ZSKP_Kind (code_, name) values ('holiday', 'Отпуск');
insert into ZSKP_Kind (code_, name) values ('application', 'Заявки');
insert into ZSKP_Kind (code_, name) values ('corporate_applications', 'Общекорпоративные заявки');

create table ZSKP_Process (
	id_ bigserial primary key,
	name VARCHAR(75) not null,
	type_ bigint,
	kind bigint
);

create table ZSKP_Type (
	id_ bigserial primary key,
	code_ VARCHAR(75) not null,
	name VARCHAR(75) not null
);