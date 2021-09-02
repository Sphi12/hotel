insert into usuario(id,nombre,clave,fecha_creacion) values(1,'test','1234',now());
insert into tipohabitacion (id, nombre, descripcion, precioSemana, precioFinSemana, capacidadPersonas, numeroCamas, descripcionCamas) VALUES (1, 'individual', 'Habitacion individual', 90000, 110000, 1, 1, '1 cama individual');
insert into tipoparqueadero (id, nombre,descripción,precio) values (1,'carro','carro',3000);
insert into habitacion (id,tipo,disponible) values (1,1,1);
insert into parqueadero(id,idTipoParqueadero, disponible) values (1,1,1);