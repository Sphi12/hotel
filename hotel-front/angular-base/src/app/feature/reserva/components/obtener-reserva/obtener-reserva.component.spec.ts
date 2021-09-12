import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ObtenerReservaComponent } from './obtener-reserva.component';

describe('BorrarSolicitudComponent', () => {
  let component: ObtenerReservaComponent;
  let fixture: ComponentFixture<ObtenerReservaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ObtenerReservaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ObtenerReservaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
