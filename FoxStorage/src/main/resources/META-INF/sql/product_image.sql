/*  product inserts */
INSERT INTO product(product_ean, product_name)VALUES('5999553550566', 'horgolótű');
INSERT INTO product(product_ean, product_name)VALUES('5999553558692', 'fejpánt');
INSERT INTO product(product_ean, product_name)VALUES('5999561693378', 'penge');
INSERT INTO product(product_ean, product_name)VALUES('5999561695709', 'tükör');
INSERT INTO product(product_ean, product_name)VALUES('5999553550269', 'kréta');
INSERT INTO product(product_ean, product_name)VALUES('5999553554465', 'függöny');
INSERT INTO product(product_ean, product_name)VALUES('5999553554014', 'gyűrű szett');
INSERT INTO product(product_ean, product_name)VALUES('5999553559019', 'papírtasak');
INSERT INTO product(product_ean, product_name)VALUES('5999553559248', 'hajráf');
INSERT INTO product(product_ean, product_name)VALUES('5999553558975', 'pénztárca');
INSERT INTO product(product_ean, product_name)VALUES('5999561690919', '3D kép');
INSERT INTO product(product_ean, product_name)VALUES('5999561691886', 'szemöldök csipesz');
INSERT INTO product(product_ean, product_name)VALUES('5999561691961', 'karkötő köves');
INSERT INTO product(product_ean, product_name)VALUES('5999553556254', 'szempillapöndörítő');
INSERT INTO product(product_ean, product_name)VALUES('5999553556681', 'billegős madár');
INSERT INTO product(product_ean, product_name)VALUES('5999561696683', 'hajgumi virágos');
INSERT INTO product(product_ean, product_name)VALUES('5999561696485', 'lánc tetkós');
INSERT INTO product(product_ean, product_name)VALUES('5999561696898', 'hajkefe');
INSERT INTO product(product_ean, product_name)VALUES('5999561693866', 'habkő nagy');
INSERT INTO product(product_ean, product_name)VALUES('5999561694771', 'franciacsat');
INSERT INTO product(product_ean, product_name)VALUES('5999561694580', 'hajráf bogyós');
INSERT INTO product(product_ean, product_name)VALUES('5999561693316', 'arctisztító szivacs');
INSERT INTO product(product_ean, product_name)VALUES('5999561693071', 'borotva pamacs');
INSERT INTO product(product_ean, product_name)VALUES('5999561695518', 'hajgumi füles');
INSERT INTO product(product_ean, product_name)VALUES('5999561695662', 'púder szivacs');
INSERT INTO product(product_ean, product_name)VALUES('5999553550467', 'varrócenti 150cm');
INSERT INTO product(product_ean, product_name)VALUES('5999553551143', 'körömreszelő');
INSERT INTO product(product_ean, product_name)VALUES('5999553551617', 'műköröm');
INSERT INTO product(product_ean, product_name)VALUES('5999561695266', 'fülbevaló stift');
INSERT INTO product(product_ean, product_name)VALUES('5999561696126', 'kozmetika táska');
INSERT INTO product(product_ean, product_name)VALUES('5999561695877', 'hajpánt csipke');
INSERT INTO product(product_ean, product_name)VALUES('5999561696997', 'karkötő medállal');

INSERT INTO user(email, first_name,	last_name, password, username) VALUES ('admin@gmail.com', 'Admin', 'Adminovich', '$2a$10$nYprTTsDAIsr/HrK9VJHrOXTqoIJtdDGPNRdDnhbjA9kXIpEq1CGO', 'admin');

INSERT INTO role(description, role_name) VALUES ('all permissions allowed', 'ADMIN');
INSERT INTO role(description, role_name) VALUES ('invoice, acquisition, contact, user managing', 'OFFICE_MANAGER');
INSERT INTO role(description, role_name) VALUES ('order, contact, deliver managing', 'REGIONAL_REPRESENTATIVE');
INSERT INTO role(description, role_name) VALUES ('storage, job managing', 'WAREHOUSE_EMPLOYEE');
INSERT INTO role(description, role_name) VALUES ('only read', 'VISITOR');

INSERT INTO role_user(role_ID, user_ID) VALUES ('1', '1');