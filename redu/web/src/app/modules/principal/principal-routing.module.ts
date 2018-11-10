import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AreaDoUsuarioComponent } from './components/area-do-usuario/area-do-usuario.component';
import { UsuarioAutenticadoGuard } from '../shared/services/usuario-autenticado.guard';
import { OpniaoComponent } from './components/opniao/opniao.component';

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
            },
            {
                path: 'opniao',
                component: OpniaoComponent
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class PrincipalRoutingModule { }
