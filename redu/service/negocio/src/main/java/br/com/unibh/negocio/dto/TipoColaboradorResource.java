package br.com.unibh.negocio.dto;

import br.com.unibh.negocio.util.BaseResponse;

public class TipoColaboradorResource extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1251639623592649858L;

	private Long id;
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
