import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Validator } from '../../../shared/resource/class/validator.class';

@Component({
    selector: 'redu-formulario-colaborador',
    templateUrl: './formulario-colaborador.component.html',
    styleUrls: ['./formulario-colaborador.component.scss']
})
export class FormularioColaboradorComponent implements OnInit {
    public formulario: FormGroup;





    constructor() {
        this.formulario = new FormGroup({
            nomeColaborador: new FormControl('', Validators.required),
            tipoColaborador: new FormControl('', Validators.required),
            tipoFormacao: new FormControl('', Validators.required),
            tipoExperiencia: new FormControl('', Validators.required)
        });
    }

    ngOnInit() {
        this.formulario.get('nomeColaborador').hasError('required');
    }

    public cadastroColaborador() {
        Validator.validarCampos(this.formulario);
        if (this.formulario.valid) {
        }

    }


}



