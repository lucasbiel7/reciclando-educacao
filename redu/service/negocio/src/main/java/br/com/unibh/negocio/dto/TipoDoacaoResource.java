package br.com.unibh.negocio.dto;

import br.com.unibh.negocio.util.BaseResponse;

public class TipoDoacaoResource extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6720580778646140444L;

	private Long id;

	private String descricao;

	private TipoDoacaoResource tipoDoacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoDoacaoResource getTipoDoacao() {
		return tipoDoacao;
	}

	public void setTipoDoacao(TipoDoacaoResource tipoDoacao) {
		this.tipoDoacao = tipoDoacao;
	}

}
