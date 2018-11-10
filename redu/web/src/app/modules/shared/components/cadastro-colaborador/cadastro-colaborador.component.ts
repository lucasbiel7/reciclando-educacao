import { Component, OnInit, ViewChild } from '@angular/core';
import { MatStepper } from '@angular/material';
import { ColaboradorService } from '../../services/colaborador.service';
import { TipoColaborador } from '../../resource/class/tipo-colaborador.class';

@Component({
    selector: 'redu-cadastro-colaborador',
    templateUrl: './cadastro-colaborador.component.html',
    styleUrls: ['./cadastro-colaborador.component.scss']
})
export class CadastroColaboradorComponent implements OnInit {

    @ViewChild('stepper')
    public stepper: MatStepper;
    currentStep: any;

    public tiposDeColaborador: TipoColaborador[];

    constructor(private colaboradorService: ColaboradorService) { }

    ngOnInit() {
        this.currentStep = 0;
        this.colaboradorService.pegarTiposColaboradores().subscribe(tiposColaborador => {
            this.tiposDeColaborador = tiposColaborador;
        });

    }

}
