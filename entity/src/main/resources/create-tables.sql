CREATE TABLE IF NOT EXISTS magazinof.hibernate_sequences (
    sequence_name varchar(255),
    sequence_next_hi_value integer
);
commit;

CREATE TABLE IF NOT EXISTS magazinof.entity_account (
	id bigint NOT NULL PRIMARY KEY,
	name varchar(255)
);
commit;

CREATE TABLE IF NOT EXISTS magazinof.entity_user (
	id bigint NOT NULL PRIMARY KEY,
	firstName varchar(128),
	lastName varchar(128),
	username varchar(128) NOT NULL,
	password varchar(128),
	email varchar(128),
	active bit default 0 NOT NULL,
	lastLogged datetime,
	created datetime,
	account_id bigint,
	FOREIGN KEY (account_id) REFERENCES entity_account (id)
                      ON DELETE CASCADE
);
commit;

CREATE TABLE IF NOT EXISTS magazinof.entity_organization (
	id bigint NOT NULL PRIMARY KEY,
	name varchar(128) NOT NULL,
	description varchar(512),
	account_id bigint,
	FOREIGN KEY (account_id) REFERENCES entity_account (id)
                      ON DELETE CASCADE
);
commit;

CREATE TABLE entity_delivery_type
(
  id bigint NOT NULL,
  name character varying(255),
  CONSTRAINT entity_delivery_type_pkey PRIMARY KEY (id )
)
commit;

CREATE TABLE entity_employee
(
  id bigint NOT NULL,
  name character varying(255) NOT NULL,
  "position" character varying(255) NOT NULL,
  organization_id bigint NOT NULL,
  CONSTRAINT entity_employee_pkey PRIMARY KEY (id )
)
commit;

CREATE TABLE IF NOT EXISTS magazinof.entity_role (
	id bigint NOT NULL PRIMARY KEY,
	name varchar(128) NOT NULL,
	description varchar(512),
	organization_id bigint
);
commit;

CREATE TABLE IF NOT EXISTS magazinof.entity_user_role (
	id bigint NOT NULL PRIMARY KEY,
	user_id bigint,
	role_id bigint,
	FOREIGN KEY (role_id) REFERENCES entity_role (id)
                      ON DELETE CASCADE,
	FOREIGN KEY (user_id) REFERENCES entity_user (id)
                      ON DELETE CASCADE
);
commit;

CREATE TABLE IF NOT EXISTS magazinof.entity_organization_role (
	id bigint NOT NULL PRIMARY KEY,
	organization_id bigint,
	role_id bigint,
	FOREIGN KEY (organization_id) REFERENCES entity_organization (id)
                      ON DELETE CASCADE,
	FOREIGN KEY (role_id) REFERENCES entity_role (id)
                      ON DELETE CASCADE
);
commit;

CREATE TABLE IF NOT EXISTS magazinof.entity_phone (
	id bigint NOT NULL PRIMARY KEY,
	number varchar(128) NOT NULL,
	isPrimary bit,
	organization_id bigint,
	FOREIGN KEY (organization_id) REFERENCES entity_organization (id)
                      ON DELETE CASCADE
);
commit;

CREATE TABLE IF NOT EXISTS magazinof.entity_address (
	id bigint NOT NULL PRIMARY KEY,
	address varchar(128) NOT NULL,
	isPrimary bit,
	organization_id bigint,
	FOREIGN KEY (organization_id) REFERENCES entity_organization (id)
                      ON DELETE CASCADE
);
commit;

CREATE TABLE IF NOT EXISTS magazinof.entity_function (
	id bigint NOT NULL PRIMARY KEY,
	name varchar(255)
);
commit;

CREATE TABLE IF NOT EXISTS magazinof.entity_function_role (
	id bigint NOT NULL PRIMARY KEY,
	function_id bigint,
	role_id bigint,
	FOREIGN KEY (function_id) REFERENCES entity_function (id)
                      ON DELETE CASCADE,
	FOREIGN KEY (role_id) REFERENCES entity_role (id)
                      ON DELETE CASCADE
);
commit;

CREATE TABLE IF NOT EXISTS magazinof.entity_menu_item (
	id bigint NOT NULL PRIMARY KEY,
	name varchar(255),
	parent_id bigint,
	FOREIGN KEY (parent_id) REFERENCES entity_menu_item (id)
                      ON DELETE CASCADE
);
commit;

CREATE TABLE IF NOT EXISTS magazinof.entity_menu_item_function (
	id bigint NOT NULL PRIMARY KEY,
	function_id bigint,
	menu_item_id bigint,
	FOREIGN KEY (function_id) REFERENCES entity_function (id)
                      ON DELETE CASCADE,
	FOREIGN KEY (menu_item_id) REFERENCES entity_menu_item (id)
                      ON DELETE CASCADE
);
commit;

CREATE TABLE entity_order
(
  id bigint NOT NULL,
  deliverydate timestamp without time zone,
  orderdate timestamp without time zone,
  ordernumber bigint,
  organization_id bigint NOT NULL,
  status_id bigint NOT NULL,
  customer_id bigint NOT NULL,
  delivery_type_id bigint,
  address_id bigint,
  CONSTRAINT entity_order_pkey PRIMARY KEY (id ),
  CONSTRAINT entity_order_address_id_fkey FOREIGN KEY (address_id)
      REFERENCES entity_address (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT entity_order_delivery_type_id_fkey FOREIGN KEY (delivery_type_id)
      REFERENCES entity_delivery_type (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
  CONSTRAINT fk3ffc17f260b475 FOREIGN KEY (status_id)
      REFERENCES entity_order_status (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk3ffc17f2ce45036d FOREIGN KEY (organization_id)
      REFERENCES entity_organization (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk3ffc17f2e2e7c10d FOREIGN KEY (customer_id)
      REFERENCES entity_customer (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
commit;