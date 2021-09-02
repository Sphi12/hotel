select id,nombre,descripcion,precioSemana,precioFinSemana,capacidadPersonas,numeroCamas,descripcionCamas
from tipoHabitacion
where nombre = :nombre