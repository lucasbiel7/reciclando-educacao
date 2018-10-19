package br.com.unibh.negocio.dto;

import br.com.unibh.negocio.util.BaseResponse;

public class Credencial extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3595660641156961515L;

	private String email;
	private String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
