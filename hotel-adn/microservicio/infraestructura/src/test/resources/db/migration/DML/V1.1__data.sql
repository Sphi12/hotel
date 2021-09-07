insert into usuario(id,nombre,clave,fecha_creacion) values(1,'test','1234',now());
insert into tipohabitacion (id, nombre, descripcion, precioSemana, precioFinSemana, capacidadPersonas, numeroCamas, descripcionCamas) VALUES (1, 'individual', 'Habitacion individual', 90000, 110000, 1, 1, '1 cama individual');
insert into tipoparqueadero (id, nombre,descripción,precio) values (1,'carro','carro',3000);
insert into habitacion (id,tipo,disponible) values (1,1,1);
insert into parqueadero(id,idTipoParqueadero, disponible) values (1,1,1);
INSERT INTO RESERVA(ID_RESERVA, ID_HABITACION, TIPO_ID_HABITACION, ID_PARQUEADERO, TIPO_PARQUEADERO, ID_USUARIO, FECHA_RESERVA, FECHA_INGRESO, FECHA_SALIDA, PRECIO_TOTAL, CHECK_IN, CHECK_OUT) VALUES (1, 1, 'individual', 1, 'carro', 1, '2021-09-02 00:49:53', '2021-09-03', '2021-09-07', '451800', '0', '0');
