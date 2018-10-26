import { environment } from './../../../../environments/environment';
import { Injectable, Injector } from '@angular/core';
import { Credencial } from '../../shared/resource/class/credencial.class';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class SegurancaService {

    private api: string;
    public lastRoute: string;

    constructor(private injector: Injector) {
        this.api = 'seguranca';
    }

    get http() {
        return this.injector.get(HttpClient);
    }

    public login(credencial: Credencial) {
        return this.http.post(`${environment.backend + this.api}/login`, credencial);
    }

    public get token(): string {
        return localStorage.getItem(environment.userToken);
    }

    public get logado() {
        return this.token != null;
    }

    public logaout(): void {
        localStorage.removeItem(environment.userToken);
    }
}
