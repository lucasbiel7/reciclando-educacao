import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MenuComponent } from './components/menu/menu.component';
import { RodapeComponent } from './components/rodape/rodape.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import {
    MatTabsModule, MatFormFieldModule, MatInputModule, MatSelectModule,
    MatButtonModule, MatCardModule, MatStepperModule
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
@NgModule({
    exports: [
        // Modulos básicos
        CommonModule,
        RouterModule,
        HttpModule,
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
        // Componentes internos
        EnderecoComponent,
        MenuComponent,
        RodapeComponent,
        CadastroColaboradorComponent,
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
        MatStepperModule
    ],
    declarations: [
        MenuComponent,
        RodapeComponent,
        EnderecoComponent,
        CadastroColaboradorComponent
    ]
})
export class SharedModule { }
