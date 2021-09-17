import { Component, OnInit } from '@angular/core';
import { Habitacion } from '../../shared/model/habitacion';
import { HabitacionService } from '../../shared/service/habitacion.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-listar-habitacion',
  templateUrl: './listar-habitacion.component.html',
  styleUrls: ['./listar-habitacion.component.scss'],
})
export class ListarHabitacionComponent implements OnInit {
  public listaHabitacion: Observable<Habitacion[]>;
 
  constructor(
    private habitacionService: HabitacionService,
    
  ) {}

  ngOnInit() {
    this.listaHabitacion = this.habitacionService.listar();
  
  }

}
