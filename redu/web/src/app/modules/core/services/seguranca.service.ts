import { environment } from './../../../../environments/environment';
import { Injectable, Injector } from '@angular/core';
import { Credencial } from '../../shared/resource/class/credencial.class';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class SegurancaService {
    private api: string;

    constructor(private injector: Injector) {
        this.api = 'seguranca';
    }

    get http() {
        return this.injector.get(HttpClient);
    }

    public login(credencial: Credencial) {
        return this.http.post(`${environment.backend + this.api}/login`, credencial);
    }


    public get token() {
        return '';
    }

    public get logado() {
        return false;
    }
}
