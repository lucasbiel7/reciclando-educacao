import { Component, OnInit } from '@angular/core';
import { environment } from '../../../../environments/environment';

@Component({
    selector: 'redu-rodape',
    templateUrl: './rodape.component.html',
    styleUrls: ['./rodape.component.scss']
})
export class RodapeComponent implements OnInit {

    public env: any;

    constructor() { }

    ngOnInit() {
        this.env = environment;
    }
}
