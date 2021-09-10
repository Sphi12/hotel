update tipoHabitacion
set nombre = :nombre,
	descripcion = :descripcion,
	precioSemana = :precioSemana,
	precioFinSemana = :precioFinSemana,
	capacidadPersonas = :capacidadPersonas,
	numeroCamas = :numeroCamas,
	descripcionCamas = :descripcionCamas,
where id = :id