import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Escola } from '../../shared/resource/class/escola.class';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../../../environments/environment';

@Injectable()
export class EscolaService {

    private url: string;
    constructor(private http: HttpClient) {
        this.url = environment.backend + 'escola';
    }


    public buscarEscolas(nome?: string): Observable<Escola[]> {
        if (nome) {
            return this.http.get(this.url + '/' + nome).map(response => response as Escola[]);
        }
        return this.http.get(this.url).map(response => response as Escola[]);
    }

}
