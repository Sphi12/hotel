import { NgModule } from '@angular/core';
import { CrearReservaComponent } from './components/crear-reserva/crear-reserva.component';
import { ListarReservaComponent } from './components/listar-reserva/listar-reserva.component';
import { ReservaComponent } from './components/reserva/reserva.component';
import { ReservaRoutingModule } from './reserva-routing.module';
import { SharedModule } from '@shared/shared.module';
import { ReservaService } from './shared/service/reserva.service';
import { HttpService } from '@core/services/http.service';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';

@NgModule({
  declarations: [
    CrearReservaComponent,
    ListarReservaComponent,
    ReservaComponent,
  ],
  imports: [ReservaRoutingModule, SharedModule],
  providers: [HttpService, ReservaService, ModalNotificaciones],
})
export class ReservaModule {}
