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

--version 2
INSERT INTO transportista (numero_documento, nombre, apellido, nombre_completo, email, zona_cobertura) VALUES
('12345678', 'Juan', 'Pérez', 'Juan Pérez', 'juan.perez@example.com', '{"provincia":["Buenos Aires"],"localidades":["La Plata","Mar del Plata","Tigre","San Fernando"]}'),
('23456789', 'Ana', 'Gómez', 'Ana Gómez', 'ana.gomez@example.com', '{"provincia":["Santa Fe"], "localidades":["Funes","Granadero Baigorria","Roldán","San Lorenzo"]}'),
('34567890', 'Luis', 'Martínez', 'Luis Martínez', 'fipo2024@gmail.com', '{"provincia":["Cordoba"], "localidades":["Córdoba Capital","Villa María","San Francisco","Villa Carlos Paz"]}'),
('45678901', 'Laura', 'Fernández', 'Laura Fernández', 'laura.fernandez@example.com', '{"provincia":["Neuquen"], "localidades":["San Martín de los Andes","Zapala","Plottier","Neuquén Capital"]}'),
('56789012', 'Carlos', 'Lopez', 'Carlos Lopez', 'carlos.lopez@example.com', '{"provincia":["Santa Fe"], "localidades":["Villa Gobernador Gálvez","Capitán Bermúdez","Fray Luis Beltrán","Arroyo Seco"]}'),
('67890123', 'Marta', 'Ruiz', 'Marta Ruiz', 'marta.ruiz@example.com', '{"provincia":["Cordoba"], "localidades":["Río Cuarto","Alta Gracia","Cosquín","Jesús María"]}');
