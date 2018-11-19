export enum EstadoDoacaoEnum {
    NOVO = 'Novo',
    USADO = 'Usado',
    COM_DEFEITO = 'Com defeito',
}

export namespace EstadoDoacaoEnum {

    export function valueOf(value: string) {
        switch (value) {
            case 'NOVO':
                return EstadoDoacaoEnum.NOVO;
            case 'USADO':
                return EstadoDoacaoEnum.USADO;
            case 'COM_DEFEITO':
                return EstadoDoacaoEnum.COM_DEFEITO;
        }
    }
}
