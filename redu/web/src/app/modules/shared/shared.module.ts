import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { RodapeComponent } from './rodape/rodape.component';


@NgModule({
  exports: [
    CommonModule,
    RouterModule,

  ],
  declarations: [MenuComponent, RodapeComponent]
})
export class SharedModule { }
