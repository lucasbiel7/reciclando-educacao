import { Colaborador } from './colaborador.class';
import { TamanhoEnum } from '../enum/tamanho.enum';

export class PessoaJuridica extends Colaborador {
    public cnpj: string;
    public razaoSocial: string;
    public nomeFantasia: string;
    public tamanho: TamanhoEnum;
}
