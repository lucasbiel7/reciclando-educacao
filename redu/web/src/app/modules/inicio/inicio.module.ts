import { NgModule } from '@angular/core';

import { InicioRoutingModule } from './inicio-routing.module';
import { SharedModule } from '../shared/shared.module';
import { PaginaInicialComponent } from './components/pagina-inicial/pagina-inicial.component';
import { FormularioColaboradorComponent } from './components/formulario-colaborador/formulario-colaborador.component';
import { FormularioDoadorService } from '../shared/services/formulario-doador.service';
import { SobreComponent } from './components/sobre/sobre.component';

@NgModule({
    imports: [
        SharedModule,
        InicioRoutingModule,
    ],
    declarations: [
        PaginaInicialComponent,
        FormularioColaboradorComponent,
        SobreComponent
    ],
    providers: [
        FormularioDoadorService
    ]
})
export class InicioModule {

}
