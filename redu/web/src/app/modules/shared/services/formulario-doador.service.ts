import { Doacao } from '../resource/class/doacao.class';
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../../../environments/environment.dese';
import { Observable } from 'rxjs/Observable';
import { TipoDoacao } from '../resource/interfaces/tipo-doacao.interface';

@Injectable()
export class FormularioDoadorService {

    private controller: string;

    public doacao: Doacao;

    constructor(private http: Http) {
        this.controller = 'formulario-doador';
    }

    public buscarTiposDoacoes(id?: number): Observable<TipoDoacao[]> {
        if (id) {
            return this.http.get(`${environment.backend}${this.controller}/buscar-tipos-doacao/${id}`).map(response => response.json());
        }
        return this.http.get(`${environment.backend}${this.controller}/buscar-tipos-doacao`).map(response => response.json());
    }

}
