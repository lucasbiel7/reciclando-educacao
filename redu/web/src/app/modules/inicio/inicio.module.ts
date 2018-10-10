import { NgModule } from '@angular/core';

import { InicioRoutingModule } from './inicio-routing.module';
import { SharedModule } from '../shared/shared.module';
import { PaginaInicialComponent } from './components/pagina-inicial/pagina-inicial.component';
import { FormularioDoadorComponent } from './components/formulario-doador/formulario-doador.component';
import { FormularioColaboradorComponent } from './components/formulario-colaborador/formulario-colaborador.component';
import { FormularioDoadorService } from './services/formulario-doador.service';
import { SobreComponent } from './components/sobre/sobre.component';

@NgModule({
    imports: [
        SharedModule,
        InicioRoutingModule,
    ],
    declarations: [
        PaginaInicialComponent,
        FormularioDoadorComponent,
        FormularioColaboradorComponent,
        SobreComponent
    ],
    providers: [
        FormularioDoadorService
    ]
})
export class InicioModule {

}
