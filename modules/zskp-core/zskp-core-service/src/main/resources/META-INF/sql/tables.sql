create table ZSKP_ZskpProcess (
	uuid_ VARCHAR(75) null,
	processId LONG not null primary key,
	name VARCHAR(75) null,
	type_ LONG,
	kind LONG
);