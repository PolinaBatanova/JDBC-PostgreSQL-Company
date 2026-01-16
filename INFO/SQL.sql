
CREATE DATABASE company;

CREATE TABLE IF NOT EXISTS employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INTEGER NOT NULL,
    position VARCHAR(100) NOT NULL,
    salary NUMERIC(10, 2) NOT NULL
    );


INSERT INTO employees (name, age, position, salary)
VALUES ('Test User', 30, 'Dev', 1000.00);