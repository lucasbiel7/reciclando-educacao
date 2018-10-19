import { DoacaoService } from './services/doacao.service';
import { NgModule, ModuleWithProviders } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { CoreRoutingModule } from './core-routing.module';
import { PaginaNaoEncontradaComponent } from './components/pagina-nao-encontrada/pagina-nao-encontrada.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from '@angular/forms';
import { SegurancaService } from './services/seguranca.service';
import { SegurancaInterceptor } from './services/seguranca.interceptor';
import { HTTP_INTERCEPTORS } from '@angular/common/http';


@NgModule({
    imports: [
        SharedModule.forRoot(),
        CoreRoutingModule,
        FormsModule
    ],
    declarations: [
        PaginaNaoEncontradaComponent,
        LoginComponent
    ]
})
export class CoreModule {
    static forRoot(): ModuleWithProviders {
        return {
            ngModule: CoreModule,
            providers: [
                {
                    provide: HTTP_INTERCEPTORS,
                    useClass: SegurancaInterceptor,
                    multi: true
                },
                DoacaoService,
                SegurancaService
            ]
        };
    }
}
