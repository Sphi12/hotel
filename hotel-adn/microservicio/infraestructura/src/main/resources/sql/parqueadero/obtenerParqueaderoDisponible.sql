select p.id from parqueadero p inner join tipoparqueadero tp
    on p.id = tp.id where tp.nombre = :nombre and p.disponible = "1" limit 1