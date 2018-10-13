import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { CepService } from '../../services/cep.service';
import { Endereco } from '../../resource/class/endereco.class';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
    selector: 'redu-endereco',
    templateUrl: './endereco.component.html',
    styleUrls: ['./endereco.component.scss']
})
export class EnderecoComponent implements OnInit {

    @Output()
    public change: EventEmitter<Endereco>;
    public formulario: FormGroup;
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
        this.change = new EventEmitter();
        this.endereco = new Endereco();
    }

    ngOnInit() {
        this.formulario = new FormGroup({
            cep: new FormControl(null, Validators.required),
            logradouro: new FormControl(null, Validators.required),
            bairro: new FormControl(null, Validators.required),
            numero: new FormControl(null, Validators.required),
            uf: new FormControl(null, Validators.required),
            municipio: new FormControl(null, Validators.required)
        });
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
