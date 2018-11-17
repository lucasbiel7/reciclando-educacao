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
export class AreaDoUsuario {
    tiles = [
        { text: 'One', cols: 3, rows: 1, color: 'lightblue' },
        { text: 'Two', cols: 1, rows: 2, color: 'lightgreen' },
        { text: 'Three', cols: 1, rows: 1, color: 'lightpink' },
        { text: 'Four', cols: 2, rows: 1, color: '#DDBDF1' },
    ];
}
