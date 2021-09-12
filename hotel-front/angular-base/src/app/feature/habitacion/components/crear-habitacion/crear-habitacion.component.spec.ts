import { CrearHabitacionComponent } from './crear-habitacion.component';
import { waitForAsync, ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';

import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from 'src/app/core/services/http.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HabitacionService } from '../../shared/service/habitacion.service';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';

describe('CrearHabitacionComponent', () => {
  let component: CrearHabitacionComponent;
  let fixture: ComponentFixture<CrearHabitacionComponent>;
  let habitacionService: HabitacionService;

  beforeEach(
    waitForAsync(() => {
      TestBed.configureTestingModule({
        declarations: [CrearHabitacionComponent],
        imports: [
          CommonModule,
          HttpClientModule,
          RouterTestingModule,
          ReactiveFormsModule,
          FormsModule,
        ],
        providers: [HabitacionService, HttpService, ModalNotificaciones],
      }).compileComponents();
    })
  );

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearHabitacionComponent);
    component = fixture.componentInstance;
    habitacionService = TestBed.inject(HabitacionService);
    spyOn(habitacionService, 'crear').and.returnValue(of({ valor: 18 }));
    fixture.detectChanges();
  });

  it('formulario es invalido cuando esta vacio', () => {
    expect(component.envioForm.valid).toBeFalsy();
  });

  it('Registrando habitacion', () => {
    expect(component.envioForm.valid).toBeFalsy();
    component.envioForm.controls.tipo.setValue(2);
    expect(component.envioForm.valid).toBeTruthy();
    component.crear();
  });
});
