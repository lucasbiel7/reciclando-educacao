import { environment } from './../../../../environments/environment';
import { Injectable, Injector } from '@angular/core';
import { Credencial } from '../../shared/resource/class/credencial.class';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../../shared/resource/class/usuario.class';
import { JwtHelper } from 'angular2-jwt';
import { Observable } from 'rxjs/Observable';
@Injectable()
export class SegurancaService {

    private api: string;
    public lastRoute: string;
    private _usuario: Usuario;
    private loadUser: boolean;

    constructor(private injector: Injector, ) {
        this.api = 'seguranca';

    }

    get http() {
        return this.injector.get(HttpClient);
    }

    get usuario(): Usuario {
        if (this.logado) {
            const jwtHelper: JwtHelper = new JwtHelper();
            const token = jwtHelper.decodeToken(this.token);
            const isExpired = jwtHelper.isTokenExpired(this.token);
            if (isExpired) {
                this.logaout();
            }
            if (!this._usuario) {
                if (!this.loadUser) {
                    console.log(this.token);
                    this.loadUser = true;
                    this.buscarUsuario().subscribe(usuario => {
                        this._usuario = usuario;
                        this.loadUser = false;
                    });
                }
                return token;
            }

            return this._usuario;
        }
        return null;
    }

    public buscarUsuario(): Observable<Usuario> {
        return this.http.get(`${environment.backend + this.api}/usuario`).map(response => response as Usuario);
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
