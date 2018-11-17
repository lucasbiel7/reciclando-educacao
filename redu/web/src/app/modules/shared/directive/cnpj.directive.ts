import { Directive, HostListener, ElementRef } from '@angular/core';
import { NG_VALUE_ACCESSOR, ControlValueAccessor } from '@angular/forms';

@Directive({
    selector: '[reduCnpj]',
    providers: [{
        provide: NG_VALUE_ACCESSOR,
        useExisting: CnpjDirective,
        multi: true
    }]
})
export class CnpjDirective implements ControlValueAccessor {

    onTouched: any;
    onChange: any;

    constructor(private el: ElementRef) {

    }

    writeValue(value: any): void {
        this.el.nativeElement.value = this.formatar(value);
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
        valor = this.formatar(valor);
        this.onChange(valor);
        $event.target.value = valor;
    }

    private formatar(valor) {
        if (!valor) {
            return null;
        }
        if (valor.length > 18) {
            valor = valor.substr(0, 18);
        }
        valor = valor.replace('.', '').replace('-', '').replace(/[^0-9]/, '').replace(/[/]{1}/, '');
        valor = valor.replace(/([0-9]{2})([0-9]*)/g, '$1.$2');
        valor = valor.replace(/([0-9]{2}[.]{1}[0-9]{3})([0-9]*)/g, '$1.$2');
        valor = valor.replace(/([0-9]{2}[.]{1}[0-9]{3}[.]{1}[0-9]{3})([0-9]*)/g, '$1/$2');
        valor = valor.replace(/([0-9]{2}[.]{1}[0-9]{3}[.]{1}[0-9]{3}[/]{1}[0-9]{4})([0-9]*)/g, '$1-$2');
        return valor;

    }

    @HostListener('blur', ['$event'])
    onBlur($event: any) {

    }

}
