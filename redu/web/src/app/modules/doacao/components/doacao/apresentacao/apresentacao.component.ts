import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'redu-apresentacao',
    templateUrl: './apresentacao.component.html',
    styleUrls: ['./apresentacao.component.scss']
})
export class ApresentacaoComponent implements OnInit {

    constructor(private router: Router) { }

    ngOnInit() {
    }

    onFazerDoacao() {
        this.router.navigate(['doacao', 'cadastrar']);
    }

    onVisualizarDacoes() {
        this.router.navigate(['doacao', 'visualizar']);
    }

}
