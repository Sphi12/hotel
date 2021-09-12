import { CrearReservaComponent } from './crear-reserva.component';
import { waitForAsync, ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';

import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from 'src/app/core/services/http.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ReservaService } from '../../shared/service/reserva.service';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';

describe('CrearSolicitudComponent', () => {
  let component: CrearReservaComponent;
  let fixture: ComponentFixture<CrearReservaComponent>;
  let reservaService: ReservaService;

  beforeEach(
    waitForAsync(() => {
      TestBed.configureTestingModule({
        declarations: [CrearReservaComponent],
        imports: [
          CommonModule,
          HttpClientModule,
          RouterTestingModule,
          ReactiveFormsModule,
          FormsModule,
        ],
        providers: [ReservaService, HttpService, ModalNotificaciones],
      }).compileComponents();
    })
  );

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearReservaComponent);
    component = fixture.componentInstance;
    reservaService = TestBed.inject(ReservaService);
    spyOn(reservaService, 'crear').and.returnValue(of({ valor: 18 }));
    fixture.detectChanges();
  });

  it('Formulario es invalido cuando esta vacio', () => {
    expect(component.envioForm.valid).toBeFalsy();
  });

  it('Registrando reserva', () => {
    expect(component.envioForm.valid).toBeFalsy();
    component.envioForm.controls.tipoHabitacion.setValue('individual');
    component.envioForm.controls.tipoParqueadero.setValue('carro');
    component.envioForm.controls.idUsuario.setValue(1097729359);
    component.envioForm.controls.fechaIngreso.setValue('2021-09-08');
    component.envioForm.controls.fechaSalida.setValue('2021-09-10');
    expect(component.envioForm.valid).toBeTruthy();
    component.crear();
  });
});
