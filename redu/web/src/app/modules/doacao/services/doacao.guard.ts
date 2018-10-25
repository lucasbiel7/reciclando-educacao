import { SegurancaService } from './../../core/services/seguranca.service';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class DoacaoGuard implements CanActivate {

    constructor(private segurancaService: SegurancaService, private router: Router) {

    }

    public canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        if (!this.segurancaService.logado) {
            this.segurancaService.lastRoute = next.url;
            this.router.navigate(['login']);
        }
        return this.segurancaService.logado;
    }
}
