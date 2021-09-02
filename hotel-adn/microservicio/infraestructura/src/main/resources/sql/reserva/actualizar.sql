update RESERVA
set ID_HABITACION = :idHabitacion,
	ID_PARQUEADERO = :idParqueadero,
	ID_USUARIO = :idUsuario,
	FECHA_RESERVA = :fechaReserva,
	FECHA_INGRESO = :fechaIngreso,
	FECHA_SALIDA = :fechaSalida,
	PRECIO_TOTAL = :precioTotal,
	CHECK_IN = :checkIn,
	CHECK_OUT = :checkOut
where ID_RESERVA = :id