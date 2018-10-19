import { SegurancaService } from './seguranca.service';
import { HttpInterceptor, HttpEvent, HttpHandler, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class SegurancaInterceptor implements HttpInterceptor {

    constructor(private segurancaService: SegurancaService) {

    }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        if (this.segurancaService.logado) {
            request = request.clone({
                setHeaders: {
                    Authorization: `Bearer ${this.segurancaService.token}`
                }
            });
        }
        return next.handle(request);
    }

}
