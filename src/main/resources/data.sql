DELETE FROM order_pizzas;
DELETE FROM pizza_toppings;
DELETE FROM orders;
DELETE FROM pizzas;
DELETE FROM toppings;
DELETE FROM users;

INSERT INTO toppings (name, price) VALUES
('Mozzarella', 10.00),
('Pepperoni', 15.00),
('Champignon', 8.00),
('Løg', 5.00),
('Oliven', 8.00);

INSERT INTO pizzas (name, description, base_price) VALUES
('Margherita', 'Klassisk pizza med tomat og mozzarella', 79.00),
('Pepperoni', 'Pizza med pepperoni og mozzarella', 89.00),
('Vegetar', 'Pizza med champignon, løg og oliven', 85.00);