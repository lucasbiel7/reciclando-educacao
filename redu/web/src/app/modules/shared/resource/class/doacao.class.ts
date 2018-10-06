import { TipoDoacao } from './../interfaces/tipo-doacao.interface';
import { EstadoDoacaoEnum } from '../enum/estado-doacao.enum';

export class Doacao {
    public id: number;
    public quantidade: number;
    public caracteristica: string;
    public tipoDoacao: TipoDoacao;
    public colaborador: any;
    public estadoDoacao: EstadoDoacaoEnum;
    public revisado: boolean;
    public alocado: boolean;
}
