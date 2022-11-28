DROP TABLE products IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE orders IF EXISTS;


CREATE TABLE IF NOT EXISTS products(id bigserial, title VARCHAR (255), price int, PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS users(id bigserial, login VARCHAR(255), PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS orders(product_id int, user_id int, FOREIGN KEY(product_id) REFERENCES products(id), FOREIGN KEY(user_id) REFERENCES users(id));

INSERT INTO products (title, price) VALUES ('Milk', 80), ('Potato', 12), ('Cheese', 132);
INSERT INTO users (login) VALUES ('Ram'), ('Kotto');
INSERT INTO orders (product_id, user_id) VALUES (1, 1), (1, 2), (2, 2), (3, 2);
