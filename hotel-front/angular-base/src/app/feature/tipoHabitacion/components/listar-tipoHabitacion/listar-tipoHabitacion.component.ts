import { Component, OnInit } from '@angular/core';
import { TipoHabitacion } from '../../shared/model/tipoHabitacion';
import { TipoHabitacionService } from '../../shared/service/tipoHabitacion.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-listar-habitacion',
  templateUrl: './listar-tipoHabitacion.component.html',
  styleUrls: ['./listar-tipoHabitacion.component.scss'],
})
export class ListarTipoHabitacionComponent implements OnInit {
  public listatipoHabitacion: Observable<TipoHabitacion[]>;

  constructor(
    private tipoHabitacionService: TipoHabitacionService,
  ) {}

  ngOnInit() {
    this.listatipoHabitacion = this.tipoHabitacionService.listar();
  }

  obtenerTiposDeHabitacion(){
    return this.listatipoHabitacion;
  }
}
