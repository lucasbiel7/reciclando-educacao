import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { TipoColaborador } from '../resource/class/tipo-colaborador.class';
import { environment } from '../../../../environments/environment';

@Injectable()
export class ColaboradorService {
    private URL: string;

    constructor(private http: HttpClient) {
        this.URL = environment.backend + 'colaborador';
    }

    public pegarTiposColaboradores(): Observable<TipoColaborador[]> {
        return this.http.get(`${this.URL}/tipo-colaborador`).map(response => response as TipoColaborador[]);
    }


}
