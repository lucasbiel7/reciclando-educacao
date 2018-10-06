import { DoacaoService } from './services/doacao.service';
import { NgModule, ModuleWithProviders } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { CoreRoutingModule } from './core-routing.module';
import { PaginaNaoEncontradaComponent } from './components/pagina-nao-encontrada/pagina-nao-encontrada.component';
import { LoginComponent } from './components/login/login.component';

@NgModule({
    imports: [
        SharedModule,
        CoreRoutingModule
    ],
    declarations: [PaginaNaoEncontradaComponent, LoginComponent]
})
export class CoreModule {
    static forRoot(): ModuleWithProviders {
        return {
            ngModule: CoreModule,
            providers: [
                DoacaoService
            ]
        };
    }
}
