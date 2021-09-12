import { CrearParqueaderoComponent } from './crear-parqueadero.component';
import { waitForAsync, ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';

import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from 'src/app/core/services/http.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ParqueaderoService } from '../../shared/service/parqueadero.service';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';

describe('CrearParqueaderoComponent', () => {
  let component: CrearParqueaderoComponent;
  let fixture: ComponentFixture<CrearParqueaderoComponent>;
  let parqueaderoService: ParqueaderoService;

  beforeEach(
    waitForAsync(() => {
      TestBed.configureTestingModule({
        declarations: [CrearParqueaderoComponent],
        imports: [
          CommonModule,
          HttpClientModule,
          RouterTestingModule,
          ReactiveFormsModule,
          FormsModule,
        ],
        providers: [ParqueaderoService, HttpService, ModalNotificaciones],
      }).compileComponents();
    })
  );

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearParqueaderoComponent);
    component = fixture.componentInstance;
    parqueaderoService = TestBed.inject(ParqueaderoService);
    spyOn(parqueaderoService, 'crear').and.returnValue(of({ valor: 18 }));
    fixture.detectChanges();
  });

  it('formulario es invalido cuando esta vacio', () => {
    expect(component.envioForm.valid).toBeFalsy();
  });

  it('Registrando parqueadero', () => {
    expect(component.envioForm.valid).toBeFalsy();
    component.envioForm.controls.idTipoParqueadero.setValue(1);
    expect(component.envioForm.valid).toBeTruthy();
    component.crear();
  });
});