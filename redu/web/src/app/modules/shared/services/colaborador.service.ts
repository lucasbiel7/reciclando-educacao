import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { TipoColaborador } from '../resource/class/tipo-colaborador.class';
import { environment } from '../../../../environments/environment';
import { Colaborador } from '../resource/class/colaborador.class';
import { PessoaFisica } from '../resource/class/pessoa-fisica.class';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';

@Injectable()
export class ColaboradorService {

    private URL: string;

    constructor(private http: HttpClient) {
        this.URL = environment.backend + 'colaborador';
    }

    public pegarTiposColaboradores(): Observable<TipoColaborador[]> {
        return this.http.get(`${this.URL}/tipo-colaborador`).map(response => response as TipoColaborador[]);
    }

    /**
     * Função criada para conseguir criar um colaborador
     *  Caso por algum motivo o backend retorne erro e lançada para camada de frontend
     *
     * @param colaborador
     */
    public cadastrarColaborador(colaborador: Colaborador): Observable<any> {
        return this.http.post(`${this.URL}/cadastrar-${colaborador instanceof PessoaFisica ? 'fisica' : 'juridica'}`, colaborador).
            catch(response => new ErrorObservable(response.error));
    }


}
