import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DoacaoRoutingModule } from './doacao-routing.module';
import { CadastrarDoacaoComponent } from './components/doacao/cadastrar-doacao/cadastrar-doacao.component';
import { DoacaoComponent } from './components/doacao/doacao.component';
import { SharedModule } from '../shared/shared.module';
import { DoacaoGuard } from './services/doacao.guard';

@NgModule({
    imports: [
        SharedModule,
        DoacaoRoutingModule
    ],
    declarations: [
        CadastrarDoacaoComponent,
        DoacaoComponent
    ],
    providers: [
        // Guard do modulo de doação
        DoacaoGuard
    ]
})
export class DoacaoModule { }
