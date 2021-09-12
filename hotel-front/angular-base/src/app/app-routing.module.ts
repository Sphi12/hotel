import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SecurityGuard } from '@core/guard/security.guard';
import { HomeComponent } from '@home/home.component';




const routes: Routes = [
  { path: 'home', component: HomeComponent, canActivate: [SecurityGuard]  },
  { path: 'reserva', loadChildren: () => import('./feature/reserva/reserva.module').then(mod => mod.ReservaModule) },
  { path: 'usuario', loadChildren: () => import('./feature/usuario/usuario.module').then(mod => mod.UsuarioModule) },
  { path: 'parqueadero', loadChildren: () => import('./feature/parqueadero/parqueadero.module').then(mod => mod.ParqueaderoModule) },
  { path: 'habitacion', loadChildren: () => import('./feature/habitacion/habitacion.module').then(mod => mod.HabitacionModule) },
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
