import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PrincipalRoutingModule } from './principal-routing.module';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { AreaDoUsuarioComponent } from './components/area-do-usuario/area-do-usuario.component';
import { SharedModule } from '../shared/shared.module';
import { OpniaoComponent } from './components/opniao/opniao.component';
import { PerguntasFrequentesComponent } from './components/perguntas-frequentes/perguntas-frequentes.component';
import { AjudaComponent } from './components/ajuda/ajuda.component';

@NgModule({
    imports: [
        SharedModule,
        PrincipalRoutingModule
    ],
    declarations: [
        DashboardComponent, AreaDoUsuarioComponent, OpniaoComponent, PerguntasFrequentesComponent, AjudaComponent
    ]
})
export class PrincipalModule { }
