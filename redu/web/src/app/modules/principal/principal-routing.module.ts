import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AreaDoUsuarioComponent } from './components/area-do-usuario/area-do-usuario.component';
import { UsuarioAutenticadoGuard } from '../shared/services/usuario-autenticado.guard';
import { OpniaoComponent } from './components/opniao/opniao.component';
import { PerguntasFrequentesComponent } from './components/perguntas-frequentes/perguntas-frequentes.component';
import { AjudaComponent } from './components/ajuda/ajuda.component';
import { ListaEscolaComponent } from './components/lista-escola/lista-escola.component';
import { ConfiguracaoComponent } from './components/configuracao/configuracao.component';

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
            },
            {
                path: 'perguntas-frequentes',
                component: PerguntasFrequentesComponent
            },
            {
                path: 'ajuda',
                component: AjudaComponent
            },
            {
                path: 'lista-escola',
                component: ListaEscolaComponent
            },
            {
                path: 'configuracao',
                component: ConfiguracaoComponent
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class PrincipalRoutingModule { }
