import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { CepService } from '../../services/cep.service';
import { Endereco } from '../../resource/class/endereco.class';

@Component({
    selector: 'redu-endereco',
    templateUrl: './endereco.component.html',
    styleUrls: ['./endereco.component.scss']
})
export class EnderecoComponent implements OnInit {

    @Output()
    public change: EventEmitter<Endereco> = new EventEmitter();;

    public _endereco: Endereco;

    @Input()
    get endereco() {
        return this._endereco;
    }
    set endereco(val) {
        this._endereco = val;
        if (this._endereco == null) {
            this._endereco = new Endereco();
        }
        this.change.emit(this._endereco);
    }

    cep: string;

    constructor(private cepService: CepService) {
        this.endereco = new Endereco();
    }

    ngOnInit() {

    }

    /**
     * Caso ao sair do componente de CEP e ele for valido realizar a pesquisa dos dados
     * Utilizado o número 10 porque é o tamanho máximo do CEP permitido
     *
     */
    public carregarEndereco(): void {
        if (this.endereco.cep && this.endereco.cep.length === 10) {
            this.cepService.consultarCEP(this.endereco.cep).subscribe(endereco => {
                this.endereco = endereco;
            });
        }
    }
}
