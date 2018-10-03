import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MenuComponent } from './components/menu/menu.component';
import { RodapeComponent } from './components/rodape/rodape.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { MatTabsModule, MatFormFieldModule, MatInputModule, MatSelectModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EnderecoComponent } from './components/endereco/endereco.component';

@NgModule({
    exports: [
        CommonModule,
        RouterModule,
        MenuComponent,
        RodapeComponent,
        AngularFontAwesomeModule,
        MatTabsModule,
        BrowserAnimationsModule,
        MatFormFieldModule,
        MatInputModule,
        EnderecoComponent,
        MatSelectModule
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
