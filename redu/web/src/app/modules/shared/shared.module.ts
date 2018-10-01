import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { RodapeComponent } from './rodape/rodape.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';


@NgModule({
    exports: [
        CommonModule,
        RouterModule,
        MenuComponent,
        RodapeComponent,
        AngularFontAwesomeModule,
    ],
    imports: [
        AngularFontAwesomeModule
    ],
    declarations: [
        MenuComponent,
        RodapeComponent
    ]
})
export class SharedModule { }
