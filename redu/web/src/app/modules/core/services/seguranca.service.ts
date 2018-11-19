import { environment } from './../../../../environments/environment';
import { Injectable, Injector } from '@angular/core';
import { Credencial } from '../../shared/resource/class/credencial.class';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../../shared/resource/class/usuario.class';
import { JwtHelper } from 'angular2-jwt';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import { Subject } from 'rxjs/Subject';
@Injectable()
export class SegurancaService {
    public usuarioAtualizado: Subject<void>;
    private api: string;
    public lastRoute: string;
    private _usuario: Usuario;
    private loadUser: boolean;
    private jwtHelper: JwtHelper;

    constructor(private injector: Injector, private router: Router) {
        this.api = 'seguranca';
        this.jwtHelper = new JwtHelper();
        this.usuarioAtualizado = new Subject();
    }

    get http() {
        return this.injector.get(HttpClient);
    }

    get usuario(): Usuario {
        if (this.logado) {
            const token = this.jwtHelper.decodeToken(this.token);
            const isExpired = this.jwtHelper.isTokenExpired(this.token);
            if (isExpired) {
                this.logaout();
            }
            if (!this._usuario) {
                if (!this.loadUser) {
                    this.loadUser = true;
                    this.buscarUsuario().subscribe(usuario => {
                        this._usuario = usuario;
                        this.usuarioAtualizado.next(undefined);
                        this.loadUser = false;
                    });
                }
                return token;
            }

            return this._usuario;
        }
        return null;
    }

    public get tempoRestante(): string {
        if (this.logado) {
            const end = this.jwtHelper.getTokenExpirationDate(this.token).getTime();
            const now = new Date().getTime();
            const diff = end - now;
            const minutos = Math.floor(diff / (60 * 1000));
            const segundos = Math.floor((diff % (60 * 1000)) / 1000);
            const tempoRestante = minutos + ':' + segundos;
            return tempoRestante;
        }
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

    public get logado(): boolean {
        return this.token != null;
    }

    public logaout(): void {
        this._usuario = null;
        localStorage.removeItem(environment.userToken);
        this.usuarioAtualizado.next(undefined);
        this.router.navigate(['login']);
    }
}
