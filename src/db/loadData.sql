INSERT INTO products (id, description, price) values(1, 'Lamp', 5.78);
INSERT INTO products (id, description, price) values(2, 'Table', 75.29);
INSERT INTO products (id, description, price) values(3, 'Chair', 22.81);


INSERT INTO users (username,password, enabled, fullname) VALUES ('user', md5('123456'), TRUE, 'USUARIO FELIZ');
INSERT INTO users (username,password, enabled, fullname)VALUES ('admin', md5('123456'), TRUE, 'ADMINISTRADOR');

INSERT INTO user_roles(user_id, authority) values(1, 'ROLE_USER');
INSERT INTO user_roles(user_id, authority) values(2, 'ROLE_ADMIN');


