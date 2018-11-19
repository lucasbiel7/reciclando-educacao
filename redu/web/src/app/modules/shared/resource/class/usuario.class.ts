import { Endereco } from './endereco.class';

export class Usuario {

    public id: number;
    public nome: string;
    public email: string;
    public senha: string;
    public endereco: Endereco;
    public imagem: string;
    public administrador: boolean;

    public constructor() {
        this.endereco = new Endereco();
    }
}
