import { Doacao } from './../../shared/resource/class/doacao.class';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment';

@Injectable()
export class DoacaoService {

    public doacao: Doacao;
    public url: string;

    constructor(private httpCliente: HttpClient) {
        this.url = environment.backend + 'doacao';
    }

    public cadastrarDoacao(doacao: Doacao): Observable<Doacao> {
        return this.httpCliente.post(this.url, doacao).map(response => response as Doacao);
    }

}
