truncate table entity_menu_item cascade;
truncate table entity_phone cascade;
truncate table entity_organization cascade;
truncate table entity_user_role cascade;
truncate table entity_role cascade;
truncate table entity_user cascade;
truncate table entity_account cascade;
truncate table entity_order cascade;
truncate table entity_order_status cascade;
truncate table entity_customer cascade;

insert into entity_menu_item (id, name, visible, parent_id) values (1001, 'Home', true, null);
insert into entity_menu_item (id, name, visible, parent_id) values (1002, 'Sales', true, null);
insert into entity_menu_item (id, name, visible, parent_id) values (1003, 'Shipping', false, null);
insert into entity_menu_item (id, name, visible, parent_id) values (1004, 'Organization', false, null);
insert into entity_menu_item (id, name, visible, parent_id) values (1005, 'Warehouses', false, null);
insert into entity_menu_item (id, name, visible, parent_id) values (1006, 'Catalogs', false, null);
insert into entity_menu_item (id, name, visible, parent_id) values (1007, 'Reports', false, null);

insert into entity_menu_item (id, name, visible, parent_id) values (2201, 'Invoices to customers', true, 1002);
insert into entity_menu_item (id, name, visible, parent_id) values (2202, 'Sales Returns', true, 1002);
insert into entity_menu_item (id, name, visible, parent_id) values (2301, 'Shipping map', true, 1003);
insert into entity_menu_item (id, name, visible, parent_id) values (2302, 'Couriers', true, 1003);
insert into entity_menu_item (id, name, visible, parent_id) values (2303, 'Orders', true, 1002);

insert into entity_menu_item (id, name, visible, parent_id) values (10001, 'Administration', true, null);
insert into entity_menu_item (id, name, visible, parent_id) values (10101, 'Organizations', true, 10001);
insert into entity_menu_item (id, name, visible, parent_id) values (10102, 'Users', true, 10001);
insert into entity_menu_item (id, name, visible, parent_id) values (10103, 'Roles', true, 10001);
insert into entity_menu_item (id, name, visible, parent_id) values (10104, 'Settings', true, 10001);

-- принцип приспоения id:
-- 1601 - 1-я цифра=уровень меню; 2-я цифра=id элемента из меню предыдущего уровня; 3-я и 4-я цифры - порядковый номер на уровне
-- все что больше 10000 - служебные пункты меню

insert into entity_account (id, name) values (1, 'Big Dic with Big Balls, Inc.');

insert into entity_user (id, firstName, lastName, username, password, account_id) values (1, 'root fn', 'root ln', 'root', 'root', 1);
insert into entity_user (id, firstName, lastName, username, password, account_id) values (2, 'test fn', 'test ln', 'test', 'test', 1);
insert into entity_user (id, firstName, lastName, username, password, account_id) values (3, 'test fn1', 'test ln1', 'test1', 'test1', 1);
insert into entity_user (id, firstName, lastName, username, password, account_id) values (4, 'test fn2', 'test ln2', 'test2', 'test2', 1);
insert into entity_user (id, firstName, lastName, username, password, account_id) values (5, 'test fn3', 'test ln3', 'test3', 'test3', 1);

insert into entity_role (id, name, description) values (1, 'Admin', 'Admin Description');
insert into entity_role (id, name, description) values (2, 'User', 'User Description');

INSERT INTO entity_user_role(user_id, role_id) VALUES (1, 1);
INSERT INTO entity_user_role(user_id, role_id) VALUES (2, 2);

INSERT INTO entity_organization(id, description, name, account_id) VALUES (1, 'dddd', 'dddd', 1);
INSERT INTO entity_organization(id, description, name, account_id) VALUES (2, 'dddd', 'aaaa', 1);
INSERT INTO entity_organization(id, description, name, account_id) VALUES (3, 'dddd', 'zzzz', 1);
INSERT INTO entity_organization(id, description, name, account_id) VALUES (4, 'dddd', 'ffff', 1);
INSERT INTO entity_organization(id, description, name, account_id) VALUES (5, 'dddd', 'cccc', 1);

INSERT INTO entity_phone(id, isprimary, "number", organization_id) VALUES (1, true, '123', 1);
INSERT INTO entity_phone(id, isprimary, "number", organization_id) VALUES (2, true, '1234', 1);
INSERT INTO entity_phone(id, isprimary, "number", organization_id) VALUES (3, true, '12345', 2);
INSERT INTO entity_phone(id, isprimary, "number", organization_id) VALUES (4, true, '123456', 2);

INSERT INTO entity_order_status(id, title) VALUES (1, 'delivery');
INSERT INTO entity_order_status(id, title) VALUES (2, 'new');
INSERT INTO entity_customer(id, name) VALUES (1, 'Покупатель1');
INSERT INTO entity_customer(id, name) VALUES (2, 'Покупатель2');

INSERT INTO entity_order(id, deliverydate, orderdate, ordernumber, customer_id, organization_id, status_id) VALUES (1, now(), now(), 1, 1, 1, 1);
INSERT INTO entity_order(id, deliverydate, orderdate, ordernumber, customer_id, organization_id, status_id) VALUES (2, now(), now(), 2, 2, 1, 2);
INSERT INTO entity_order(id, deliverydate, orderdate, ordernumber, customer_id, organization_id, status_id) VALUES (3, now(), now(), 3, 2, 1, 2);
INSERT INTO entity_order(id, deliverydate, orderdate, ordernumber, customer_id, organization_id, status_id) VALUES (4, now(), now(), 4, 1, 1, 2);