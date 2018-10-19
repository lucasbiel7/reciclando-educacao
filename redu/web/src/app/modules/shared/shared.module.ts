import { NgModule, ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MenuComponent } from './components/menu/menu.component';
import { RodapeComponent } from './components/rodape/rodape.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import {
    MatTabsModule, MatFormFieldModule, MatInputModule, MatSelectModule,
    MatButtonModule, MatCardModule, MatStepperModule, MatExpansionModule
} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EnderecoComponent } from './components/endereco/endereco.component';
import { HttpModule } from '@angular/http';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap';
import 'rxjs/add/operator/switchMap';
import { CadastroColaboradorComponent } from './components/cadastro-colaborador/cadastro-colaborador.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CepDirective } from './directive/cep.directive';
import { CepService } from './services/cep.service';
import { FormularioDoadorComponent } from './components/formulario-doador/formulario-doador.component';
import { HttpClientModule } from '@angular/common/http';
@NgModule({
    exports: [
        // Modulos básicos
        CommonModule,
        RouterModule,
        HttpModule,
        HttpClientModule,
        // Modulos de componentes externos
        AngularFontAwesomeModule,
        MatTabsModule,
        BrowserAnimationsModule,
        MatFormFieldModule,
        MatInputModule,
        MatSelectModule,
        MatButtonModule,
        MatCardModule,
        MatStepperModule,
        FormsModule,
        ReactiveFormsModule,
        MatExpansionModule,
        // Componentes internos
        EnderecoComponent,
        MenuComponent,
        RodapeComponent,
        CadastroColaboradorComponent,
        FormularioDoadorComponent,

    ],
    imports: [
        AngularFontAwesomeModule,
        AngularFontAwesomeModule,
        MatTabsModule,
        BrowserAnimationsModule,
        MatFormFieldModule,
        MatInputModule,
        MatSelectModule,
        MatButtonModule,
        MatCardModule,
        MatStepperModule,
        FormsModule,
        ReactiveFormsModule,
        MatExpansionModule
    ],
    declarations: [
        // Componentes generalizados
        MenuComponent,
        RodapeComponent,
        EnderecoComponent,
        CadastroColaboradorComponent,
        FormularioDoadorComponent,
        // Diretivas
        CepDirective
    ]
})
export class SharedModule {
    static forRoot(): ModuleWithProviders {
        return {
            ngModule: SharedModule,
            providers: [
                CepService
            ]
        };
    }
}
