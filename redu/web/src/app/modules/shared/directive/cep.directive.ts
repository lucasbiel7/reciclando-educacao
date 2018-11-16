import { Directive, HostListener, ElementRef } from '@angular/core';
import { NG_VALUE_ACCESSOR, ControlValueAccessor } from '@angular/forms';
import { isFunction } from 'util';

@Directive({
    selector: '[reduCep]',
    providers: [{
        provide: NG_VALUE_ACCESSOR,
        useExisting: CepDirective,
        multi: true
    }]
})
/**
 * Diretiva para utilizar como mascara para o CEP
 * @author Lucas Gabriel
 *
 */
export class CepDirective implements ControlValueAccessor {

    onTouched: any;
    onChange: any;

    constructor(private el: ElementRef) {

    }

    writeValue(value: any): void {
        if (value) {
            this.el.nativeElement.value = this.formatar(value);
        }
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
        if (valor.length > 10) {
            valor = valor.substr(0, 10);
        }
        valor = valor.replace('.', '').replace('-', '').replace(/[^0-9]/, '');
        valor = valor.replace(/([0-9]{2})([0-9]*)/g, '$1.$2');
        valor = valor.replace(/([0-9]{2}[.]{1}[0-9]{3})([0-9]*)/g, '$1-$2');
        return valor;
    }

    @HostListener('blur', ['$event'])
    onBlur($event: any) {

    }

}
