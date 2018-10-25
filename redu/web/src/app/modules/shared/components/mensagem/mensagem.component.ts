import { TipoMensagem } from './../../resource/enum/tipo-mensagem.enum';
import { Mensagem } from './../../resource/class/mensagem.class';
import { Component, OnInit, OnChanges, Input, SimpleChanges } from '@angular/core';

@Component({
    selector: 'redu-mensagem',
    templateUrl: './mensagem.component.html',
    styleUrls: ['./mensagem.component.scss']
})
export class MensagemComponent implements OnInit, OnChanges {

    @Input()
    public mensagem: string;

    TipoMensagem = TipoMensagem;
    public mensagens: Mensagem[];

    constructor() {
        this.mensagens = [];
    }

    ngOnInit() {

    }

    ngOnChanges(changes: SimpleChanges): void {
        if (!changes.mensagem.firstChange) {
            this.mensagens.push(changes.mensagem.currentValue);
            setTimeout(() => {
                this.mensagens.pop();
            }, 5000);
        }
    }

}
