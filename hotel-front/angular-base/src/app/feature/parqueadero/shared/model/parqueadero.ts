export class Parqueadero {
  id: number;
  idTipoParqueadero: number;
  disponible: string;

  constructor(
    id: number,
    idTipoParqueadero: number,
    disponible: string,
  ) {
    this.id = id;
    this.idTipoParqueadero = idTipoParqueadero;
    this.disponible = disponible;
  }
}

