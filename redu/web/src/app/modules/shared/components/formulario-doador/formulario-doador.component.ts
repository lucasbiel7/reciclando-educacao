import { Doacao } from './../../../shared/resource/class/doacao.class';
import { EstadoDoacaoEnum } from './../../../shared/resource/enum/estado-doacao.enum';
import { Component, OnInit, Input } from '@angular/core';
import { TipoDoacao } from '../../../shared/resource/interfaces/tipo-doacao.interface';
import { FormularioDoadorService } from '../../services/formulario-doador.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'redu-formulario-doador',
    templateUrl: './formulario-doador.component.html',
    styleUrls: ['./formulario-doador.component.scss']
})
export class FormularioDoadorComponent implements OnInit {

    public tipoDoacoes: TipoDoacao[];
    public listaDoacoes: TipoDoacao[][];
    public estadosDoacao: EstadoDoacaoEnum[];
    @Input('doacao')
    public get doacao() {
        return this._doacao;
    }
    public set doacao(doacao: Doacao) {
        if (doacao == null) {
            doacao = new Doacao();
        }
        this._doacao = doacao;
        this.carregarTiposDoacoes();
    }

    private _doacao: Doacao;
    public formulario: FormGroup;

    /**
     * Criando lista para armazenar o tipo das doações
     * Toda vez que adicionar um elemento será feito uma pesquisa e verificado se tem filhos,
     * caso houver adicionar um elemento na lista e refeito o vetor
     *  Combo box recursivo
     *
     */
    constructor(private formularioDoadorService: FormularioDoadorService) {
        this.tipoDoacoes = [];
        this.doacao = new Doacao();
        this.tipoDoacoes.push(null);
        this.estadosDoacao = [EstadoDoacaoEnum.NOVO, EstadoDoacaoEnum.USADO, EstadoDoacaoEnum.COM_DEFEITO];
        this.formulario = new FormGroup({
            caracteristica: new FormControl('', Validators.required),
            quantidade: new FormControl('', Validators.required),
            estadoDoacao: new FormControl('', Validators.required)
        });
        this.formulario.addControl('tipoDoacao0', new FormControl('', Validators.required));
    }

    ngOnInit() {
        this.carregarLista(0);
    }

    public carregarLista(index: number) {
        if (!this.listaDoacoes) {
            this.listaDoacoes = [];
        }
        this.formularioDoadorService.buscarTiposDoacoes().subscribe(t => {
            this.listaDoacoes[index] = t;
            if (this.tipoDoacoes[index]) {
                this.tipoDoacoes[index] = this.listaDoacoes[index].filter(tipoDoacao => tipoDoacao.id === this.tipoDoacoes[index].id)[0];
                console.log('entrando aqui pelo menos');
            }
        });
    }

    /**
     * Atualiza o tipo atual do item selecionado em doação e filtra
     * seus sub-tipos
     *
     * @param i
     */
    public selecionarTipoDoacao(i: number) {
        this.doacao.tipoDoacao = this.tipoDoacoes[i];
        this.tipoDoacoes = this.tipoDoacoes.slice(0, i + 1);
        this.formularioDoadorService.buscarTiposDoacoes(this.tipoDoacoes[i].id).subscribe(t => {
            if (t.length > 0) {
                this.tipoDoacoes.push(null);
                this.formulario.addControl('tipoDoacao' + i, new FormControl('', Validators.required));
                this.listaDoacoes[i + 1] = t;
            }
        });
    }

    private carregarTiposDoacoes() {
        if (this.doacao.tipoDoacao) {
            let tipoDoacaoLoop = this.doacao.tipoDoacao;
            const vet = [];
            do {
                vet.splice(0, 0, tipoDoacaoLoop);
                tipoDoacaoLoop = tipoDoacaoLoop.tipoDoacao;
            } while (tipoDoacaoLoop);
            this.tipoDoacoes = vet;
        }
    }

}
