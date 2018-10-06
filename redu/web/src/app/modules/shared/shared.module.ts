import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MenuComponent } from './components/menu/menu.component';
import { RodapeComponent } from './components/rodape/rodape.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { MatTabsModule, MatFormFieldModule, MatInputModule, MatSelectModule, MatButtonModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EnderecoComponent } from './components/endereco/endereco.component';
import { HttpModule } from '@angular/http';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap';
import 'rxjs/add/operator/switchMap';
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
        EnderecoComponent,
        MatSelectModule,
        MatButtonModule,
        // Componentes internos
        MenuComponent,
        RodapeComponent,
    ],
    imports: [
        AngularFontAwesomeModule,
        AngularFontAwesomeModule,
        MatTabsModule,
        BrowserAnimationsModule,
        MatFormFieldModule,
        MatInputModule
    ],
    declarations: [
        MenuComponent,
        RodapeComponent,
        EnderecoComponent
    ]
})
export class SharedModule { }
