import { Component, OnInit, ViewChild } from '@angular/core';
import { FormularioDoadorComponent } from '../../../shared/components/formulario-doador/formulario-doador.component';
import { DoacaoService } from '../../../core/services/doacao.service';
import { Doacao } from '../../../shared/resource/class/doacao.class';
import { Router } from '@angular/router';

@Component({
    selector: 'redu-pagina-inicial',
    templateUrl: './pagina-inicial.component.html',
    styleUrls: ['./pagina-inicial.component.scss']
})
export class PaginaInicialComponent implements OnInit {

    @ViewChild('formularioDoador')
    public formularioDoador: FormularioDoadorComponent;
    public doacao: Doacao;

    constructor(private doacaoService: DoacaoService,
        private router: Router) {

    }


    ngOnInit() {
        this.doacao = new Doacao();
    }

    public cadastrarDoacao() {
        if (this.formularioDoador.formulario.valid) {
            this.doacaoService.doacao = this.doacao;
            this.router.navigate(['doacao', 'cadastrar']);
        }
    }

}
