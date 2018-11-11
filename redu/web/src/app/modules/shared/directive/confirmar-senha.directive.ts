import { Directive, Input } from '@angular/core';
import { NG_VALIDATORS, Validator, AbstractControl, ValidationErrors } from '@angular/forms';
import { Subscription } from 'rxjs/Subscription';

@Directive({
    selector: '[reduConfirmarSenha]',
    providers: [{
        provide: NG_VALIDATORS,
        useExisting: ConfirmarSenhaDirective,
        multi: true
    }]
})
export class ConfirmarSenhaDirective implements Validator {
    @Input('reduConfirmarSenha')
    reduConfirmarSenha;

    constructor() { }

    validate(c: AbstractControl): ValidationErrors {
        if (c.value === null || c.value.lenght === 0) {
            return null;
        }
        const controlToCompare = c.root.get(this.reduConfirmarSenha);
        if (controlToCompare) {
            const subscription: Subscription = controlToCompare.valueChanges.subscribe(() => {
                c.updateValueAndValidity();
                subscription.unsubscribe();
            });
        }
        return controlToCompare && controlToCompare.value !== c.value ? { 'confirmPassword': true } : null;
    }

    registerOnValidatorChange?(fn: () => void): void {

    }

}
