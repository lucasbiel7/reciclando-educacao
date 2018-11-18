package br.com.unibh.negocio.dto;

import br.com.unibh.negocio.util.BaseResponse;

public class DoacaoResource extends BaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2142030728415171693L;

	private Long id;
	private Integer quantidade;
	private String caracteristica;
	private TipoDoacaoResource tipoDoacao;
	private ColaboradorResource colaborador;
	private String estadoDoacao;
	public boolean revisado;
	public boolean alocado;
	private EnderecoResource endereco;
	private LoteResource lote;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public TipoDoacaoResource getTipoDoacao() {
		return tipoDoacao;
	}

	public void setTipoDoacao(TipoDoacaoResource tipoDoacao) {
		this.tipoDoacao = tipoDoacao;
	}

	public ColaboradorResource getColaborador() {
		return colaborador;
	}

	public void setColaborador(ColaboradorResource colaborador) {
		this.colaborador = colaborador;
	}

	public String getEstadoDoacao() {
		return estadoDoacao;
	}

	public void setEstadoDoacao(String estadoDoacao) {
		this.estadoDoacao = estadoDoacao;
	}

	public boolean isRevisado() {
		return revisado;
	}

	public void setRevisado(boolean revisado) {
		this.revisado = revisado;
	}

	public boolean isAlocado() {
		return alocado;
	}

	public void setAlocado(boolean alocado) {
		this.alocado = alocado;
	}

	public EnderecoResource getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoResource endereco) {
		this.endereco = endereco;
	}

	public LoteResource getLote() {
		return lote;
	}

	public void setLote(LoteResource lote) {
		this.lote = lote;
	}

}
