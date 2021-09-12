export class Habitacion {
  id: number;
  tipo: number;
  disponible: string;

  constructor(
    id: number,
    tipo: number,
    disponible: string,
  ) {
    this.id = id;
    this.tipo = tipo;
    this.disponible = disponible;
  }
}
