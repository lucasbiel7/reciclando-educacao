import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Doacao } from '../../../../shared/resource/class/doacao.class';
import { FormularioDoadorComponent } from '../../../../shared/components/formulario-doador/formulario-doador.component';
import { DoacaoService } from '../../../../core/services/doacao.service';
import { SegurancaService } from '../../../../core/services/seguranca.service';
import { Endereco } from '../../../../shared/resource/class/endereco.class';
import { EnderecoComponent } from '../../../../shared/components/endereco/endereco.component';
import { Colaborador } from '../../../../shared/resource/class/colaborador.class';
import { MatSnackBar } from '@angular/material';
import { Usuario } from '../../../../shared/resource/class/usuario.class';

@Component({
    selector: 'redu-cadastrar-doacao',
    templateUrl: './cadastrar-doacao.component.html',
    styleUrls: ['./cadastrar-doacao.component.scss']
})
export class CadastrarDoacaoComponent implements OnInit {


    @ViewChild('formularioDoacao')
    public formularioDoador: FormularioDoadorComponent;

    @ViewChild('enderecoComponent')
    public enderecoComponent: EnderecoComponent;

    public doacao: Doacao;

    constructor(private doacaoService: DoacaoService,
        private segurancaService: SegurancaService,
        private snakBar: MatSnackBar) {

    }

    ngOnInit() {
        // Carregar usuario
        if (this.segurancaService.usuario instanceof Usuario) {
            this.doacao.colaborador = this.segurancaService.usuario as Colaborador;
        }
        if (this.doacaoService.doacao) {
            this.doacao = this.doacaoService.doacao;
        } else {
            this.doacao = new Doacao();
        }
    }


    public utilizarMeuEndereco() {
        this.doacao.endereco = this.segurancaService.usuario.endereco;
        this.doacao.endereco.id = null;
    }

    public cadastrarDoacao() {
        if (this.formularioDoador.formulario.valid && this.enderecoComponent.formulario.valid) {
            this.doacao.colaborador = Object.assign(new Colaborador(), this.segurancaService.usuario as Colaborador);

            this.doacaoService.cadastrarDoacao(this.doacao).subscribe(doacao => {
                this.snakBar.open('A doação de número ' + doacao.id + ' foi registrada com sucesso',
                    null, { duration: 5000, panelClass: 'snack-sucess' });
            }, error => {
                console.log(error);
            });
        }
    }

    public limparFormularios() {
        this.formularioDoador.formulario.reset();
        this.enderecoComponent.formulario.reset();
    }
}
