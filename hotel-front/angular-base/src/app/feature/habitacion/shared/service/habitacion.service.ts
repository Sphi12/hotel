import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Habitacion } from '../model/habitacion';

@Injectable()
export class HabitacionService {
  constructor(private http: HttpService) {}

  public listar() {
    return this.http.doGet<Habitacion[]>(
      `${environment.endpoint}/habitaciones`,
      this.http.optsName('consultar habitaciones')
    );
  }

  public crear(habitacion: Habitacion) {
    habitacion.disponible = 'true' ;
    return this.http.doPost<Habitacion, any>(
      `${environment.endpoint}/habitaciones`,
      habitacion,
      this.http.optsName('crear/actualizar habitaciones')
    );
  }
}
