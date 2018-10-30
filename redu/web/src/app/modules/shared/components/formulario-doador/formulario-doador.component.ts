import { Doacao } from './../../../shared/resource/class/doacao.class';
import { EstadoDoacaoEnum } from './../../../shared/resource/enum/estado-doacao.enum';
import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { TipoDoacao } from '../../../shared/resource/interfaces/tipo-doacao.interface';
import { FormularioDoadorService } from '../../services/formulario-doador.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'redu-formulario-doador',
    templateUrl: './formulario-doador.component.html',
    styleUrls: ['./formulario-doador.component.scss']
})
export class FormularioDoadorComponent implements OnInit, OnChanges {

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
    }

    private _doacao: Doacao;
    public formulario: FormGroup;

    /**
     * Criando lista para armazenar o tipo das doações
     * Toda vez que adicionar um elemento será feito uma pesquisa e verificado se tem filhos,
     * caso houver adicionar um elemento na lista e refeito o vetor
     * Combo box recursivo
     *
     */
    constructor(private formularioDoadorService: FormularioDoadorService) {
        this.tipoDoacoes = [];
        this.doacao = new Doacao();
        this.tipoDoacoes.push(null);
        this.estadosDoacao = [EstadoDoacaoEnum.NOVO, EstadoDoacaoEnum.USADO, EstadoDoacaoEnum.COM_DEFEITO];
        this.formulario = new FormGroup({
            caracteristica: new FormControl('', Validators.required),
            quantidade: new FormControl('', [Validators.required, Validators.max(100)]),
            estadoDoacao: new FormControl('', Validators.required)
        });
        this.formulario.addControl('tipoDoacao0', new FormControl('', Validators.required));
    }

    ngOnInit() {
        this.carregarLista(0);
    }

    ngOnChanges(changes): void {
    }


    public carregarLista(index: number) {
        if (!this.listaDoacoes) {
            this.listaDoacoes = [];
        }
        this.formularioDoadorService.buscarTiposDoacoes().subscribe(t => {
            this.listaDoacoes[index] = t;
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
                this.formulario.addControl('tipoDoacao' + (i + 1), new FormControl('', Validators.required));
                this.listaDoacoes[i + 1] = t;
            }
        });
    }

}
