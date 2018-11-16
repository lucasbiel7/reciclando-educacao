import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Doacao } from '../../../../shared/resource/class/doacao.class';
import { FormularioDoadorComponent } from '../../../../shared/components/formulario-doador/formulario-doador.component';
import { DoacaoService } from '../../../../core/services/doacao.service';
import { SegurancaService } from '../../../../core/services/seguranca.service';
import { Endereco } from '../../../../shared/resource/class/endereco.class';

@Component({
    selector: 'redu-cadastrar-doacao',
    templateUrl: './cadastrar-doacao.component.html',
    styleUrls: ['./cadastrar-doacao.component.scss']
})
export class CadastrarDoacaoComponent implements OnInit {


    @ViewChild('formularioDoacao')
    public formularioDoador: FormularioDoadorComponent;

    public doacao: Doacao;
    public formulario: FormGroup;

    constructor(private doacaoService: DoacaoService, private segurancaService: SegurancaService) {

    }

    ngOnInit() {
        if (this.doacaoService.doacao) {
            this.doacao = this.doacaoService.doacao;
        } else {
            this.doacao = new Doacao();
            this.doacao.endereco = new Endereco();
        }
        this.formulario = new FormGroup({
        });
    }

    public atualizarEndereco(event) {
        console.log(this.doacao);
    }

    public utilizarMeuEndereco() {
        this.doacao.endereco = this.segurancaService.usuario.endereco;
        this.doacao.endereco.id = null;
    }
}
