import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CadastrarDoacaoComponent } from './components/doacao/cadastrar-doacao/cadastrar-doacao.component';
import { DoacaoComponent } from './components/doacao/doacao.component';
import { UsuarioAutenticadoGuard } from '../shared/services/usuario-autenticado.guard';
import { ApresentacaoComponent } from './components/doacao/apresentacao/apresentacao.component';

const routes: Routes = [
    {
        path: 'doacao',
        component: DoacaoComponent,
        canActivate: [UsuarioAutenticadoGuard],
        canActivateChild: [UsuarioAutenticadoGuard],
        children: [
            {
                path: '',
                component: ApresentacaoComponent
            },
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
