export enum TipoPessoaEnum {
    FISICA = 'Físico', JURIDICA = 'Jurídico'
}
export namespace TipoPessoaEnum {
    export function values() {
        return [TipoPessoaEnum.FISICA, TipoPessoaEnum.JURIDICA];
    }
}
