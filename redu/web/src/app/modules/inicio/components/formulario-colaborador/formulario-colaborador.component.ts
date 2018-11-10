import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Validator } from '../../../shared/resource/class/validator.class';
import { TipoColaborador } from '../../../shared/resource/class/tipo-colaborador.class';
import { ColaboradorService } from '../../../shared/services/colaborador.service';
import { Colaborador } from '../../../shared/resource/class/colaborador.class';

@Component({
    selector: 'redu-formulario-colaborador',
    templateUrl: './formulario-colaborador.component.html',
    styleUrls: ['./formulario-colaborador.component.scss']
})
export class FormularioColaboradorComponent implements OnInit {
    public formulario: FormGroup;
    public tiposDeColaborador: TipoColaborador[];
    public colaborador: Colaborador;



    constructor(private colaboradorService: ColaboradorService) {
        this.formulario = new FormGroup({
            nomeColaborador: new FormControl('', Validators.required),
            tipoColaborador: new FormControl('', Validators.required),
            tipoFormacao: new FormControl('', Validators.required),
            tipoExperiencia: new FormControl('', Validators.required)
        });
        this.colaborador = new Colaborador();
    }

    ngOnInit() {
        this.formulario.get('nomeColaborador').hasError('required');
        this.colaboradorService.pegarTiposColaboradores().subscribe(tiposColaborador => {
            this.tiposDeColaborador = tiposColaborador;
        });
    }

    public cadastroColaborador() {
        Validator.validarCampos(this.formulario);
        if (this.formulario.valid) {
        }

    }


}



