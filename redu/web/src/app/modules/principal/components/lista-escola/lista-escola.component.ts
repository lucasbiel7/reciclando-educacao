import { Component, OnInit } from '@angular/core';
import { Escola } from '../../../shared/resource/class/escola.class';
import { EscolaService } from '../../services/escola.service';
import { PageEvent } from '@angular/material';

@Component({
    selector: 'redu-lista-escola',
    templateUrl: './lista-escola.component.html',
    styleUrls: ['./lista-escola.component.scss']
})
export class ListaEscolaComponent implements OnInit {

    public escolas: Escola[];
    public escolasView: Escola[];
    public termo: string;
    public ultimoEvento: PageEvent;
    public loading: boolean;

    constructor(private escolaService: EscolaService) {
    }

    ngOnInit() {
        this.loading = true;
        this.escolaService.buscarEscolas().subscribe(escolas => {
            this.escolas = escolas;
            this.loading = false;
            this.atualizarEscolas({
                pageSize: 5,
                length: this.escolas.length,
                pageIndex: 0
            });
        });

    }


    public atualizarEscolas($event: PageEvent) {
        const pagina = $event.pageIndex;
        const numerosPorPagina = $event.pageSize;
        this.ultimoEvento = $event;
        if (this.escolas) {
            this.escolasView = this.escolas.
                slice(pagina * numerosPorPagina, pagina * numerosPorPagina + numerosPorPagina);
        }
    }

    public filtro() {
        this.escolasView = [];
        this.loading = true;
        this.escolaService.buscarEscolas(this.termo).subscribe(escolas => {
            this.escolas = escolas;
            this.loading = false;
            this.atualizarEscolas({
                pageSize: this.ultimoEvento ? this.ultimoEvento.pageSize : 5,
                length: this.escolas.length,
                pageIndex: 0
            });
        });
    }
}



