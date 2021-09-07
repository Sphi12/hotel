select h.id from habitacion h inner join tipohabitacion tp
	on h.tipo = tp.id where tp.nombre = :nombre and h.disponible = '1' limit 1