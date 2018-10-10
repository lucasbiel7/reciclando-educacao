import { Component, OnInit, ViewChild } from '@angular/core';
import { MatStepper } from '@angular/material';

@Component({
    selector: 'redu-cadastro-colaborador',
    templateUrl: './cadastro-colaborador.component.html',
    styleUrls: ['./cadastro-colaborador.component.scss']
})
export class CadastroColaboradorComponent implements OnInit {

    @ViewChild('stepper')
    public stepper: MatStepper;
    currentStep: any;

    constructor() { }

    ngOnInit() {
        this.currentStep = 0;
    }

}
