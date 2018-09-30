package br.com.unibh.redu.core.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.unibh.redu.core.util.Constante;

/**
 * 
 * @author Lucas Gabriel
 *
 */
@Entity
@Table(name = "usuario", schema = Constante.DATABASE)
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7821636893988078538L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario", unique = true, nullable = false)
	private Long id;

	@Column(name = "tx_nome", nullable = false)
	private String nome;

	@Column(name = "tx_usuario", nullable = false)
	private String usuario;

	@Column(name = "tx_senha", nullable = false)
	private String senha;

	@OneToOne(optional = true, cascade = CascadeType.ALL, mappedBy = "usuario")
	private Endereco endereco;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
