import { Component, OnInit } from '@angular/core';
import { SegurancaService } from '../../../core/services/seguranca.service';
import { DoacaoService } from '../../../core/services/doacao.service';

@Component({
    selector: 'redu-area-do-usuario',
    templateUrl: './area-do-usuario.component.html',
    styleUrls: ['./area-do-usuario.component.scss']
})
export class AreaDoUsuarioComponent implements OnInit {

    public quantidadeDoacoes: number;
    public restante: string;

    constructor(public segurancaService: SegurancaService,
        private doacaoService: DoacaoService) { }

    ngOnInit() {
        this.doacaoService.buscarPorColaborador(this.segurancaService.usuario.id).subscribe(doacoes => {
            this.quantidadeDoacoes = doacoes.length;
        });
        setInterval(() => {
            this.restante = this.segurancaService.tempoRestante;
        }, 1000);
    }

}

