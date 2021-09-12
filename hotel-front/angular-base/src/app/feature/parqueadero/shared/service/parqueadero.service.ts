import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Parqueadero } from '../model/parqueadero';

@Injectable()
export class ParqueaderoService {
  constructor(private http: HttpService) {}

  public listar() {
    return this.http.doGet<Parqueadero[]>(
      `${environment.endpoint}/parqueaderos`,
      this.http.optsName('consultar parqueadero')
    );
  }

  public crear(parqueadero: Parqueadero) {
    console.log(parqueadero.idTipoParqueadero);
    return this.http.doPost<Parqueadero, any>(
      `${environment.endpoint}/parqueaderos`,
      parqueadero,
      this.http.optsName('crear/actualizar parqueadero')
    );
  }

}
