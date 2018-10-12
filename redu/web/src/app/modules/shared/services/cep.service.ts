import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Endereco } from '../resource/class/endereco.class';

@Injectable()
export class CepService {

    private endereco: string;

    constructor(private http: Http) {
        this.endereco = 'https://viacep.com.br/ws/{0}/json/';
    }

    public consultarCEP(cep: string): Observable<Endereco> {
        cep = cep.replace('.', '').replace('-', '');
        return this.http.get(this.endereco.replace('{0}', cep)).map(response => response.json()).map(enderecoJSON => {
            const endereco: Endereco = new Endereco();
            endereco.cep = enderecoJSON.cep;
            endereco.logradouro = enderecoJSON.logradouro;
            endereco.bairro = enderecoJSON.bairro;
            endereco.municipio = enderecoJSON.localidade;
            endereco.uf = enderecoJSON.uf;
            return endereco;
        });
    }
}
