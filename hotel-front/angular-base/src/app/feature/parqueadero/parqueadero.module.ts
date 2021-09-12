import { NgModule } from '@angular/core';
import { CrearParqueaderoComponent } from './components/crear-parqueadero/crear-parqueadero.component';
import { SolicitudComponent } from './components/parqueadero/solicitud.component';
import { ParqueaderoRoutingModule } from './parqueadero-routing.module';
import { SharedModule } from '@shared/shared.module';
import { ParqueaderoService } from './shared/service/parqueadero.service';
import { HttpService } from '@core/services/http.service';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';

@NgModule({
  declarations: [
    CrearParqueaderoComponent,
    SolicitudComponent,
  ],
  imports: [ParqueaderoRoutingModule, SharedModule],
  providers: [HttpService, ParqueaderoService, ModalNotificaciones],
})
export class ParqueaderoModule {}
