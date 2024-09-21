-- Assigning full DDL privileges to the user on the default database
GRANT ALL PRIVILEGES ON DATABASE postgres TO postgres;

-- Allow the user to create schemas and tables
GRANT CREATE ON DATABASE postgres TO postgres;

-- Grant all privileges on all existing tables and sequences
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO postgres;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO postgres;

-- If needed, allow DDL on other schemas (optional)
GRANT CREATE ON SCHEMA public TO postgres;