import { Component, OnInit } from '@angular/core';
import { Habitacion } from '../../shared/model/habitacion';
import { HabitacionService } from '../../shared/service/habitacion.service';
import { Observable } from 'rxjs';
import { TipoHabitacion } from '../../../tipoHabitacion/shared/model/tipoHabitacion';
import { TipoHabitacionService } from '../../../tipoHabitacion/shared/service/tipoHabitacion.service';

@Component({
  selector: 'app-listar-habitacion',
  templateUrl: './listar-habitacion.component.html',
  styleUrls: ['./listar-habitacion.component.scss'],
})
export class ListarHabitacionComponent implements OnInit {
  public listaHabitacion: Observable<Habitacion[]>;
  public listatipoHabitacion: Observable<TipoHabitacion[]>;

  constructor(
    private habitacionService: HabitacionService,
    private tipoHabitacionService: TipoHabitacionService
  ) {}

  ngOnInit() {
    this.listaHabitacion = this.habitacionService.listar();
    this.listatipoHabitacion = this.tipoHabitacionService.listar();
  }

}
