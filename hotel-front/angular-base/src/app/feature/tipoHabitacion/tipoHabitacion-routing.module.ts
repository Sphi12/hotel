import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import { ListarTipoHabitacionComponent } from './components/listar-tipoHabitacion/listar-tipoHabitacion.component';


const routes: Routes = [
  {
    path: '',
    component: ListarTipoHabitacionComponent,
    children: [
      {
        path: 'listar',
        component: ListarTipoHabitacionComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TipoHabitacionRoutingModule { }
