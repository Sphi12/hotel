import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import { CrearParqueaderoComponent } from './components/crear-parqueadero/crear-parqueadero.component';
import { SolicitudComponent } from './components/parqueadero/solicitud.component';


const routes: Routes = [
  {
    path: '',
    component: SolicitudComponent,
    children: [
      {
        path: 'crear',
        component: CrearParqueaderoComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ParqueaderoRoutingModule { }
