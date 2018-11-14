export enum TamanhoEnum {
    PEQUENO = 'PEQUENO',
    MEDIO = 'MEDIO',
    GRANDE = 'GRANDE'
}
export namespace TamanhoEnum {
    export function values() {
        return [TamanhoEnum.GRANDE, TamanhoEnum.MEDIO, TamanhoEnum.PEQUENO];
    }

    export function descricao(tipo: TamanhoEnum) {
        switch (tipo) {
            case TamanhoEnum.GRANDE:
                return 'Grande';
            case TamanhoEnum.MEDIO:
                return 'Médio';
            case TamanhoEnum.PEQUENO:
                return 'Pequeno';
        }
    }
}
