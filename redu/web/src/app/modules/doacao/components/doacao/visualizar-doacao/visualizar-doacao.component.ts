import { Component, OnInit } from '@angular/core';
import { Doacao } from '../../../../shared/resource/class/doacao.class';
import { DoacaoService } from '../../../../core/services/doacao.service';
import { SegurancaService } from '../../../../core/services/seguranca.service';
import { PageEvent } from '@angular/material';
import { EstadoDoacaoEnum } from '../../../../shared/resource/enum/estado-doacao.enum';

@Component({
    selector: 'redu-visualizar-doacao',
    templateUrl: './visualizar-doacao.component.html',
    styleUrls: ['./visualizar-doacao.component.scss']
})
export class VisualizarDoacaoComponent implements OnInit {

    public doacoes: Doacao[];
    public doacoesView: Doacao[];
    public colunas: string[];
    EstadoDoacaoEnum = EstadoDoacaoEnum;

    constructor(private doacaoService: DoacaoService,
        public segurancaService: SegurancaService) {
        this.colunas = ['id', 'tipo', 'estado', 'revisado', 'coletado'];
    }

    ngOnInit() {
        this.doacaoService.buscarPorColaborador(this.segurancaService.usuario.id).subscribe(doacoes => {
            this.doacoes = doacoes;
            this.atualizarDoacoes({
                pageIndex: 0,
                pageSize: 5,
                length: this.doacoes.length
            });
        });
    }

    atualizarDoacoes(event: PageEvent) {
        if (this.doacoes) {
            this.doacoesView = this.doacoes
                .slice(event.pageIndex * event.pageSize, event.pageIndex * event.pageSize + event.pageSize);
        }
    }

}
