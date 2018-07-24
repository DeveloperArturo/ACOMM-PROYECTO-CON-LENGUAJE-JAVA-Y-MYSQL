create database acomm;
use  acomm;

create table usuarios
(

	cod_usuarios int,
    nombre varchar(200),
	apellido_paterno varchar(200),
    apellido_materno varchar(200),
	tipo varchar(20),
	turno varchar(20),
	passwor varchar(200),
	imagen longblob

);


select*from usuarios;


create table seguridad(

	users int,
    seguro varchar(200)


);

select*from seguridad;

insert into seguridad values(2,'123');



create table llegada_usuarios(

	usuarioget varchar(200),
    fecha varchar(200),
    hora varchar(200)

);




create table cliente
(
	cod_cliente int ,
    nombre varchar(200),
	apellido_paterno varchar(200),
    apellido_materno varchar(200),
    direccion varchar (200),
    fecha_nacimiento  varchar(40),
    fecha_afilicacion varchar(40),
    estado_civil char (50),
    tipo_cliente varchar (2000),
    dni int,
    cod_usuarios varchar(100),
    telefono int,
    image longblob
);





create   table bebidas
(
	cod_bebida int ,
    nombre varchar (200),
    marca varchar (200),
    tipo varchar (100),
    precio decimal (40,2),
    estado varchar(100),
    image longblob
);

select*from bebidas;

create table cancion
(
	cod_cancion int ,
    nombre varchar (200),
    duracion varchar (20),
    cod_artista int,
    album varchar (200),
    catalogo varchar (200),
    estado varchar(100),
    image longblob
);


select*from cancion;




create table artista
(
	cod_artista int,
    nombre varchar (200),
    cod_genero int,
    registro_catalogo varchar (200),
    estado varchar(200),
    image longblob
);

create table genero
(
	cod_genero int,
    descripcion varchar (200),
    procedencia varchar (200),
    epoca varchar(200),
    estado varchar (200),
    image longblob
);








create table pedido
(
	cod_pedido int,
    fecha_pedido varchar(100),
    cod_usuario varchar(40),
    hora_reserva varchar (100),
    estado varchar (200),
    cancion int,
    bebida int,
    piqueo int
);







create table piqueo
(
	cod_piqueo int ,
    nombre varchar (200),
    tipo_piqueo varchar (200),
    precio decimal (40,2),
    estado varchar (200),
    image longblob
);




create table registro
(
	cod_usuario int,
    fecha date,
    hora varchar (10)
);

create table reserva
(
	cod_reserva int,
    cod_pedido  varchar(200),
    cod_usuario varchar(200) ,
    cod_cliente varchar(200),
    fecha  varchar(200),
    hora varchar (100)
);








create table detalle
(
	consumo int ,
    cod_cliente varchar(200),
    cod_bebida int, 
    precio_bebida decimal(40,2),
    cod_piqueo int,  
    precio_piqueo decimal(40,2),
    fecha  varchar(200),
    total decimal(40,2)
);


select*from detalle;





create table añadir_bebida
(
	cod_reserva varchar(200),
    cod_bebida int,
    nombre varchar (200),
    marca varchar (200),
    tipo_bebida varchar (100),
    estado varchar (200),
    precio decimal (40,2)
);
SET SQL_SAFE_UPDATES=0; 
select*from añadir_bebida;
delete from añadir_bebida  where cod_bebida=1001;


create table anadir_pequio
(
	
    cod_reserva varchar(200),
    cod_piqueo int,
    nombre varchar (200),
    tipo_piqueo varchar (200),
    estado varchar (200),
    precio decimal(40,2)
);



select*from  anadir_pequio;




                     

create table añadir_cancion
(
	cod_reserva varchar(200),
    cod_cancion int,
    nombre varchar (200),
    duracion varchar (20),
    cod_artista int,
    album varchar(200),
    registro varchar (200),
    estado varchar (200)
);



create table prestamo
(
	cod_prestamo varchar(200),
    cod_usuario varchar(200),
    cod_cliente varchar(200),
    fecha varchar(200),
    ubicacion varchar(200)
);
select*from prestamo;
	
create table king(
	cantidad varchar(200)
);


insert into king values('20');

select*from king;



