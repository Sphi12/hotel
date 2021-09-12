import { Component, OnInit } from '@angular/core';
import { Reserva } from '../../shared/model/reserva';
import { Observable } from 'rxjs';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-solicitud',
  templateUrl: './reserva.component.html',
  styleUrls: ['./reserva.component.scss']
})
export class ReservaComponent implements OnInit {

  public reserva: Observable<Reserva>;
  envioForm: FormGroup;
  id: number

   constructor(
  ) {}

  ngOnInit() {
  }

  navegarABuscar(id: number) {

    console.log(id)
  }

}
