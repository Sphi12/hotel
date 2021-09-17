import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UsuarioService } from '../../shared/service/usuario.service';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';

@Component({
  selector: 'app-crear-usuario',
  templateUrl: './crear-usuario.component.html',
})
export class CrearUsuarioComponent implements OnInit {
  envioForm: FormGroup;
  id: string;
  error: string;

  constructor(
    private reservaServices: UsuarioService,
    private modalNotificaciones: ModalNotificaciones
  ) {
  }

  ngOnInit(): void {
    this.construirFormularioEnvio();
  }

  crear() {

          this.reservaServices.crear(this.envioForm.value).subscribe(
            (response) => {
              this.id = response.valor;
              if (response.valor) {
                this.modalNotificaciones.modalBasico(
                  `Se creo el usuario  # ${response.valor}`,
                  'success'
                );
                this.envioForm.reset();

              }
            },
            (e) => {
              console.log(e.error.mensaje);
              this.modalNotificaciones.modalBasico(
                `No se puedo crear el usuario ${e.error.mensaje}`,
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
      id: new FormControl('', [Validators.required]),
      nombre: new FormControl('', [Validators.required]),
      clave: new FormControl('', [Validators.required]),
      fechaCreacion: new FormControl('', [Validators.required]),
    });
  }
}
