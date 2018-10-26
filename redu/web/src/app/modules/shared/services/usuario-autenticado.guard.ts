import { SegurancaService } from '../../core/services/seguranca.service';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router, CanActivateChild } from '@angular/router';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UsuarioAutenticadoGuard implements CanActivate, CanActivateChild {

    constructor(private segurancaService: SegurancaService, private router: Router) {

    }

    public canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        if (!this.segurancaService.logado) {
            this.segurancaService.lastRoute = state.url;
            this.router.navigate(['login']);
        }
        return this.segurancaService.logado;
    }

    canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean>
        | Promise<boolean> {
        return this.canActivate(childRoute, state);
    }
}
