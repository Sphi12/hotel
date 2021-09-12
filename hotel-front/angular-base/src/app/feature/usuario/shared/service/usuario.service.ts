import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Usuario } from '../model/usuario';

@Injectable()
export class UsuarioService {
  constructor(private http: HttpService) {}

  public listar() {
    return this.http.doGet<Usuario[]>(
      `${environment.endpoint}/usuarios`,
      this.http.optsName('consultar usuarios')
    );
  }

  public crear(usuario: Usuario) {
    return this.http.doPost<Usuario, any>(
      `${environment.endpoint}/usuarios`,
      usuario,
      this.http.optsName('crear/actualizar usuario')
    );
  }

}
