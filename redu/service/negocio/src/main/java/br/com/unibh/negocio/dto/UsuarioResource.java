package br.com.unibh.negocio.dto;

import br.com.unibh.negocio.util.BaseResponse;

public class UsuarioResource extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2728692172109967758L;

	private Long id;

	private String nome;

	private String usuario;

	private String senha;

	public Long getId() {
		return id;
	}

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
