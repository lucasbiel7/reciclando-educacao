package br.com.unibh.negocio.dto;

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
		setId(r.getId());
		setNome(r.getNome());
		setSenha(r.getSenha());
		setEmail(r.getEmail());
		setImagem(r.getImagem());
		setEndereco(r.getEndereco());
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
