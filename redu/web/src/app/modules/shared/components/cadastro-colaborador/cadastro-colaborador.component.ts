import { Component, OnInit, ViewChild } from '@angular/core';
import { MatStepper } from '@angular/material';
import { ColaboradorService } from '../../services/colaborador.service';
import { TipoColaborador } from '../../resource/class/tipo-colaborador.class';
import { TipoPessoaEnum } from '../../resource/enum/tipo-pessoa.enum';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Colaborador } from '../../resource/class/colaborador.class';
import { PessoaJuridica } from '../../resource/class/pessoa-juridica.class';
import { PessoaFisica } from '../../resource/class/pessoa-fisica.class';

@Component({
    selector: 'redu-cadastro-colaborador',
    templateUrl: './cadastro-colaborador.component.html',
    styleUrls: ['./cadastro-colaborador.component.scss']
})

export class CadastroColaboradorComponent implements OnInit {

    @ViewChild('stepper')
    public stepper: MatStepper;
    currentStep: any;
    public tiposDeColaborador: TipoColaborador[];
    public tipoPessoa: TipoPessoaEnum;
    public tiposPessoas: TipoPessoaEnum[];

    public colaborador: Colaborador | PessoaFisica | PessoaJuridica;


    /**
     *  Formularios
     */
    public comoColaborar: FormGroup;
    public formularioDadosPessoais: FormGroup;

    constructor(private colaboradorService: ColaboradorService) {
        this.colaborador = new Colaborador();
        this.comoColaborar = new FormGroup({
            tipoColaborador: new FormControl('', [Validators.required]),
            tipoPessoa: new FormControl('', Validators.required)
        });
        this.formularioDadosPessoais = new FormGroup({
            nome: new FormControl('', [Validators.required]),
            email: new FormControl('', [Validators.required, Validators.email])
        });
    }

    ngOnInit() {
        this.currentStep = 0;
        this.tiposPessoas = TipoPessoaEnum.values();
        console.log(this.tiposPessoas);
        this.colaboradorService.pegarTiposColaboradores().subscribe(tiposColaborador => {
            this.tiposDeColaborador = tiposColaborador;
        });

    }

    isPessoaFisica() {
        return this.colaborador instanceof PessoaFisica;
    }

    isPessoaJuridica() {
        return this.colaborador instanceof PessoaFisica;
    }

    /**
     *
     */
    nomeColaborador() {
        return this.colaborador instanceof PessoaFisica ? 'Nome' : 'Nome Fantasia';
    }
    /**
     * Eventos
     */
    onTipoPessoaChange() {
        if (this.tipoPessoa === TipoPessoaEnum.FISICA) {
            this.colaborador = new PessoaFisica();
            this.formularioDadosPessoais.addControl('cpf', new FormControl('', Validators.required));
        } else {
            this.colaborador = new PessoaJuridica();
            this.formularioDadosPessoais.addControl('cnpj', new FormControl('', Validators.required));
        }

    }

}
