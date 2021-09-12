import { Component, OnInit } from '@angular/core';
import { Reserva } from '../../shared/model/reserva';
import { ReservaService } from '../../shared/service/reserva.service';
import { Observable } from 'rxjs';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';

@Component({
  selector: 'app-listar-reserva',
  templateUrl: './listar-reserva.component.html',
  styleUrls: ['./listar-reserva.component.scss'],
})
export class ListarReservaComponent implements OnInit {
  public listaReserva: Observable<Reserva[]>;

  constructor(
    private reservaService: ReservaService,
    private modalNotificaciones: ModalNotificaciones
  ) {}

  ngOnInit() {
    this.listaReserva = this.reservaService.listar();
  }

  cancelarSolicitud(reserva: Reserva) {
    this.modalNotificaciones
      .modalConConfirmacion(
        `Estas seguro de cancelar la solicitud # ${reserva.id}`,
        'warning',
        true,
        '#3085d6',
        '#d33',
        'Si, crealo',
        'no, Cancelar!!'
      )
      .then((respuestaConfirmacion) => {
        if (respuestaConfirmacion) {
          this.reservaService.eliminar(reserva).subscribe(
            (response) => {
              if (response.valor) {
                this.modalNotificaciones.modalBasico(
                  `Se cancelo correctamente ${reserva.id}`,
                  'success'
                );

              
              }
            },
            (e) => {
              this.modalNotificaciones.modalBasico(
                `No se puedo cancelar la notificacion ${
                  e.error ? e.error.mensaje : e.statusText
                }`,
                'warning'
              );
            }
          );
        }
      });
  }

  hacerCheckIn(reserva: Reserva){

    this.modalNotificaciones
      .modalConConfirmacion(
        `Estas seguro de hacer chek-in # ${reserva.id}`,
        'warning',
        true,
        '#3085d6',
        '#d33',
        'Si',
        'No!!'
      )
      .then((respuestaConfirmacion) => {
        if (respuestaConfirmacion) {

          console.log(reserva.id + ' ' + reserva.checkIn)
         this.reservaService.reservaActiva = reserva;
         this.reservaService.reservaActiva.checkIn='true';
         console.log('2' +reserva.id + ' ' + reserva.checkIn)
          this.reservaService.editar(reserva).subscribe(
            (response) => {
              if (response.valor) {
                this.modalNotificaciones.modalBasico(
                  `Check-in correcto`,
                  'success'
                );
                
              }
            },
            (e) => {
              this.modalNotificaciones.modalBasico(
                `No se pudo hacer Check-in ${
                  e.error ? e.error.mensaje : e.statusText
                }`,
                'warning'
              );
            }
          );
        }
      });
    }

    hacerCheckOut(reserva: Reserva){

    this.modalNotificaciones
      .modalConConfirmacion(
        `Estas seguro de hacer Chek-out # ${reserva.id}`,
        'warning',
        true,
        '#3085d6',
        '#d33',
        'Si',
        'No'
      )
      .then((respuestaConfirmacion) => {
        if (respuestaConfirmacion) {
         this.reservaService.reservaActiva = reserva;
         this.reservaService.reservaActiva.checkOut='true';
          this.reservaService.editar(reserva).subscribe(
            (response) => {
              if (response.valor) {
                this.modalNotificaciones.modalBasico(
                  `Check-out correcto`,
                  'success'
                );
                
              }
            },
            (e) => {
              this.modalNotificaciones.modalBasico(
                `No se pudo hacer Check-out ${
                  e.error ? e.error.mensaje : e.statusText
                }`,
                'warning'
              );
            }
          );
        }
      });
    }
}
