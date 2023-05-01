create table transportistas (
 id_transportista int auto_increment primary key,
 nombre varchar(50),
 apellido varchar(50),
 cuit varchar(20),
 nro_prestador varchar(80)
);


create table afiliados (
 id_afiliado int auto_increment primary key,
 nombre varchar(50),
 apellido varchar(50),
 nro_documento varchar(20),
 direccion varchar(80),
 direccion_hasta varchar(80),
 telefono varchar(20),
 estado int,
 nro_afiliado varchar(20),
 profesional varchar(100),
 id_transportista int,
 constraint fk_afiliados_transportista foreign key (id_transportista) references transportistas (id_transportista)
);

create table recorridos (
 id_recorrido int auto_increment primary key,
 dia_recorrido int,
 id_afiliado int,
 constraint fk_afiliados_recorridos foreign key (id_afiliado) references afiliados (id_afiliado)
);

CREATE TABLE feriados
(
    id_feriado int auto_increment primary key,
    fecha_feriado timestamp,
    description varchar(100)
);


insert into feriados (fecha_feriado,description) values ('2021-10-11 00:00:00','Día del Respeto a la Diversidad Cultural (12/10)');
insert into feriados (fecha_feriado,description) values ('2021-10-08 00:00:00','Feriado Puente Turistico (12/10)');
insert into feriados (fecha_feriado,description) values ('2021-08-16 00:00:00','Día del Paso a la Inmortalidad del Gral. José de San Martín (17/08).');
insert into feriados (fecha_feriado,description) values ('2021-11-22 00:00:00','Día del Paso a la Inmortalidad del Gral. José de San Martín (17/08).');
insert into feriados (fecha_feriado,description) values ('2021-12-08 00:00:00','Día de la virgen).');
insert into feriados (fecha_feriado,description) values ('2021-12-24 00:00:00','Navidad).');
insert into feriados (fecha_feriado,description) values ('2021-12-31 00:00:00','Año Nuevo).');
insert into feriados (fecha_feriado,description) values ('2022-02-28 00:00:00','Feriado Carnaval).');

insert into transportistas (nombre,apellido,cuit,nro_prestador) values ('Claudia Maria Elvira','Bordolli','232098555054','2379');
insert into transportistas (nombre,apellido,cuit,nro_prestador) values ('Carlos Roberto','Barberis','20144089082','1466');

INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (1, 'ABREGO LIGORRIA', 'NOAH A', '', 'Publica 9 3035 - LILAS DE HORIZONTE - CORDOBA', 'MAESTRO LOPEZ S/N - CIUDAD UNIVERSITARIA - CORDOBA', '', 1, '238412646013', 'Instituto Hellen Keller', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (2, 'BULACIO', 'JONATHAN ISMAEL', '', 'Miguel de Marmol 2116', 'Jujuy 48', '', 1, '124992419020', 'Viviana Monzalvo', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (3, 'MATTEO TOMAS', 'ALLENDE HEREDIA', null, 'CUYO 1422', 'Vera y Zarate 3275', null, 1, '205008274031', 'Fundacion Fadetea', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (4, 'FACUNDO', 'BELLIDO ALTAMIRANO', null, 'MARIO BRAVO 2165, B.PRIMERO DE MAYO ', 'Aconcagua 1815', null, 1, '124173224044', 'Centro Lazos', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (5, 'OLIVIA MATILDE', 'CABRAL CUGAT', null, 'LOPEZ Y PLANES - 3465', 'Agustin Garzon 2912', null, 1, '238500639019', 'Centro Rayuela', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (6, 'JAZMIN AZUMI', 'CACERES', null, 'ENFERMERA CLERMONT - 420', 'Vera y Zarate 3275', null, 1, '130328467021', 'Fundacion Fadetea', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (7, 'MIRKO GERMAN', 'CACERES', null, 'ENFERMERA CLERMONT 420', 'Vera y Zarate 3275', null, 1, '130328467047', 'Fundacion Fadetea', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (8, 'FACUNDO AGUSTIN', 'CASCIO', null, 'MARIO MAGIONE 6990', 'Guandacol 1971 - B Empalme', null, 1, '221627887029', 'Silvana Carranza', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (9, 'TOMAS EZQUIEL', 'CASCIO', null, 'MARIO MIGONE - 6990- BARRIO DON BOSCO', 'Dean Funes 850', null, 1, '221627887011', 'Ipem Manuel Belgrano', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (10, 'TOMAS EZQUIEL', 'CASCIO', null, 'MARIO MIGONE - 6990- BARRIO DON BOSCO', 'Guandacol 1971 - B Empalme', null, 1, '221627887011', 'Silvana Carranza', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (11, 'ALEX LEON', 'CHAVERO GORDILLO', null, 'CLETO AGUIRRE 454', 'Agustin Garzon 2912', null, 1, '117628308591', 'Centro Rayuela', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (12, 'ELIANA IRIS', 'CLAVERO', null, 'LUIS BRAILE 2744', 'Juan Arganaraz 1756', null, 1, '217158453023', 'Centro Mater', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (13, 'ARIEL MANUEL', 'CORONEL BEVICH', null, 'FRANCFORT 1327', 'Juan Arganaraz 1756', null, 1, '143272568007', 'Centro Mater', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (14, 'GUILLERMINA', 'FERREYRA TENLLADO', null, 'FADER 79 -SALSIPUEDES', 'Kawal 8624 - Villa Allende', null, 1, '228849079023', 'Paula Vera', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (15, 'AGOSTINA', 'GARCIA AUBERT', null, 'JUAN DE ARGANARAZ 2044', 'Vera y Zarate 3275', null, 1, '228653956013', 'Fundacion Fadetea', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (16, 'PENOVI FACUNDO', 'HERNANDEZ', null, 'PADRE LUIS GALEANO -1139', 'Vera y Zarate 3275', null, 1, '150837410005', 'Fundacion Fadetea', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (17, 'PENOVI FACUNDO', 'HERNANDEZ', null, 'PADRE LUIS GALEANO -1139', 'Nazareth 3399', null, 1, '150837410005', 'Escuela Escuti', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (18, 'MARIA CELESTE', 'LOPEZ', null, 'MARIO RUFINO - 1548 - LOS GRANADOS', 'Comechingones 1359 - Los Platanos', null, 1, '111053917067', 'Ckary Ckay', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (19, 'FRANCISCO', 'MANZANELLI', null, 'PUNTA DEL ESTE -4581 -CABO FARINA', 'Pabio Mirizzi 234 - Cordoba', null, 1, '107188365064', 'Centro Rayuela', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (20, 'FRANCISCO', 'MANZANELLI', null, 'PUNTA DEL ESTE -4581 -CABO FARINA', 'Av Velez Sarfield 1490', null, 1, '107188365064', 'Ipem 246 Amadeo Sabattini', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (21, 'VICTORIA JULIANA', 'MENDOZA', null, 'SGTO. CABRAL 1757', 'Juan Arganaraz 1756', null, 1, '121319790036', 'Centro Mater', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (22, 'IGNACIO GERMAN', 'MENDOZA ESCOBAR', null, 'MZA. B - LOTE 22 - BARRIO EMANUEL 2', 'Pabio Mirizzi 234 - Cordoba', null, 1, '128851102022', 'Mercedes Bataglia', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (23, 'MARIA CECILIA', 'MUÑOZ', null, 'JUNIN 3637', 'Juan Arganaraz 1756', null, 1, '211239211039', 'Centro Mater', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (24, 'SOFIA AGUSTINA', 'NAVAS', null, 'BARADERO 3526', 'Jose Javier Diaz 844', null, 1, '221397725057', 'Mariela Rios', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (25, 'SOFIA AGUSTINA', 'NAVAS', null, 'BARADERO 3526', 'Asturias 1947', null, 1, '221397725057', 'Escuela Jose Hernandez', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (26, 'AGUSTINA LEILA', 'NAZZETA', null, 'MENDIOLAZA 995', 'Aconcagua 1815', null, 1, '254761021002', 'Centro Lazos', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (27, 'ALMA LUDMILA', 'NUÑEZ', null, 'SARMIENTO - 665 - MALVINAS ARGENTINAS', 'Agustin Garzon 2912', null, 1, '227038675026', 'Centro Rayuela', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (28, 'BRENDA TATIANA', 'OCAÑO', null, 'AMBARGASTA, 2631 - BARRIO EMPALME', 'Dumesnil 1449', null, 1, '210377844047', 'Fundacion Senda Azul', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (29, 'PABLO ELIAS', 'OCHOA SAYAGO', null, 'MONTEMAYOR 2509', 'Vera y Zarate 3275', null, 1, '221902545014', 'Fundacion Fadetea', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (30, 'ISMAEL AGUSTIN', 'ORTEGA', null, 'PJE NUÑEZ 34 CIUDAD CRUZ DEL EJE', 'Vera y Zarate 3275', null, 1, '108435781091', 'Fundacion Fadetea', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (31, 'AGUSTIN DANIEL', 'ORTIZ QUIROZ', null, 'LUIS PASTEUR 2661', 'DR Pablo Mirizzi 234', null, 1, '233881987017', 'Mercedes Bataglia', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (32, 'CIRO YUTHIEL', 'PERALTA', null, 'VICENTE DUPUY - 3370', 'Pabio Mirizzi 234 - Cordoba', null, 1, '238984926011', 'Mercedes Bataglia', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (33, 'MARIA ANGELES', 'PERALTA', null, 'LA BANDA ESQ. TRELEW', 'DR Antolin Torres 3500', null, 1, '130122560033', 'Escuela Republica Francoa', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (34, 'NOHA SAMIR', 'PERALTA', null, 'VICENTE DUPUY -3370', 'Pabio Mirizzi 234 - Cordoba', null, 1, '238984926020', 'Mercedes Bataglia', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (35, 'FABRICIO', 'PERESOTTI', null, 'LEUBUCO - 5028', 'Vera y Zarate 3275', null, 1, '110772438122', 'Fundacion Fadetea', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (36, 'MALENA', 'QUINTERO', null, 'PUENTE DEL INCA -877', 'Fray Bentos 4596', null, 1, '127097347033', 'Jardin Bancalari', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (37, 'MALENA', 'QUINTERO', null, 'PUENTE DEL INCA -877', 'Abreu D Figueroa 2831', null, 1, '127097347033', 'Mariela Rios', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (38, 'ULISES', 'QUINTERO', null, 'PUENTE DEL INCA 877', 'Monterrosso 4597', null, 1, '127097347025', 'Escuela Bancalari', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (39, 'ULISES', 'QUINTERO', null, 'PUENTE DEL INCA 877', 'Jose Javier Diaz 844', null, 1, '127097347025', 'Mariela Rios', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (40, 'LUCAS', 'RIVERO VELARDES', null, '6 DE JULIO· 252 - VILLA SAN NICOLAS', 'Av Gauss 5676', null, 1, '223079500023', 'Contener Multiespacios', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (41, 'LUCAS', 'RIVERO VELARDES', null, '6 DE JULIO· 252 - VILLA SAN NICOLAS', 'Principal 231 Malagueño', null, 1, '223079500023', 'Escuela Juan XXIII', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (42, 'MARIA FERNANDA', 'SALAS SALTO', null, 'PERU 1628', 'Feliz Paz 436', null, 1, '216157636011', 'Ckary Ckay', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (43, 'JULIETA MILAGRO', 'SANCHEZ CORTES', null, 'AV VELEZ SARSFIELD 6036', 'Vera y Zarate 3275', null, 1, '206494126061', 'Fundacion Fadetea', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (44, 'ALEJO EZEQUIEL', 'SOSA', null, 'TILCARA 711', 'Aconcagua 1815', null, 1, '120860393055', 'Centro Lazos', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (45, 'LIHUEL VALENTIN', 'VALERO', null, 'MZA. 175 - LOTE  2 - CNO. CHACRA DE LA MERCED - MALVINAS  ARGENTINAS', 'Jujuy 48', null, 1, '231057811027', 'Viviana Monzalvo', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (46, 'FACUNDO TOMAS', 'ORTIZ', null, 'AV COLON 1315', 'Vera y Zarate 3275', null, 1, '126181812053', 'Fundacion Fadetea', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (47, 'ANA MARIA', 'CORTEZ', null, 'FELIX PAZ 1019', 'CASTRO BARROS 88', null, 1, '201060886014', 'Luciano Rovere', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (48, 'MARIA ANGELES', 'PERALTA', null, 'LA BANDA 3912 Barrio Parque Atlantica', 'DR Pablo Mirizzi 234', null, 1, '130122560033', 'Mercedes Bataglia', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (49, 'JULIAN BENJAMIN', 'PAEZ', null, 'MZNA 11 CASA 18 s/n Ampliacion Vicor', 'DR Pablo Mirizzi 234', null, 1, '125286990034', 'Mercedes Bataglia', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (50, 'CYNTHIA GISELL', 'MIRETTI', null, 'GRAL BUSTOS 928 BARRIO 17 de Octubre Malagueño', 'Dean Funes 2327', null, 1, '221489618010', 'Fundacion Bonino', 2);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (51, 'EZEQUIEL URIEL', 'GIGENA RAMALLO', null, 'LEON 1974 Maipu Secc 1', 'Escuela Especial Beatriz M ALLIO Maestro lopez s/n C Universitaria', null, 1, '23763529046', 'Escuela ALLIO', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (52, 'TOMAS MATEO', 'GUTIERREZ', null, 'Tilcara 1012', 'Escuela Especial Beatriz M ALLIO Maestro lopez s/n C Universitaria', null, 1, '125268085082', 'Escuela ALLIO', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (53, 'JUAN FRANCISCO', 'VICICHI', null, 'Rossi s/n Centro Norte Montecristo', 'Rafael Nuñez 951 Pilar (Pcia de Cordoba)', null, 1, '228522922034', 'Romero Paola Andrea', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (54, 'MARIA A','CABALIA SFORZINI', null, 'HECTOR PANIZA 3172', 'Dean Funes 2327', null, 1, '217316561026', 'Fundacion Bonino', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (55, 'MATEO FRANCISCO', 'MERLO', null, 'Francisco Gurruchaga 650', 'Dr Pablo Mirizzi 234', null, 1, '125754803025', 'Fundacion Fadetea', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (56, 'LEONARDO LEONEL', 'SANCHEZ', null, 'LOS TINTINES-808-AMPLIACION-AMERICA', 'Dr Pablo Mirizzi 234', null, 1, '231668709025', '', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (57, 'SAYEN MAILEN', 'SANCHEZ GIL', null, 'ALONSO DE VERA Y ARAGON 680', 'Dr Pablo Mirizzi 234', null, 1, '225267106040', '', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (58, 'LIAN ENZO', 'MAIDANA', null, 'MANUEL ANDRADA 806 MALVINAS ARGENTINAS', 'DUARTE QUIROZ 828', null, 1, '130652042030', '', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (59, 'BELTRAN IGNACIO', 'LUDUEÑA', null, 'AGUARIGUAY MZNA 5 Lote 17 s/n VILLA SAN NICOLAS', 'VERA Y ZARATE 3275', null, 1, '133270128053', '', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (60, 'MATEO BAUTISTA', 'TOLOSA', null, 'TOMAS GUIDO 787 Dpto 26', 'Dr Pablo Mirizzi 234', null, 1, '137475357031', '', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (61, 'INDIRA ANTONELLA', 'CAMPOS', null, 'ALEJANDRO DANEL 2533', 'VERA Y ZARATE 3275', null, 1, '116083074042', '', 1);
INSERT INTO afiliados (id_afiliado, nombre, apellido, nro_documento, direccion, direccion_hasta, telefono, estado, nro_afiliado, profesional, id_transportista) VALUES (62, 'ARIADNA V', 'BAIGORRI HERRERA', null, 'DR JOSE PIZARRO 583', 'VERA Y ZARATE 3275', null, 1, '231556798018', '', 1);


INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (1, 1, 1);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (2, 2, 1);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (3, 3, 1);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (4, 4, 1);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (5, 5, 1);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (6, 1, 2);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (7, 2, 2);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (8, 4, 2);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (9, 5, 2);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (10, 1, 3);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (11, 2, 3);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (12, 3, 3);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (13, 4, 3);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (14, 5, 3);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (15, 1, 4);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (16, 3, 4);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (17, 5, 4);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (18, 1, 5);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (19, 2, 5);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (20, 4, 5);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (21, 5, 5);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (22, 1, 6);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (23, 3, 6);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (24, 4, 6);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (25, 5, 6);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (26, 1, 7);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (27, 3, 7);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (28, 4, 7);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (29, 5, 7);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (30, 2, 8);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (31, 5, 8);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (32, 1, 9);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (33, 2, 9);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (34, 3, 9);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (35, 4, 9);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (36, 5, 9);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (37, 2, 10);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (38, 4, 10);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (39, 5, 10);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (40, 1, 11);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (41, 3, 11);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (42, 4, 11);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (43, 5, 11);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (44, 1, 12);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (45, 2, 12);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (46, 3, 12);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (47, 4, 12);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (48, 5, 12);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (49, 1, 13);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (50, 2, 13);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (51, 3, 13);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (52, 4, 13);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (53, 5, 13);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (54, 1, 14);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (55, 2, 14);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (56, 3, 14);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (57, 5, 14);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (58, 1, 15);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (59, 3, 15);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (60, 4, 15);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (61, 5, 15);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (62, 1, 16);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (63, 3, 16);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (64, 5, 16);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (65, 1, 17);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (66, 2, 17);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (67, 3, 17);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (68, 4, 17);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (69, 5, 17);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (70, 1, 18);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (71, 2, 18);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (72, 3, 18);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (73, 4, 18);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (74, 5, 18);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (75, 1, 19);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (76, 4, 19);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (77, 5, 19);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (78, 1, 20);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (79, 2, 20);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (80, 3, 20);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (81, 4, 20);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (82, 5, 20);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (83, 1, 21);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (84, 2, 21);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (85, 3, 21);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (86, 4, 21);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (87, 5, 21);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (88, 1, 22);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (89, 3, 22);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (90, 4, 22);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (91, 5, 22);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (92, 1, 23);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (93, 2, 23);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (94, 3, 23);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (95, 4, 23);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (96, 5, 23);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (97, 1, 24);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (98, 2, 24);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (99, 3, 24);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (100, 4, 24);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (101, 5, 24);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (102, 1, 25);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (103, 2, 25);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (104, 3, 25);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (105, 4, 25);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (106, 5, 25);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (107, 1, 26);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (108, 3, 26);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (109, 5, 26);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (110, 2, 27);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (111, 3, 27);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (112, 4, 27);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (113, 1, 28);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (114, 2, 28);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (115, 3, 28);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (116, 4, 28);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (117, 5, 28);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (118, 1, 29);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (119, 3, 29);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (120, 5, 29);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (121, 1, 30);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (122, 3, 30);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (123, 5, 30);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (124, 1, 31);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (125, 2, 31);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (126, 3, 31);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (127, 4, 31);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (128, 1, 32);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (129, 4, 32);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (130, 5, 32);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (131, 1, 33);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (132, 2, 33);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (133, 3, 33);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (134, 4, 33);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (135, 5, 33);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (136, 1, 34);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (139, 4, 34);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (140, 5, 34);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (141, 1, 35);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (142, 3, 35);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (143, 4, 35);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (144, 5, 35);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (145, 1, 36);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (146, 2, 36);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (147, 3, 36);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (148, 4, 36);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (149, 5, 36);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (150, 1, 37);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (151, 2, 37);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (152, 3, 37);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (153, 4, 37);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (154, 5, 37);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (155, 1, 38);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (156, 2, 38);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (157, 3, 38);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (158, 4, 38);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (159, 5, 38);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (160, 2, 39);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (161, 3, 39);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (162, 4, 39);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (163, 5, 39);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (164, 2, 40);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (165, 4, 40);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (166, 5, 40);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (167, 1, 41);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (168, 2, 41);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (169, 3, 41);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (170, 4, 41);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (171, 5, 41);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (172, 1, 42);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (173, 2, 42);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (174, 3, 42);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (175, 4, 42);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (176, 5, 42);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (177, 1, 43);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (178, 2, 43);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (179, 4, 43);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (180, 5, 43);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (181, 1, 44);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (182, 3, 44);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (183, 5, 44);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (184, 1, 45);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (185, 3, 45);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (186, 4, 45);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (187, 5, 45);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (188, 1, 46);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (189, 2, 46);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (190, 3, 46);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (191, 4, 46);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (192, 5, 46);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (193, 1, 47);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (194, 3, 47);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (195, 5, 47);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (196, 1, 48);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (197, 4, 48);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (198, 5, 48);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (199, 1, 49);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (200, 4, 49);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (201, 5, 49);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (202, 1, 50);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (203, 2, 50);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (204, 3, 50);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (205, 4, 50);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (206, 5, 50);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (207, 1, 51);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (208, 2, 51);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (209, 3, 51);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (210, 4, 51);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (211, 5, 51);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (212, 1, 52);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (213, 2, 52);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (214, 3, 52);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (215, 4, 52);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (216, 5, 52);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (217, 1, 53);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (218, 4, 53);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (219, 5, 53);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (220, 1, 54);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (221, 2, 54);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (222, 3, 54);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (223, 4, 54);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (224, 5, 54);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (225, 1, 55);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (226, 2, 55);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (227, 3, 55);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (228, 4, 55);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (229, 5, 55);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (230, 2, 56);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (231, 3, 56);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (232, 4, 56);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (233, 5, 56);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (234, 1, 57);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (235, 3, 57);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (236, 4, 57);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (237, 5, 57);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (238, 2, 58);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (239, 3, 58);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (240, 4, 58);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (241, 5, 58);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (242, 2, 59);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (243, 3, 59);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (244, 4, 59);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (245, 5, 59);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (246, 2, 60);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (247, 3, 60);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (248, 4, 60);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (249, 5, 60);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (250, 1, 61);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (251, 2, 61);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (252, 4, 61);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (253, 5, 61);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (254, 1, 62);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (255, 2, 62);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (256, 4, 62);
INSERT INTO recorridos (id_recorrido, dia_recorrido, id_afiliado) VALUES (257, 5, 62);