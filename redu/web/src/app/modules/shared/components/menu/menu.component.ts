import { Component, OnInit } from '@angular/core';
import { SegurancaService } from '../../../core/services/seguranca.service';
import { Router } from '@angular/router';
import { Colaborador } from '../../resource/class/colaborador.class';

@Component({
    selector: 'redu-menu',
    templateUrl: './menu.component.html',
    styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

    constructor(public segurancaService: SegurancaService, private router: Router) {

    }

    ngOnInit() {
        if (this.segurancaService.logado) {
            this.segurancaService.usuarioAtualizado.subscribe(() => {

            });
        }

    }

    permissao(perfil?: string) {
        if (this.segurancaService.logado) {
            if ((this.segurancaService.usuario as Colaborador).tipoColaborador) {
                if (perfil) {
                    return (this.segurancaService.usuario as Colaborador).tipoColaborador.descricao.toLocaleLowerCase() === perfil
                        || this.segurancaService.usuario.administrador;
                }
                return true;
            }
        }
        return false;
    }

    public logout() {
        this.segurancaService.logaout();
    }

    onDoar() {
        this.router.navigate(['doacao']);
    }

    onColaborar() {
        this.router.navigate(['colaborar']);
    }

    onConfiguracao() {
        this.router.navigate(['dashboard', 'configuracao']);
    }

    onLogo() {
        this.router.navigate(this.segurancaService.logado ? ['/dashboard'] : ['/inicio']);
    }
}
