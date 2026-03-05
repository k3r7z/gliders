INSERT INTO qualification_type (name) VALUES ('License'), ('Rating'), ('Medical');

INSERT INTO qualification (id, name, description, qualification_type_id) VALUES
(1,'Piloto Comercial de Avión', 'Piloto de avión capaz de ejercer vuelos de forma remunerada', 1),
(2,'Piloto de Planeador', NULL, 1),
(3,'Instructor de vuelo de Avión', NULL, 2),
(4,'Instructor de vuelo de Planeador', NULL, 2),
(5,'Piloto Privado de Avión','Realiza vuelos recreativos', 1),
(6,'CMA Clase 2', 'Certificado Médico Aeronáutico Clase 2 (vuelos no remunerados)', 3),
(7,'CMA Clase 1', 'Certificado Médico Aeronáutico Clase 1 (vuelos remunerados)', 3),
(8,'Vuelo local nocturno', '', 2),
(9, 'Vuelo por instrumentos', '', 2),
(10, 'Vuelo multimotor', '', 2);


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

INSERT INTO flight_type (id, abbreviation, name) VALUES
(1,'RP', 'Remolque'),
(2,'ACR', 'Acrobacia'),
(3,'ADAP', 'Adaptación'),
(4,'AER', 'Aeroaplicador'),
(5, 'CI', 'Combate contra Incendios de Bosques y Campos'),
(6, 'ENT', 'Entrenamiento'),
(7, 'LA', 'Línea Aérea. (RAAC 122)'),
(8, 'EXA', 'Examen'),
(9, 'FOR', 'Formación'),
(10, 'FOT', 'Fotografía'),
(11, 'I', 'Instructor (Impartición de instrucción)'),
(12, 'INST', 'Instrucción. (Recepción de instrucción'),
(13, 'IP', 'Inspector (inspección de pilotos o alumnos pilotos'),
(14, 'LP', 'Lanzamiento de paracaidistas'),
(15, 'N', 'Vuelo No Regular. (RAAC 136)'),
(16, 'PA', 'Prueba de aeronaves'),
(17, 'READ', 'Readaptación'),
(18, 'SAN', 'Sanitario'),
(19, 'TA', 'Trabajo Aéreo'),
(20, 'VO', 'Vuelo Oficial'),
(21, 'VP', 'Vuelo Privado'),
(22, 'LTCP', 'Inspector'),
(23, 'TCPINS', 'Tripulante de Cabina de Pasajeros en Instrucción.');

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
('LV-ANH', 'Piper PA-38 Tomahawk', false, 1),
('LV-ASH', 'Aero Boero 180 AB', false, 1),
('LV-DLS', 'ICA IS 29', false, 2);


INSERT INTO role (name, description) VALUES
('Miembro', 'Acceso estándar al sistema'),
('Admin', 'Acceso completo al sistema'),
('Tesorero', 'Tesorero del club'),
('Presidente', 'Presidente del club');

-- 1. Create the User (System Login)
INSERT INTO users (username, password, enabled) VALUES
('bruno', '$2a$12$sh8T2WA6HmfyRSxcFEG2euyIJqitqYjKkXKx1taIUgL3NBS87YCM.', true),
('heisser', '$2a$12$eZb/0opWWrJQMPgB6Z9Unu/NusUZtZ/OVQ2XSQrzasvNjopyr6ayi', true),
('joemomma', 'password', true);


-- 2. Create the Member (Physical Profile)
INSERT INTO member (user_id, member_id, first_name, last_name, birthday, sign_up_date, gender, email, phone, address, is_active) VALUES
(1, 55, 'Bruno', 'Leanza', '1996-03-03', '2022-03-01', 'Male', 'brunoadanleanza@gmail.com', '+54 342 1234567', 'San Martín 2551, Santa Fe, Argentina', true),
(2, 21, 'José Luis', 'Heisser', '1996-03-03', '2022-03-01', 'Male', 'heisser@cpae.com', '+54 342 1234567', 'Belgrano 231, Esperanza, Argentina', true),
(3, 34, 'Joe', 'Momma', '1983-06-29', '2005-09-25', 'Male', 'joemama@cpae.com', '+54 341 35132523', 'Alameda 523, Paraná, Entre Ríos', true );

INSERT INTO qualification_issuance(qualification_id, member_id, emission_date, expiration_date) VALUES
(6, 1, '2018-05-22', '2021-05-22'),
(7, 1, '2019-05-04', '2020-04-15'),
(7, 1, '2020-05-04', '2021-04-15'),
(7, 1, '2022-05-04', '2023-04-15'),
(7, 1, '2023-05-04', '2024-04-15'),
(7, 1, '2024-05-04', '2025-04-15'),
(7, 1, '2025-05-04', '2026-04-15'),
(4, 2, '2018-03-06', NULL),
(1, 1, '2022-09-21', NULL),
(8, 1, '2022-09-21', NULL),
(9, 1, '2022-09-21', NULL),
(10, 1, '2021-05-21', NULL);


INSERT INTO role_record (user_id, role_id, since, until) VALUES
(1, 1, '2026-03-03', NULL),
(1,  2, '2026-03-01', NULL),
(2, 1, '2026-03-03', NULL),
(2,  4, '2026-03-01', NULL);

INSERT INTO flight (code, start_time, stop_time, aircraft_id, departure_id, destination_id, flight_type_id, instructor_id, pilot_in_command_id, tow_airplane_id)
VALUES (1001, '2026-03-03T09:00:00-03:00', '2026-03-03T10:00:00-03:00', 1, 1, 1, 21, NULL, 1, NULL);

INSERT INTO flight (code, start_time, stop_time, aircraft_id, departure_id, destination_id, flight_type_id, instructor_id, pilot_in_command_id, tow_airplane_id)
VALUES (1002, '2026-03-03T11:00:00-03:00', '2026-03-03T12:00:00-03:00', 1, 1, 1, 12, 2, 1, NULL);

INSERT INTO flight (code, start_time, stop_time, aircraft_id, departure_id, destination_id, flight_type_id, instructor_id, pilot_in_command_id, tow_airplane_id)
VALUES (1003, '2026-03-03T14:00:00-03:00', '2026-03-03T14:45:00-03:00', 3, 1, 1, 21, NULL, 1, 2);

INSERT INTO flight (code, start_time, stop_time, aircraft_id, departure_id, destination_id, flight_type_id, instructor_id, pilot_in_command_id, tow_airplane_id)
VALUES (1004, '2026-03-03T16:00:00-03:00', '2026-03-03T17:00:00-03:00', 3, 1, 1, 12, 2, 1, 2);
