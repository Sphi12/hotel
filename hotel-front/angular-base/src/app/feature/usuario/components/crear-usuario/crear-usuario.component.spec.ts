import { CrearUsuarioComponent } from './crear-usuario.component';
import { waitForAsync, ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';

import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpService } from 'src/app/core/services/http.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { UsuarioService } from '../../shared/service/usuario.service';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';

describe('CrearUsuarioComponent', () => {
  let component: CrearUsuarioComponent;
  let fixture: ComponentFixture<CrearUsuarioComponent>;
  let usuarioService: UsuarioService;

  beforeEach(
    waitForAsync(() => {
      TestBed.configureTestingModule({
        declarations: [CrearUsuarioComponent],
        imports: [
          CommonModule,
          HttpClientModule,
          RouterTestingModule,
          ReactiveFormsModule,
          FormsModule,
        ],
        providers: [UsuarioService, HttpService, ModalNotificaciones],
      }).compileComponents();
    })
  );

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearUsuarioComponent);
    component = fixture.componentInstance;
    usuarioService = TestBed.inject(UsuarioService);
    spyOn(usuarioService, 'crear').and.returnValue(of({ valor: 18 }));
    fixture.detectChanges();
  });

  it('formulario es invalido cuando esta vacio', () => {
    expect(component.envioForm.valid).toBeFalsy();
  });

  it('Registrando usuario', () => {
    expect(component.envioForm.valid).toBeFalsy();
    component.envioForm.controls.id.setValue(123456);
    component.envioForm.controls.nombre.setValue('Pepito Perez');
    component.envioForm.controls.clave.setValue('8976');
    component.envioForm.controls.fechaCreacion.setValue('2021-09-07');
    expect(component.envioForm.valid).toBeTruthy();
    component.crear();
  });
});
