import { Component, OnInit } from '@angular/core';
import { SegurancaService } from '../../../core/services/seguranca.service';

@Component({
    selector: 'redu-area-do-usuario',
    templateUrl: './area-do-usuario.component.html',
    styleUrls: ['./area-do-usuario.component.scss']
})
export class AreaDoUsuarioComponent implements OnInit {

    constructor(public segurancaService: SegurancaService) { }

    ngOnInit() {

    }

}
