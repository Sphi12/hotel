update tipoHabitacion
set nombre = :nombre,
	descripción = :descripción,
	precioSemana = :precioSemana,
	precioFinSemana = :precioFinSemana,
	capacidadPersonas = :capacidadPersonas,
	numeroCamas = :numeroCamas,
	descripcionCamas = :descripcionCamas,
where id = :id