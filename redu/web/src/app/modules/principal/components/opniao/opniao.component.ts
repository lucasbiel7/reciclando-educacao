import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { Colaborador } from '../../../shared/resource/class/colaborador.class';
import { Credencial } from '../../../shared/resource/class/credencial.class';
import { Validator } from '../../../shared/resource/class/validator.class';



@Component({
    selector: 'redu-opniao',
    templateUrl: './opniao.component.html',
    styleUrls: ['./opniao.component.scss']
})
export class OpniaoComponent implements OnInit {

    public formulario: FormGroup;
    public colaborador: Colaborador;
    public credencial: Credencial;

    constructor() {
        this.formulario = new FormGroup({
            nomeColaborador: new FormControl('', Validators.required),
            email: new FormControl('', [Validators.required, Validators.email]),
            DeixesuaOpniao: new FormControl('', Validators.required)
        });
        this.colaborador = new Colaborador();
        this.credencial = new Credencial();
    }

    ngOnInit() {
        this.formulario.get('nomeColaborador').hasError('required');
        this.formulario.get('email').hasError('required');
        this.formulario.get('DeixesuaOpniao').hasError('required');
    }

    public registraropniao() {
        Validator.validarCampos(this.formulario);
        if (this.formulario.valid) {
        }

    }

}
