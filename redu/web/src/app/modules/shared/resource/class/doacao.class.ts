import { TipoDoacao } from './../interfaces/tipo-doacao.interface';
import { EstadoDoacaoEnum } from '../enum/estado-doacao.enum';
import { Endereco } from './endereco.class';
import { Colaborador } from './colaborador.class';

export class Doacao {
    public id: number;
    public quantidade: number;
    public caracteristica: string;
    public tipoDoacao: TipoDoacao;
    public colaborador: Colaborador;
    public estadoDoacao: EstadoDoacaoEnum;
    public revisado: boolean;
    public alocado: boolean;
    public endereco: Endereco;

    constructor() {
        this.endereco = new Endereco();
    }
}
