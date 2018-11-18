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
@Table(name = "escola", schema = Constante.DATABASE)
@PrimaryKeyJoinColumn(name = "id_escola", referencedColumnName = "id_usuario")
public class Escola extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = -414771552198251994L;

	@Column(name = "txt_nome_escola")
	private String nomeEscola;
	@Column(name = "txt_telefone")
	private String telefone;
	@Column(name = "txt_diretor")
	private String diretor;
	@Column(name = "vl_pontuacao_infra")
	public Long pontuacaoEstrutura;

	public Escola() {
		super();
	}

	public Escola(Usuario usuario) {
		super(usuario);
	}

	public Long getPontuacaoEstrutura() {
		return pontuacaoEstrutura;
	}

	public void setPontuacaoEstrutura(Long pontuacaoEstrutura) {
		this.pontuacaoEstrutura = pontuacaoEstrutura;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

}
