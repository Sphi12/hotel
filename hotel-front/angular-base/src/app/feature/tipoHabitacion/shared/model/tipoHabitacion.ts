export class TipoHabitacion {
  id: number;
  nombre: string;
  descripción: string;
  precioSemana: number;
  precioFinSemana: number;
  capacidadPersonas: number;
  numeroCamas: number;
  descripcionCamas: string;

  constructor(
    id: number,
    nombre: string,
    descripción: string,
    precioSemana: number,
    precioFinSemana: number,
    capacidadPersonas: number,
    numeroCamas: number,
    descripcionCamas: string,
  ) {
    this.id = id;
    this.nombre = nombre;
    this.descripción = descripción;
    this.precioSemana = precioSemana;
    this.precioFinSemana = precioFinSemana;
    this.capacidadPersonas = capacidadPersonas;
    this.numeroCamas = numeroCamas;
    this.descripcionCamas = descripcionCamas;

  }
}