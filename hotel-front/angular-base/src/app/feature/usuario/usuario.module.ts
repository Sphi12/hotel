import { NgModule } from '@angular/core';
import { CrearUsuarioComponent } from './components/crear-usuario/crear-usuario.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { ReservaRoutingModule } from './usuario-routing.module';
import { SharedModule } from '@shared/shared.module';
import { UsuarioService } from './shared/service/usuario.service';
import { HttpService } from '@core/services/http.service';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';
import { ListarUsuarioComponent } from './components/listar-usuario/listar-usuario.component';

@NgModule({
  declarations: [
    CrearUsuarioComponent,
    ListarUsuarioComponent,
    UsuarioComponent,
  ],
  imports: [ReservaRoutingModule, SharedModule],
  providers: [HttpService, UsuarioService, ModalNotificaciones],
})
export class UsuarioModule {}
