import { Directive, HostListener } from '@angular/core';
import { ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms';

@Directive({
    selector: '[reduCpf]',
    providers: [{
        provide: NG_VALUE_ACCESSOR,
        useExisting: CpfDirective,
        multi: true
    }]
})
export class CpfDirective implements ControlValueAccessor {

    onTouched: any;
    onChange: any;

    constructor() {

    }

    writeValue(obj: any): void {
    }

    registerOnChange(fn: any): void {
        this.onChange = fn;
    }
    registerOnTouched(fn: any): void {
        this.onTouched = fn;
    }

    @HostListener('keyup', ['$event'])
    onKeyup($event: any) {
        let valor: string = $event.target.value;
        if ($event.keyCode === 8) {
            this.onChange(valor);
            return;
        }
        if (valor.length > 14) {
            valor = valor.substr(0, 14);
        }
        valor = valor.replace('.', '').replace('-', '').replace(/[^0-9]/, '');
        valor = valor.replace(/([0-9]{3})([0-9]*)/g, '$1.$2');
        valor = valor.replace(/([0-9]{3}[.]{1}[0-9]{3})([0-9]*)/g, '$1.$2');
        valor = valor.replace(/([0-9]{3}[.]{1}[0-9]{3}[.]{1}[0-9]{3})([0-9]*)/g, '$1-$2');
        this.onChange(valor);
        $event.target.value = valor;
    }

    @HostListener('blur', ['$event'])
    onBlur($event: any) {

    }

}
