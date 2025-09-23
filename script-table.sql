
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
INSERT INTO personas (nombre, edad, email) VALUES ('Juan Perez', 30, '

\dt; --> Listar tablas
DROP TABLE personas; --> Eliminar tabla
\d+ personas; --> Describir tabla

brew update
brew services restart postgresql --> para iniciar postgresql 
brew services stop postgresql --> parar postgre 
rm /usr/local/var/postgresql@14/postmaster.pid --> eliminar achivo cuando no hga coneccion