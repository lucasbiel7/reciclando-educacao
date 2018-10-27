
import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { PaginaNaoEncontradaComponent } from './components/pagina-nao-encontrada/pagina-nao-encontrada.component';
import { LoginComponent } from './components/login/login.component';
import { UsuarioNaoAutenticadoGuard } from '../shared/services/usuario-nao-autenticado.guard';

const routes: Routes = [
    {
        path: 'login',
        component: LoginComponent,
        canActivate: [UsuarioNaoAutenticadoGuard]
    },
    {
        path: 'pagina-nao-encontrada',
        component: PaginaNaoEncontradaComponent
    },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class CoreRoutingModule {
}
