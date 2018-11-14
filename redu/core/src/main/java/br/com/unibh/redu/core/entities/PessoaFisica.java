package br.com.unibh.redu.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.unibh.redu.core.util.Constante;

/**
 * 
 * @author Lucas Gabriel
 *
 */
@Entity
@Table(name = "pessoa_fisica", schema = Constante.DATABASE)
@PrimaryKeyJoinColumn(name = "id_pessoa_fisica", referencedColumnName = "id_colaborador")
public class PessoaFisica extends Colaborador {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1315122490496333654L;

	@Column(name = "tx_cpf")
	private String cpf;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(Colaborador colaborador) {
		super(colaborador);
		setFormacao(colaborador.getFormacao());
		setExperiencia(colaborador.getExperiencia());
		setTipoColaborador(colaborador.getTipoColaborador());
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
