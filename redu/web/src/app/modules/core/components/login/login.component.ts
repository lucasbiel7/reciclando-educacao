import { Mensagem } from './../../../shared/resource/class/mensagem.class';
import { Component, OnInit } from '@angular/core';
import { Credencial } from '../../../shared/resource/class/credencial.class';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { SegurancaService } from '../../services/seguranca.service';
import { TipoMensagem } from '../../../shared/resource/enum/tipo-mensagem.enum';
import { Router } from '@angular/router';

@Component({
    selector: 'redu-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

    public credencial: Credencial;
    public formulario: FormGroup;
    public mensagem: Mensagem;

    constructor(private segurancaService: SegurancaService, private router: Router) {
        this.credencial = new Credencial();
    }

    ngOnInit() {
        this.formulario = new FormGroup({
            email: new FormControl('', [Validators.required, Validators.email]),
            senha: new FormControl('', Validators.required)
        });

    }

    public login() {
        if (this.formulario.valid) {
            this.segurancaService.login(this.credencial).subscribe(resultado => {
                if (this.segurancaService.lastRoute) {
                    this.router.navigateByUrl(this.segurancaService.lastRoute);
                } else {
                    this.router.navigate(['dashboard']);
                }
            }, error => {
                if (error.status === 403) {
                    this.mensagem = {
                        mensagem: error.error,
                        tipo: TipoMensagem.ERRO
                    };
                }
            });
        }
    }

}
