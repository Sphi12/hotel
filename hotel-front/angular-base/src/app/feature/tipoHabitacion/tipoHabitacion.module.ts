import { NgModule } from '@angular/core';
import { ListarTipoHabitacionComponent } from './components/listar-tipoHabitacion/listar-tipoHabitacion.component';
import { TipoHabitacionRoutingModule } from './tipoHabitacion-routing.module';
import { SharedModule } from '@shared/shared.module';
import { TipoHabitacionService } from './shared/service/tipoHabitacion.service';
import { HttpService } from '@core/services/http.service';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';

@NgModule({
  declarations: [
    ListarTipoHabitacionComponent
  ],
  imports: [TipoHabitacionRoutingModule, SharedModule],
  providers: [HttpService, TipoHabitacionService, ModalNotificaciones],
})
export class TipoHabitacionModule {}
