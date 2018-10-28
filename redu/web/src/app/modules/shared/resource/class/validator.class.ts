import { FormControl, FormGroup } from '@angular/forms';

export class Validator {

    public static validarCampos(formGroup: FormGroup) {
        Object.keys(formGroup.controls).forEach(chave => {
            const controle = formGroup.get(chave);
            if (controle instanceof FormControl) {
                controle.markAsTouched({ onlySelf: true });
            }
            if (controle instanceof FormGroup) {
                this.validarCampos(controle);
            }
        });
    }
}
