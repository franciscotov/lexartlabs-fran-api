-- Create the 'users' table if it doesn't already exist
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create the 'products' table if it doesn't already exist
CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand VARCHAR(255),
    model VARCHAR(255)
);

-- Create the 'product_variants' table if it doesn't already exist
CREATE TABLE IF NOT EXISTS product_variants (
    id SERIAL PRIMARY KEY,
    product_id INT NOT NULL,
    price INT NOT NULL,
    color VARCHAR(50),
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);

-- Assigning full DDL privileges to the user on the default database
GRANT ALL PRIVILEGES ON DATABASE postgres TO postgres;

-- Allow the user to create schemas and tables
GRANT CREATE ON DATABASE postgres TO postgres;

-- Grant all privileges on all existing tables and sequences
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO postgres;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO postgres;

-- If needed, allow DDL on other schemas (optional)
GRANT CREATE ON SCHEMA public TO postgres;
