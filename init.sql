CREATE TABLE tipo_carga (
	id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(15) not NULL,
    descripcion VARCHAR(255) NULL
);

INSERT INTO tipo_carga (nombre, descripcion) VALUES
    ('documentacion', 'Documentación o papelería'),
    ('granos', 'Granos agrícolas'),
    ('paquete', 'Paquete de productos'),
    ('hacienda', 'Hacienda o ganado');

CREATE TABLE pedido_envio (
    id SERIAL PRIMARY KEY,
    domicilio_retiro VARCHAR(255) NOT NULL,
    referencia_retiro VARCHAR(150),
    fecha_retiro DATE NOT NULL,
    domicilio_entrega VARCHAR(255) NOT NULL,
    referencia_entrega VARCHAR(150),
    fecha_entrega DATE NOT null,
    tipo_carga BIGSERIAL,
    observacion VARCHAR(150),
    FOREIGN KEY (tipo_carga) REFERENCES tipo_carga(id)
)

CREATE TABLE transportista (
    numero_documento VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    nombre_completo VARCHAR(50) NOT null,
    email VARCHAR(30) NOT null,
    zona_cobertura TEXT
);

  INSERT INTO transportista (numero_documento, nombre, apellido, nombre_completo, email, zona_cobertura) VALUES
('12345678', 'Juan', 'Pérez', 'Juan Pérez', 'juan.perez@example.com', '{"localidades":["Córdoba Capital","Villa Carlos Paz"]}'),
('23456789', 'Ana', 'Gómez', 'Ana Gómez', 'ana.gomez@example.com', '{"localidades":["Villa María","San Francisco"]}'),
('34567890', 'Luis', 'Martínez', 'Luis Martínez', 'luis.martinez@example.com', '{"localidades":["Rosario","Venado Tuerto","San Lorenzo"]}'),
('45678901', 'Laura', 'Fernández', 'Laura Fernández', 'laura.fernandez@example.com', '{"localidades":["Santa Fe Capital","Reconquista"]}'),
('56789012', 'Carlos', 'Lopez', 'Carlos Lopez', 'carlos.lopez@example.com', '{"localidades":["San Luis Capital","Villa Mercedes","Merlo"]}'),
('67890123', 'Marta', 'Ruiz', 'Marta Ruiz', 'marta.ruiz@example.com', '{"localidades":["San Luis Capital","La Punta"]}');