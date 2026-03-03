INSERT INTO qualification_type (name) VALUES ('License'), ('Rating');


INSERT INTO province (id, name) VALUES
(1, 'Buenos Aires'),
(2, 'Ciudad Autónoma de Buenos Aires'),
(3, 'Catamarca'),
(4, 'Chaco'),
(5, 'Chubut'),
(6, 'Córdoba'),
(7, 'Corrientes'),
(8, 'Entre Ríos'),
(9, 'Formosa'),
(10, 'Jujuy'),
(11, 'La Pampa'),
(12, 'La Rioja'),
(13, 'Mendoza'),
(14, 'Misiones'),
(15, 'Neuquén'),
(16, 'Río Negro'),
(17, 'Salta'),
(18, 'San Juan'),
(19, 'San Luis'),
(20, 'Santa Cruz'),
(21, 'Santa Fe'),
(22, 'Santiago del Estero'),
(23, 'Tierra del Fuego'),
(24, 'Tucumán');

INSERT INTO flight_type (abbreviation, name) VALUES
('RP', 'Remolque'),
('ACR', 'Acrobacia'),
('ADAP', 'Adaptación'),
('AER', 'Aeroaplicador'),
('CI', 'Combate contra Incendios de Bosques y Campos'),
('ENT', 'Entrenamiento'),
('LA', 'Línea Aérea. (RAAC 121)'),
('EXA', 'Examen'),
('FOR', 'Formación'),
('FOT', 'Fotografía'),
('I', 'Instructor (Impartición de instrucción)'),
('INST', 'Instrucción. (Recepción de instrucción'),
('IP', 'Inspector (inspección de pilotos o alumnos pilotos'),
('LP', 'Lanzamiento de paracaidistas'),
('N', 'Vuelo No Regular. (RAAC 135)'),
('PA', 'Prueba de aeronaves'),
('READ', 'Readaptación'),
('SAN', 'Sanitario'),
('TA', 'Trabajo Aéreo'),
('VO', 'Vuelo Oficial'),
('VP', 'Vuelo Privado'),
('LTCP', 'Inspector'),
('TCPINS', 'Tripulante de Cabina de Pasajeros en Instrucción.');

INSERT INTO aircraft_type (name) VALUES ('Avión'), ('Planeador');

INSERT INTO maintenance_type(name) VALUES ('Overhaul');

INSERT INTO aerodrome (icao_code, local_code, name, location_id) VALUES
('', 'EPZ', 'Aeródromo de Esperanza', 21),
('SABE', 'AER', 'Aeroparque Jorge Newbery', 2),
('SAEZ', 'EZE', 'Aeropuerto Internacional Ministro Pistarini', 1),
('SADP', 'EPA', 'Aeropuerto El Palomar', 1),
('SACO', 'COR', 'Aeropuerto Pajas Blancas', 6),
('SAME', 'MDZ', 'Aeropuerto El Plumerillo', 13),
('SAZS', 'BRC', 'Aeropuerto Teniente Luis Candelaria', 16),
('SAAR', 'ROS', 'Aeropuerto Islas Malvinas', 21),
('SAAV', 'SFN', 'Aeropuerto de Sauce Viejo', 21),
('SAZN', 'NQN', 'Aeropuerto Presidente Perón', 15),
('SANC', 'CTC', 'Aeropuerto Coronel Felipe Varela', 3),
('SAZB', 'BHI', 'Aeropuerto Comandante Espora', 1),
('SAZM', 'MDQ', 'Aeropuerto Astor Piazzolla', 1),
('SANT', 'TUC', 'Aeropuerto Teniente Benjamín Matienzo', 24),
('SASA', 'SLA', 'Aeropuerto Martín Miguel de Güemes', 17),
('SAWH', 'USH', 'Aeropuerto de Ushuaia Malvinas Argentinas', 23);

INSERT INTO aerodrome (icao_code, local_code, name, location_id) VALUES
('SACD', 'EDO', 'Aeroclub Coronel Olmedo', 6),
('SAZA', 'ZUL', 'Aeródromo Azul', 1),
('SAZI', 'BLR', 'Aeródromo Bolívar', 1),
('SAZC', 'SUZ', 'Aeródromo Coronel Suárez', 1),
('SADL', 'LPG', 'Aeródromo La Plata', 1),
('SADF', 'FDO', 'Aeródromo San Fernando', 1),
('SAOR', 'VME', 'Aeropuerto de Villa Reynolds', 19),
('SAVR', 'ARS', 'Aeródromo Alto Río Senguerr', 5),
('SACN', 'NGA', 'Aeródromo Ascochinga', 6),
('SAHI', 'CIP', 'Aeródromo Cipoletti', 16),
('SANW', 'ERE', 'Aeropuerto Ceres', 21),
('SAZW', 'CUT', 'Aeropuerto Cutral-Có', 15),
('SRDR', 'GEZ', 'Aeroclub General Rodríguez (EAA)', 1),
('SRDE', 'LEN', 'Aeródromo Belén de Escobar', 1);



INSERT INTO aircraft (registration, model, is_grounded, aircraft_type_id) VALUES
('LV-ASH', 'Aero Boero 180 AB', false, 1),
('LV-ANH', 'Piper PA-38 Tomahawk', false, 1);


INSERT INTO role (name, description) VALUES
('Miembro', 'Acceso estándar al sistema'),
('Admin', 'Acceso completo al sistema'),
('Tesorero', 'Tesorero del club'),
('Presidente', 'Presidente del club');

-- 1. Create the User (System Login)
INSERT INTO users (username, password, enabled) VALUES
('bruno', '$2a$12$sh8T2WA6HmfyRSxcFEG2euyIJqitqYjKkXKx1taIUgL3NBS87YCM.', true),
('heisser', '$2a$12$eZb/0opWWrJQMPgB6Z9Unu/NusUZtZ/OVQ2XSQrzasvNjopyr6ayi', true);

-- 2. Create the Member (Physical Profile)
INSERT INTO member (user_id, member_id, first_name, last_name, birthday, sign_up_date, gender, email, phone, address, is_active) VALUES
(1, 1001, 'Bruno', 'Leanza', '1996-03-03', '2022-03-01', 'Male', 'kertz@example.com', '+54 342 1234567', 'San Martín 2551, Santa Fe, Argentina', true),
(2, 57, 'José Luis', 'Heisser', '1996-03-03', '2022-03-01', 'Male', 'heisser@cpae.com', '+54 342 1234567', 'Belgrano 231, Esperanza, Argentina', true);

-- 4. Assign Roles via RoleRecord (Linking Member to Roles)
INSERT INTO role_record (user_id, role_id, since, until) VALUES
(1, 1, '2026-03-03', NULL),
(1,  2, '2026-03-01', NULL),
(2, 1, '2026-03-03', NULL),
(2,  4, '2026-03-01', NULL);

-- Giving the user the 'President' role starting now
