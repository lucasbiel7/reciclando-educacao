import { Component, OnInit } from '@angular/core';
import { TipoDoacao } from '../../../shared/resource/interfaces/tipo-doacao.interface';
import { FormularioDoadorService } from '../../services/formulario-doador.service';

@Component({
    selector: 'redu-formulario-doador',
    templateUrl: './formulario-doador.component.html',
    styleUrls: ['./formulario-doador.component.scss']
})
export class FormularioDoadorComponent implements OnInit {

    public tipoDoacoes: TipoDoacao[];
    public listaDoacoes: TipoDoacao[][];

    /**
     * Criando lista para armazenar o tipo das doações
     * Toda vez que adicionar um elemento será feito uma pesquisa e verificado se tem filhps,
     * caso houver adicionar um elemento na lista e refeito o vetor
     *  Combo box recursivo
     *
     */
    constructor(private formularioDoadorService: FormularioDoadorService) {
        this.tipoDoacoes = [];
        this.tipoDoacoes.push(null);

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
        });
    }

    public selecionarTipoDoacao(i: number) {
        this.tipoDoacoes.slice(0, i + 1);
        this.formularioDoadorService.buscarTiposDoacoes(this.tipoDoacoes[i].id).subscribe(t => {
            if (t.length > 0) {
                this.tipoDoacoes.push(null);
                this.listaDoacoes[i + 1] = t;
            }
        });
    }
}
