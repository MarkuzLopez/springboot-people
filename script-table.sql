
/**

CREATE USER markuz WITH PASSWORD 'markuz12345'; --> Crear usuario
CREATE DATABASE personasdb OWNER markuz; --> Crear base de datos y asignar propietario
GRANT ALL PRIVILEGES ON DATABASE personasdb TO markuz; --> Conceder todos los privilegios al usuario
\c personasdb --> Conectarse a la base de datos
\l   --> Listar bases de datos
LISTR TABLAS; --> Listar tablas
DROP DATABASE personasdb; --> Eliminar base de datos
DROP USER markuz; --> Eliminar usuario  
\q --> Salir de psql
CREATE TABLE personas (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
); --> Crear tabla
INSERT INTO personas (nombre, email, edad) VALUES ('Marco Antonio', 'marco@email.com', 28);
INSERT INTO personas (nombre, email, edad) VALUES ('Ana', 'ana@email.com', 25);
INSERT INTO personas (nombre, email, edad) VALUES ('Luis', 'luis@email.com', 30);)

\dt; --> Listar tablas
DROP TABLE personas; --> Eliminar tabla
\d+ personas; --> Describir tabla

brew update
brew services restart postgresql --> para iniciar postgresql 
brew services stop postgresql --> parar postgre 
rm /usr/local/var/postgresql@14/postmaster.pid --> eliminar achivo cuando no hga coneccion

psql -U markuz -d postgres --> Conectarse a la base de datos postgres como usuario markuz

CREATE ROLE postgres WITH LOGIN SUPERUSER PASSWORD 'markuz@@2025!!'; --> Crear rol con todos los privilegios 
-- Connect to a database using psql:
-- psql -U <username> -d <database_name>

-- List all databases:
\l

-- List all tables in the current database:
\dt

-- Show all users/roles:
\du

-- Connect to another database:
\c <database_name>

-- Run a query (example: select all from a table):
SELECT * FROM <table_name>;

-- Describe table structure:
\d <table_name>

**/