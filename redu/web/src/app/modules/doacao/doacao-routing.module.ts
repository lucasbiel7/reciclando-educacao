import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CadastrarDoacaoComponent } from './components/doacao/cadastrar-doacao/cadastrar-doacao.component';
import { DoacaoComponent } from './components/doacao/doacao.component';
import { DoacaoGuard } from './services/doacao.guard';

const routes: Routes = [
    {
        path: 'doacao',
        component: DoacaoComponent,
        canActivate: [DoacaoGuard],
        children: [
            {
                path: 'cadastrar',
                component: CadastrarDoacaoComponent
            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class DoacaoRoutingModule { }
