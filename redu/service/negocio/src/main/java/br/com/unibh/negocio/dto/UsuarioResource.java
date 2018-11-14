package br.com.unibh.negocio.dto;

import br.com.unibh.negocio.util.BaseResponse;

public class UsuarioResource extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2728692172109967758L;

	private Long id;

	private String nome;

	private String email;

	private String senha;

	private String imagem;

	private EnderecoResource endereco;

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

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public EnderecoResource getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoResource endereco) {
		this.endereco = endereco;
	}

}
