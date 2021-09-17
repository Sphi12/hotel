import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ParqueaderoService } from '../../shared/service/parqueadero.service';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';
import { tiposDeParqueadero } from 'src/assets/json/tipos_parqueadero';

@Component({
  selector: 'app-crear-parqueadero',
  templateUrl: './crear-parqueadero.component.html',
})
export class CrearParqueaderoComponent implements OnInit {
  envioForm: FormGroup;
  id: string;
  error: string;
  tiposParqueaderoList: any[];

  constructor(
    private reservaServices: ParqueaderoService,
    private modalNotificaciones: ModalNotificaciones
  ) {
    this.tiposParqueaderoList = tiposDeParqueadero;
  }

  ngOnInit(): void {
    this.construirFormularioEnvio();
  }

  crear() {

    console.log(this.envioForm);
    this.reservaServices.crear(this.envioForm.value).subscribe(
      (response) => {
        this.id = response.valor;
        if (response.valor) {
          this.modalNotificaciones.modalBasico(
            `Se creo el parqueadero  # ${response.valor}`,
             'success'
             );
             this.envioForm.reset();
            }
          },
          (e) => {
            console.log(e.error.mensaje);
            this.modalNotificaciones.modalBasico(
              `No se puedo crear el parqueadero ${e.error.mensaje}`,
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
    idTipoParqueadero: new FormControl('', [Validators.required]),
    });
  }
}
