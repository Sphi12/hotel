import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../shared/model/usuario';
import { UsuarioService } from '../../shared/service/usuario.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-listar-usuario',
  templateUrl: './listar-usuario.component.html',
  styleUrls: ['./listar-usuario.component.scss'],
})
export class ListarUsuarioComponent implements OnInit {
  public listaUsuario: Observable<Usuario[]>;

  constructor(
    private usuarioService: UsuarioService
  ) {}

  ngOnInit() {
    this.listaUsuario = this.usuarioService.listar();
  }


}
