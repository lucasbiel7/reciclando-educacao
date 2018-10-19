import { Component, OnInit } from '@angular/core';
import { Credencial } from '../../../shared/resource/class/credencial.class';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { SegurancaService } from '../../services/seguranca.service';

@Component({
    selector: 'redu-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

    public credencial: Credencial;
    public formulario: FormGroup;

    constructor(private segurancaService: SegurancaService) {
        this.credencial = new Credencial();
    }

    ngOnInit() {
        this.formulario = new FormGroup({
            email: new FormControl('', Validators.required),
            senha: new FormControl('', Validators.required)
        });

    }

    public login() {
        if (this.formulario.valid) {
            this.segurancaService.login(this.credencial).subscribe(resultado => {

            });
        }
    }
}
