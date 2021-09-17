import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ReservaService } from '../../shared/service/reserva.service';
import { tiposDeHabitacion } from '../../../../../assets/json/tipos_habitacion';
import { Router } from '@angular/router';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';
import { tiposDeParqueadero } from 'src/assets/json/tipos_parqueadero';

@Component({
  selector: 'app-crear-reserva',
  templateUrl: './crear-reserva.component.html',
})
export class CrearReservaComponent implements OnInit {
  envioForm: FormGroup;
  descripcion: string;
  tipoDeSolicitud: string;
  idCliente: number;
  clienteCelularContacto: number;
  id: string;
  error: string;
  tiposHabitacionList: any[];
  tiposParqueaderoList: any[];

  constructor(
    private reservaServices: ReservaService,
    private router: Router,
    private modalNotificaciones: ModalNotificaciones
  ) {
    this.tiposHabitacionList = tiposDeHabitacion;
    this.tiposParqueaderoList = tiposDeParqueadero;
  }

  ngOnInit(): void {
    this.construirFormularioEnvio();
  }

  crear() {
    this.modalNotificaciones
      .modalConConfirmacion(
        'Estas seguro de crear la reserva',
        'warning',
        true,
        '#3085d6',
        '#d33',
        'Si',
        'No'
      )
      .then((respuestaConfirmacion) => {
        if (respuestaConfirmacion) {
          this.reservaServices.crear(this.envioForm.value).subscribe(
            (response) => {
              this.id = response.valor;
              if (response.valor) {
                this.modalNotificaciones.modalBasico(
                  `Se creo la reserva  # ${response.valor}`,
                  'success'
                );
                this.envioForm.reset();

                setTimeout(() => {
                  this.irAListarReservas();
                }, 1000);
              }
            },
            (e) => {
              console.log(e.error.mensaje);
              this.modalNotificaciones.modalBasico(
                `No se puedo crear la reserva ${e.error.mensaje}`,
                'warning'
              );
            }
          );
        }
      });
  }

  limpiar() {
    this.envioForm.reset();
  }

  irAListarReservas() {
    this.router.navigate(['reserva/listar']);
  }

  private construirFormularioEnvio() {
    this.envioForm = new FormGroup({
      tipoHabitacion: new FormControl('', [Validators.required]),
      tipoParqueadero: new FormControl('', [Validators.required]),
      idUsuario: new FormControl('', [Validators.required]),
      fechaIngreso: new FormControl('', [Validators.required]),
      fechaSalida: new FormControl('', [Validators.required]),
    });
  }
}
