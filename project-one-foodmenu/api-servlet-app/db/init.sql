-- sample.menu definition

-- Drop table

-- DROP TABLE menu;

CREATE TABLE menu (
	id serial NOT NULL,
	title varchar NOT NULL,
	begin_date date NULL,
	CONSTRAINT menu_pk PRIMARY KEY (id),
	CONSTRAINT menu_un UNIQUE (title)
);