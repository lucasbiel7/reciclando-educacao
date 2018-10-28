import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { FormularioDoadorComponent } from '../../../shared/components/formulario-doador/formulario-doador.component';
import { DoacaoService } from '../../../core/services/doacao.service';
import { Doacao } from '../../../shared/resource/class/doacao.class';
import { Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
import { Validator } from '../../../shared/resource/class/validator.class';

@Component({
    selector: 'redu-pagina-inicial',
    templateUrl: './pagina-inicial.component.html',
    styleUrls: ['./pagina-inicial.component.scss']
})
export class PaginaInicialComponent implements OnInit, AfterViewInit {


    public formulario: FormGroup;

    @ViewChild('formularioDoador')
    public formularioDoador: FormularioDoadorComponent;
    public doacao: Doacao;

    constructor(private doacaoService: DoacaoService,
        private router: Router) {
        this.formulario = new FormGroup({});
    }

    ngOnInit() {
        this.doacao = new Doacao();
    }

    ngAfterViewInit(): void {
        this.formulario.addControl('formularioDoador', this.formularioDoador.formulario);
    }

    public cadastrarDoacao() {
        Validator.validarCampos(this.formulario);
        if (this.formulario.valid) {
            this.doacaoService.doacao = this.doacao;
            this.router.navigate(['doacao', 'cadastrar']);
        }
    }

}
