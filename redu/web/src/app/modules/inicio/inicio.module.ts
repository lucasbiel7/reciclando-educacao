import { NgModule } from '@angular/core';

import { InicioRoutingModule } from './inicio-routing.module';
import { SharedModule } from '../shared/shared.module';
import { PaginaInicialComponent } from './pagina-inicial/pagina-inicial.component';

@NgModule({
  imports: [
    SharedModule,
    InicioRoutingModule,
  ],
  declarations: [
    PaginaInicialComponent
  ]
})
export class InicioModule {

}
