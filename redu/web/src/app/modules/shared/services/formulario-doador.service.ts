import { Doacao } from '../resource/class/doacao.class';
import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment.dese';
import { Observable } from 'rxjs/Observable';
import { TipoDoacao } from '../resource/interfaces/tipo-doacao.interface';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class FormularioDoadorService {

    private controller: string;

    public doacao: Doacao;

    constructor(private http: HttpClient) {
        this.controller = 'formulario-doador';
    }

    public buscarTiposDoacoes(id?: number): Observable<TipoDoacao[]> {
        if (id) {
            return this.http.get(`${environment.backend}${this.controller}/buscar-tipos-doacao/${id}`).map(data => data as TipoDoacao[]);
        }
        return this.http.get(`${environment.backend}${this.controller}/buscar-tipos-doacao`).map(data => data as TipoDoacao[]);
    }

}
