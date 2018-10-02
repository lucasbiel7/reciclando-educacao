import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { PaginaNaoEncontradaComponent } from './components/pagina-nao-encontrada/pagina-nao-encontrada.component';

const routes: Routes = [
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
