import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HabitacionService } from '../../shared/service/habitacion.service';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';

@Component({
  selector: 'app-crear-habitacion',
  templateUrl: './crear-habitacion.component.html',
})
export class CrearHabitacionComponent implements OnInit {
  envioForm: FormGroup;
  id: string;
  error: string;
  tiposHabitacionList: any[];

  constructor(
    private habitacionServices: HabitacionService,
    private modalNotificaciones: ModalNotificaciones
  ) {
  }

  ngOnInit(): void {
    this.construirFormularioEnvio();
  }

  crear() {

          this.habitacionServices.crear(this.envioForm.value).subscribe(
            (response) => {
              this.id = response.valor;
              if (response.valor) {
                this.modalNotificaciones.modalBasico(
                  `Se creo la habitacion  # ${response.valor}`,
                  'success'
                );
                this.envioForm.reset();

              }
            },
            (e) => {
              console.log(e.error.mensaje);
              this.modalNotificaciones.modalBasico(
                `No se pudo crear la habitacion ${e.error.mensaje}`,
                'warning'
              );
            }
          );
  }

  limpiar() {
    this.envioForm.reset();
  }

  private construirFormularioEnvio() {
    this.envioForm = new FormGroup({
      tipo: new FormControl('', [Validators.required]),
    });
  }
}
