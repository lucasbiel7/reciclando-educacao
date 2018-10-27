import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AreaDoUsuarioComponent } from './components/area-do-usuario/area-do-usuario.component';
import { UsuarioAutenticadoGuard } from '../shared/services/usuario-autenticado.guard';

const routes: Routes = [
    {
        path: 'dashboard',
        component: DashboardComponent,
        loadChildren: '',
        canActivate: [UsuarioAutenticadoGuard],
        canActivateChild: [UsuarioAutenticadoGuard],
        children: [
            {
                path: '',
                component: AreaDoUsuarioComponent
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class PrincipalRoutingModule { }
