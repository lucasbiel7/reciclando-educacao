import { Component, OnInit, ViewChild, AfterViewInit, ChangeDetectorRef } from '@angular/core';
import { MatStepper, MatSnackBar } from '@angular/material';
import { ColaboradorService } from '../../services/colaborador.service';
import { TipoColaborador } from '../../resource/class/tipo-colaborador.class';
import { TipoPessoaEnum } from '../../resource/enum/tipo-pessoa.enum';
import { FormGroup, FormControl, Validators, ValidationErrors } from '@angular/forms';
import { Colaborador } from '../../resource/class/colaborador.class';
import { PessoaJuridica } from '../../resource/class/pessoa-juridica.class';
import { PessoaFisica } from '../../resource/class/pessoa-fisica.class';
import { EnderecoComponent } from '../endereco/endereco.component';
import { Endereco } from '../../resource/class/endereco.class';

@Component({
    selector: 'redu-cadastro-colaborador',
    templateUrl: './cadastro-colaborador.component.html',
    styleUrls: ['./cadastro-colaborador.component.scss']
})

export class CadastroColaboradorComponent implements OnInit, AfterViewInit {


    @ViewChild('stepper')
    public stepper: MatStepper;
    currentStep: any;
    public tiposDeColaborador: TipoColaborador[];
    public tipoPessoa: TipoPessoaEnum;
    public tiposPessoas: TipoPessoaEnum[];
    public enderecoLoad: boolean;
    @ViewChild('enderecoComponente')
    public enderecoComponente: EnderecoComponent;

    public colaborador: Colaborador;

    get pessoaJuridica(): PessoaJuridica {
        return this.colaborador as PessoaJuridica;
    }

    get pessoaFisica(): PessoaFisica {
        return this.colaborador as PessoaFisica;
    }
    /**
     *  Formularios
     */
    public formularioComoColaborar: FormGroup;
    public formularioDadosPessoais: FormGroup;
    public formularioAutenticacao: FormGroup;

    constructor(private colaboradorService: ColaboradorService,
        private cd: ChangeDetectorRef,
        private snakBar: MatSnackBar) {
        this.formularioComoColaborar = new FormGroup({
            tipoColaborador: new FormControl('', [Validators.required]),
            tipoPessoa: new FormControl('', Validators.required)
        });
        this.formularioDadosPessoais = new FormGroup({
            nome: new FormControl('', [Validators.required]),
            email: new FormControl('', [Validators.required, Validators.email])
        });
        this.formularioAutenticacao = new FormGroup({
            senha: new FormControl('', [Validators.required]),
            confirmarSenha: new FormControl('', [Validators.required])
        });
        this.colaborador = new Colaborador();
    }


    ngOnInit() {
        this.currentStep = 0;
        this.tiposPessoas = TipoPessoaEnum.values();
        this.colaboradorService.pegarTiposColaboradores().subscribe(tiposColaborador => {
            this.tiposDeColaborador = tiposColaborador;
        });

    }

    ngAfterViewInit(): void {
        setTimeout(() => {
            this.enderecoLoad = true;
            this.cd.detectChanges();
        }, 500);

    }

    isPessoaFisica() {
        return this.colaborador instanceof PessoaFisica;
    }

    isPessoaJuridica() {
        return this.colaborador instanceof PessoaJuridica;
    }

    /**
     *
     */
    nomeColaborador() {
        return this.colaborador instanceof PessoaFisica ? 'Nome' : 'Nome do Representante';
    }
    /**
     * Eventos
     */
    onTipoPessoaChange() {
        this.formularioComoColaborar.setControl('tipoColaborador', new FormControl('', Validators.required));
        if (this.tipoPessoa === TipoPessoaEnum.FISICA) {
            this.colaborador = new PessoaFisica();
            this.formularioDadosPessoais.addControl('cpf', new FormControl('', Validators.required));
        } else {
            this.colaborador = new PessoaJuridica();
            this.formularioDadosPessoais.addControl('cnpj', new FormControl('', Validators.required));
            this.formularioDadosPessoais.addControl('razaoSocial', new FormControl('', Validators.required));
            this.formularioDadosPessoais.addControl('nomeFantasia', new FormControl('', Validators.required));
        }

        this.removerValidacoesDadosPessoais();
    }

    /**
     *
     * Método para recuperar
     * foto selecionada
     *
     */
    onSelecionarFoto(event) {
        const arquivos = event.target.files;
        if (arquivos.length > 0) {
            const file: File = arquivos[0];
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = () => {
                this.colaborador.imagem = reader.result as string;
            };
        }
    }

    removerValidacoesDadosPessoais() {
        if (this.isPessoaJuridica()) {
            this.formularioDadosPessoais.removeControl('cpf');
        }
        if (this.isPessoaFisica()) {
            this.formularioDadosPessoais.removeControl('cnpj');
            this.formularioDadosPessoais.removeControl('razaoSocial');
            this.formularioDadosPessoais.removeControl('nomeFantasia');
        }
    }

    cadastrar() {
        if (this.formularioAutenticacao.valid) {
            this.colaboradorService.cadastrarColaborador(this.colaborador).subscribe(result => {
                this.snakBar.open('Colaborador cadastrado com sucesso!', null, { duration: 5000, panelClass: 'snack-sucess' });
                this.colaborador = new Colaborador();
                this.currentStep = 0;
                this.formularioAutenticacao.reset();
                this.formularioDadosPessoais.reset();
                this.formularioComoColaborar.reset();
                this.stepper.selectedIndex = 0;
                this.cd.markForCheck();
            }, error => {
                this.snakBar.open(error, null, { duration: 5000, panelClass: 'snack-error' });
            });
        }
    }

}
