package br.com.unibh.redu.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.unibh.redu.core.util.Constante;

/**
 * 
 * @author Lucas Gabriel
 *
 */
@Entity
@Table(name = "escola", schema = Constante.DATABASE)
public class Escola extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -414771552198251994L;
	@Id
	@Column(name = "id_escola")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "txt_email")
	private String email;
	@Column(name = "txt_nome")
	private String nome;
	@Column(name = "txt_telefone")
	private String telefone;
	@Column(name = "txt_diretor")
	private String diretor;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
