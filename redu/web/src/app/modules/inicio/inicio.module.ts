import { NgModule } from '@angular/core';

import { InicioRoutingModule } from './inicio-routing.module';
import { SharedModule } from '../shared/shared.module';
import { PaginaInicialComponent } from './components/pagina-inicial/pagina-inicial.component';
import { FormularioDoadorComponent } from './components/formulario-doador/formulario-doador.component';
import { FormularioColaboradorComponent } from './components/formulario-colaborador/formulario-colaborador.component';

@NgModule({
    imports: [
        SharedModule,
        InicioRoutingModule,
    ],
    declarations: [
        PaginaInicialComponent,
        FormularioDoadorComponent,
        FormularioColaboradorComponent
    ]
})
export class InicioModule {

}
