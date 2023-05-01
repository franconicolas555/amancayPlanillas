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
 obra_social varchar(100),
 id_transportista int,
 constraint fk_afiliados_transportista foreign key (id_transportista) references transportistas (id_transportista)
);

create table recorridos (
 id_recorrido int auto_increment primary key,
 dia_recorrido int,
 id_afiliado int,
 hora_hasta varchar(70),
 hora_desde varchar(70),
 description varchar(80),
 constraint fk_afiliados_recorridos foreign key (id_afiliado) references afiliados (id_afiliado)
);

CREATE TABLE feriados
(
    id_feriado int auto_increment primary key,
    fecha_feriado timestamp,
    description varchar(100)
);



insert into feriados (fecha_feriado,description) values ('2022-02-28 00:00:00','Feriado Carnaval).');
insert into feriados (fecha_feriado,description) values ('2022-05-18 00:00:00','Feriado Carnaval).');
insert into feriados (fecha_feriado,description) values ('2022-05-25 00:00:00','Feriado Carnaval).');

insert into transportistas (nombre,apellido,cuit,nro_prestador) values ('Claudia Maria Elvira','Bordolli','232098555054','2379');
insert into transportistas (nombre,apellido,cuit,nro_prestador) values ('Carlos Roberto','Barberis','20144089082','1466');

