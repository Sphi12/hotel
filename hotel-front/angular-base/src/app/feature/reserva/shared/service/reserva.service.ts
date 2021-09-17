import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Reserva } from '../model/reserva';

@Injectable()
export class ReservaService {
  constructor(private http: HttpService) {}

  reservaActiva: Reserva;

  seleccionarReserva(reservaActiva: Reserva) {
    this.reservaActiva = reservaActiva;
    return this.reservaActiva;
  }

  public listar() {
    return this.http.doGet<Reserva[]>(
      `${environment.endpoint}/reservas`,
      this.http.optsName('consultar reservas')
    );
  }

  public obtener(reserva: Reserva) {
    return this.http.doGet<Reserva>(
      `${environment.endpoint}/reservas/${reserva.id}`,
      this.http.optsName('consultar reserva')
    );
  }

  public crear(reserva: Reserva) {
    return this.http.doPost<Reserva, any>(
      `${environment.endpoint}/reservas`,
      reserva,
      this.http.optsName('crear/actualizar reservas')
    );
  }

  public editar(reserva: Reserva) {
    return this.http.doPut<any, any>(
      `${environment.endpoint}/reservas/${reserva.id}`,
      reserva,
      this.http.optsName('editar reserva')
    );
  }


  public eliminar(reserva: Reserva) {
    return this.http.doPut<any, any>(
      `${environment.endpoint}/api/v1/solicitudes/${reserva.id}`,
      reserva,
      this.http.optsName('cancelar solicitud')
    );
  }
}
