create table IF NOT EXISTS usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id))
ENGINE = InnoDB;

create table IF NOT EXISTS habitacion (
 id int(11) not null auto_increment,
 tipo int(11) not null,
 disponible boolean not null,
 primary key (id)
)ENGINE = InnoDB;


create table IF NOT EXISTS parqueadero (
 id int(11) not null auto_increment,
 idTipoParqueadero int(11) not null,
 disponible boolean not null,
 primary key (id)
)ENGINE = InnoDB;


create table IF NOT EXISTS tipoHabitacion (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 descripcion varchar(100) not null,
 precioSemana number not null,
 precioFinSemana number not null,
 capacidadPersonas int(10) not null,
 numeroCamas int(10) not null,
 descripcionCamas varchar(100) not null,
 primary key (id)
)ENGINE = InnoDB;


create table IF NOT EXISTS tipoParqueadero (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 descripción varchar(100) not null,
 precio number not null,
 primary key (id)
)ENGINE = InnoDB;
