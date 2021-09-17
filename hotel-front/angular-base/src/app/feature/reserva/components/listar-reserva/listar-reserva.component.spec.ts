import { waitForAsync, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarReservaComponent } from './listar-reserva.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { ReservaService } from '../../shared/service/reserva.service';
import { HttpService } from 'src/app/core/services/http.service';
import { Reserva } from '../../shared/model/reserva';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';

describe('ListarReservaComponent', () => {
  let component: ListarReservaComponent;
  let fixture: ComponentFixture<ListarReservaComponent>;
  let reservaService: ReservaService;
  const listaReservas: Reserva[] = [
    {
      id: 1,
      idHabitacion: 2,
      tipoHabitacion: 'individual',
      idParqueadero: 1,
      tipoParqueadero: 'carro',
      idUsuario: 1,
      fechaReserva: new Date('2021-09-07 20:32:27'),
      fechaIngreso: new Date('2021-09-08'),
      fechaSalida: new Date('2021-09-10'),
      precioTotal: 186000.0,
      checkIn: 'true',
      checkOut: 'false'
    },
    {
      id: 2,
      idHabitacion: 1,
      tipoHabitacion: 'individual',
      idParqueadero: 1,
      tipoParqueadero: 'carro',
      idUsuario: 1,
      fechaReserva: new Date('2021-09-07 20:48:30'),
      fechaIngreso: new Date('2021-09-08'),
      fechaSalida: new Date('2021-09-10'),
      precioTotal: 186000.0,
      checkIn: 'true',
      checkOut: 'true'
    },
    {
      id: 3,
      idHabitacion: 1,
      tipoHabitacion: 'Individual',
      idParqueadero: 1,
      tipoParqueadero: 'Moto',
      idUsuario: 1097729359,
      fechaReserva: new Date('2021-09-08 16:36:04'),
      fechaIngreso: new Date('2021-09-16'),
      fechaSalida: new Date('2021-09-22'),
      precioTotal: 538200.0,
      checkIn: 'false',
      checkOut: 'false'
    },
  ];

  beforeEach(
    waitForAsync(() => {
      TestBed.configureTestingModule({
        declarations: [ListarReservaComponent],
        imports: [CommonModule, HttpClientModule, RouterTestingModule],
        providers: [ReservaService, HttpService, ModalNotificaciones],
      }).compileComponents();
    })
  );

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarReservaComponent);
    component = fixture.componentInstance;
    reservaService = TestBed.inject(ReservaService);
    spyOn(reservaService, 'listar').and.returnValue(of(listaReservas));
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
