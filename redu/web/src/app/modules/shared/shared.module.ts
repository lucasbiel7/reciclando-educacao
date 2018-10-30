import { UsuarioNaoAutenticadoGuard } from './services/usuario-nao-autenticado.guard';
import { MensagemComponent } from './components/mensagem/mensagem.component';
import { NgModule, ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MenuComponent } from './components/menu/menu.component';
import { RodapeComponent } from './components/rodape/rodape.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import {
    MatTabsModule, MatFormFieldModule, MatInputModule, MatSelectModule,
    MatButtonModule, MatCardModule, MatStepperModule, MatExpansionModule, MatIconModule, MatMenuModule, MatTooltipModule
} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EnderecoComponent } from './components/endereco/endereco.component';
import { HttpModule } from '@angular/http';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/observable/timer';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap';
import 'rxjs/add/operator/switchMap';
import { CadastroColaboradorComponent } from './components/cadastro-colaborador/cadastro-colaborador.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CepService } from './services/cep.service';
import { FormularioDoadorComponent } from './components/formulario-doador/formulario-doador.component';
import { HttpClientModule } from '@angular/common/http';
import { CepDirective } from './directive/cep.directive';
import { UsuarioAutenticadoGuard } from './services/usuario-autenticado.guard';

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
        MatIconModule,
        MatTooltipModule,
        // Componentes internos
        EnderecoComponent,
        MenuComponent,
        RodapeComponent,
        CadastroColaboradorComponent,
        FormularioDoadorComponent,
        MensagemComponent,
    ],
    imports: [
        AngularFontAwesomeModule,
        AngularFontAwesomeModule,
        MatTabsModule,
        BrowserAnimationsModule,
        MatTooltipModule,
        MatFormFieldModule,
        MatInputModule,
        MatSelectModule,
        MatButtonModule,
        MatCardModule,
        MatIconModule,
        MatStepperModule,
        MatMenuModule,
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
        CepDirective,
        MensagemComponent
    ]
})
export class SharedModule {
    static forRoot(): ModuleWithProviders {
        return {
            ngModule: SharedModule,
            providers: [
                CepService,
                UsuarioAutenticadoGuard,
                UsuarioNaoAutenticadoGuard
            ]
        };
    }
}
