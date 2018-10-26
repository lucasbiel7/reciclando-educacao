import { NgModule } from '@angular/core';

import { DoacaoRoutingModule } from './doacao-routing.module';
import { CadastrarDoacaoComponent } from './components/doacao/cadastrar-doacao/cadastrar-doacao.component';
import { DoacaoComponent } from './components/doacao/doacao.component';
import { SharedModule } from '../shared/shared.module';

@NgModule({
    imports: [
        SharedModule,
        DoacaoRoutingModule
    ],
    declarations: [
        CadastrarDoacaoComponent,
        DoacaoComponent
    ],
    providers: []
})
export class DoacaoModule { }
