import { TipoColaborador } from './tipo-colaborador.class';
import { Usuario } from './usuario.class';

export class Colaborador extends Usuario {

    public formacao: string;
    public experiencia: string;
    public tipoColaborador: TipoColaborador;

}
