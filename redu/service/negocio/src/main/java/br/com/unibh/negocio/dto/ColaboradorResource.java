package br.com.unibh.negocio.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ColaboradorResource extends UsuarioResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8114045454250806225L;

	private String formacao;

	private String experiencia;

	private TipoColaboradorResource tipoColaborador;

	public ColaboradorResource() {

	}

	public ColaboradorResource(UsuarioResource r) {
		super(r);
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public TipoColaboradorResource getTipoColaborador() {
		return tipoColaborador;
	}

	public void setTipoColaborador(TipoColaboradorResource tipoColaborador) {
		this.tipoColaborador = tipoColaborador;
	}

}
