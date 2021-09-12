import { NgModule } from '@angular/core';
import { CrearHabitacionComponent } from './components/crear-habitacion/crear-habitacion.component';
import { HabitacionComponent } from './components/habitacion/habitacion.component';
import { HabitacionRoutingModule } from './habitacion-routing.module';
import { SharedModule } from '@shared/shared.module';
import { HabitacionService } from './shared/service/habitacion.service';
import { HttpService } from '@core/services/http.service';
import { ModalNotificaciones } from '@core/services/modal-notificaciones.service';
import { ListarHabitacionComponent } from './components/listar-habitacion/listar-habitacion.component';

@NgModule({
  declarations: [
    CrearHabitacionComponent,
    HabitacionComponent,
    ListarHabitacionComponent,
  ],
  imports: [HabitacionRoutingModule, SharedModule],
  providers: [HttpService, HabitacionService, ModalNotificaciones],
})
export class HabitacionModule {}
