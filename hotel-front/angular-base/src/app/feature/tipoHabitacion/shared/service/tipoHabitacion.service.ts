import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { TipoHabitacion } from '../model/tipoHabitacion';

@Injectable()
export class TipoHabitacionService {
  constructor(private http: HttpService) {}

  public listar() {
    return this.http.doGet<TipoHabitacion[]>(
      `${environment.endpoint}/tipohabitacion`,
      this.http.optsName('consultar tipo habitaciones')
    );
  }

}
