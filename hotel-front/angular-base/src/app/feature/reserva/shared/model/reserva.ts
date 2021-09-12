export class Reserva {
  id: number;
  idHabitacion: number;
  tipoHabitacion: string;
  idParqueadero: number;
  tipoParqueadero: string;
  idUsuario: number;
  fechaReserva: Date;
  fechaIngreso: Date;
  fechaSalida: Date;
  precioTotal: number;
  checkIn: string;
  checkOut: string;

  constructor(
    id: number,
    idHabitacion: number,
    tipoHabitacion: string,
    idParqueadero: number,
    tipoParqueadero: string,
    idUsuario: number,
    fechaReserva: Date,
    fechaIngreso: Date,
    fechaSalida: Date,
    precioTotal: number,
    checkIn: string,
    checkOut: string,
  ) {
    this.id = id;
    this.idHabitacion = idHabitacion;
    this.tipoHabitacion = tipoHabitacion;
    this.idParqueadero = idParqueadero;
    this.tipoParqueadero = tipoParqueadero;
    this.idUsuario = idUsuario;
    this.fechaReserva = fechaReserva;
    this.fechaIngreso = fechaIngreso;
    this.fechaSalida = fechaSalida;
    this.precioTotal = precioTotal;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }
}
