import { environment } from './../../../../environments/environment';
import { SegurancaService } from './seguranca.service';
import { HttpInterceptor, HttpEvent, HttpHandler, HttpRequest, HttpResponse } from '@angular/common/http';
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
        return next.handle(request).map(event => {
            if (event instanceof HttpResponse) {
                const resposta: HttpResponse<any> = event;
                if (resposta.headers.get('authorization')) {
                    localStorage.setItem(environment.userToken, resposta.headers.get('authorization'));
                }
            }
            return event;
        });
    }

}
