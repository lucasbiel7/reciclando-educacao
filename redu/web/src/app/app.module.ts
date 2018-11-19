import { PrincipalModule } from './modules/principal/principal.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';


import { AppComponent } from './app.component';
import { CoreModule } from './modules/core/core.module';
import { SharedModule } from './modules/shared/shared.module';
import { AppRoutingModule } from './app-routing.module';
import { InicioModule } from './modules/inicio/inicio.module';
import { DoacaoModule } from './modules/doacao/doacao.module';


@NgModule({
    declarations: [
        AppComponent,
    ],
    imports: [
        SharedModule,
        BrowserModule,
        CoreModule.forRoot(),
        // Modulos da aplicacao
        InicioModule,
        PrincipalModule,
        DoacaoModule,
        // Ultimo import deve ser o routing
        AppRoutingModule
    ],
    providers: [
        { provide: LOCALE_ID, useValue: 'pt-BR' }
    ],
    bootstrap: [AppComponent]
})
export class AppModule {

}
