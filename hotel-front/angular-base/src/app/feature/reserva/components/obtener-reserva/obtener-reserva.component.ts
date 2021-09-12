import { Component, OnInit } from '@angular/core';
import { Reserva } from '../../shared/model/reserva';
import { ReservaService } from '../../shared/service/reserva.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-obtener-reserva',
  templateUrl: './obtener-reserva.component.html'
})
export class ObtenerReservaComponent implements OnInit {
 
  public reserva: Observable<Reserva>;
  envioForm: FormGroup;


  constructor(
    private reservaService: ReservaService,
    private router: Router,
    private modalNotificaciones: ModalNotificaciones
  ) {}

  ngOnInit() {
    console.log(this.envioForm.value)
    this.reserva = this.reservaService.obtener(this.envioForm.value);
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

                setTimeout(() => {
                  this.irAListarSolicitudes();
                }, 1000);
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

  irAListarSolicitudes() {
    this.router.navigate(['solicitud']);
  }

  navegarAEditar(reserva: Reserva) {
    this.reservaService.reservaActiva = reserva;
    this.router.navigateByUrl('/solicitud/editar');
  }
}
