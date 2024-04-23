CREATE DATABASE CRUD;

CREATE DATABASE CRUD;

USE CRUD;

CREATE TABLE contacto
(
    id INT IDENTITY(1,1),
    nombre VARCHAR(100),
    correo VARCHAR(100) CONSTRAINT chk_correo_formato CHECK (correo LIKE '%@%._%'),
    telefono VARCHAR(20) CONSTRAINT chk_telefono_formato CHECK (telefono LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'), 
    estado INT DEFAULT 1,
    CONSTRAINT pk_contacto PRIMARY KEY(id)
);
