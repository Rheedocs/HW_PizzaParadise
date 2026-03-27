DROP TABLE IF EXISTS order_pizzas;
DROP TABLE IF EXISTS pizza_toppings;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS pizzas;
DROP TABLE IF EXISTS toppings;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    address VARCHAR(255),
    bonus_points INT DEFAULT 0
    );

CREATE TABLE IF NOT EXISTS toppings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL
    );

CREATE TABLE IF NOT EXISTS pizzas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    base_price DOUBLE NOT NULL,
    is_custom BOOLEAN DEFAULT FALSE
    );

CREATE TABLE IF NOT EXISTS pizza_toppings (
    pizza_id INT,
    topping_id INT,
    PRIMARY KEY (pizza_id, topping_id),
    FOREIGN KEY (pizza_id) REFERENCES pizzas(id),
    FOREIGN KEY (topping_id) REFERENCES toppings(id)
    );

CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    date DATE NOT NULL,
    discount DOUBLE DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES users(id)
    );

CREATE TABLE IF NOT EXISTS order_pizzas (
    order_id INT,
    pizza_id INT,
    PRIMARY KEY (order_id, pizza_id),
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (pizza_id) REFERENCES pizzas(id)
    );