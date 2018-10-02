import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PaginaInicialComponent } from './components/pagina-inicial/pagina-inicial.component';

const routes: Routes = [

    {
        path: 'inicio',
        component: PaginaInicialComponent,
    },
    {
        path: 'inicio/:component',
        component: PaginaInicialComponent,
    }

];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class InicioRoutingModule { }
