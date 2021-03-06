create table ZSKP_Kind (
	id_ LONG not null primary key,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null
);

create table ZSKP_Process (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	type_ LONG,
	kind LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table ZSKP_Type (
	id_ LONG not null primary key,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null
);