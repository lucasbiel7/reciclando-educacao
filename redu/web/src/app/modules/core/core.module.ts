import { DoacaoService } from './services/doacao.service';
import { NgModule, ModuleWithProviders } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { CoreRoutingModule } from './core-routing.module';
import { PaginaNaoEncontradaComponent } from './components/pagina-nao-encontrada/pagina-nao-encontrada.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from '@angular/forms';

@NgModule({
    imports: [
        SharedModule,
        CoreRoutingModule,
        FormsModule
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
