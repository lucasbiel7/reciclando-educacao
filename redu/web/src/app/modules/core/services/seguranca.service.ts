import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Credencial } from '../../shared/resource/class/credencial.class';

@Injectable()
export class SegurancaService {
    private api: string;

    constructor(private http: Http) {
        this.api = 'rest/seguranca';
    }

    public login(credencial: Credencial) {
        return this.http.post(`${this.api}/login`, credencial).map(response => response.json());
    }


    public get token() {
        return '';
    }

    public get logado() {
        return false;
    }
}
