CREATE DATABASE IF NOT EXISTS appcotizador;

USE appcotizador;

CREATE TABLE datos_empresa(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    contacto VARCHAR(255) NOT NULL,
    slogan VARCHAR(255),
    banco VARCHAR(255) NOT NULL,
    titular VARCHAR(255) NOT NULL,
    no_cuenta VARCHAR(50) NOT NULL,
    clabe VARCHAR(50) NOT NULL,
    observaciones VARCHAR(255),
    iva INT NOT NULL,
    logo LONGBLOB
);

CREATE TABLE clientes(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(255) NOT NULL,
	telefono VARCHAR(255) NOT NULL,
	correo VARCHAR(255) NOT NULL,
	direccion VARCHAR(255) NOT NULL,
    estatus BOOLEAN NOT NULL
);

CREATE TABLE servicios (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(255) NOT NULL,
    importe DECIMAL(14, 2) NOT NULL,
    estatus BOOLEAN NOT NULL
);

CREATE TABLE cotizaciones (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    fecha DATETIME NOT NULL,
    subtotal DECIMAL(14, 2) NOT NULL,
    iva DECIMAL(10, 2) NOT NULL,
    total DECIMAL(14, 2) NOT NULL,
    id_cliente INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);

CREATE TABLE cotizacion_detalle (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_cotizacion INT NOT NULL,
    id_servicio INT NOT NULL,
    FOREIGN KEY (id_cotizacion) REFERENCES cotizaciones(id),
    FOREIGN KEY (id_servicio) REFERENCES servicios(id)
);

-- default data

INSERT INTO 
datos_empresa (id, nombre, descripcion, direccion, contacto, slogan, banco, titular, no_cuenta, clabe, observaciones, iva) 
VALUES (null, 'default', 'default', 'default', 'default', 'default', 'default', 'default', 'default', 'default', 'default', 16); 
