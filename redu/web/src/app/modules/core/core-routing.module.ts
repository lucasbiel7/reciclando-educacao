import { UsuarioAutenticadoGuard } from './../shared/services/usuario-autenticado.guard';
import { Routes, RouterModule } from '@angular/router';
import { NgModule, Component } from '@angular/core';
import { PaginaNaoEncontradaComponent } from './components/pagina-nao-encontrada/pagina-nao-encontrada.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
    {
        path: 'login',
        component: LoginComponent,
        canActivate: [UsuarioAutenticadoGuard]
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
