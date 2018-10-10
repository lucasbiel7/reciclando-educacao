import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PaginaInicialComponent } from './components/pagina-inicial/pagina-inicial.component';
import { SobreComponent } from './components/sobre/sobre.component';

const routes: Routes = [

    {
        path: 'inicio',
        component: PaginaInicialComponent,
    },
    {
        path: 'sobre',
        component: SobreComponent

    }

];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class InicioRoutingModule { }
