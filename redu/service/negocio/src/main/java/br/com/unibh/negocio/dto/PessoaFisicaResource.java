package br.com.unibh.negocio.dto;

public class PessoaFisicaResource extends ColaboradorResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4649611737255737360L;

	private String cpf;

	public PessoaFisicaResource() {
		super();
	}

	public PessoaFisicaResource(ColaboradorResource colaborador) {
		super(colaborador);
		setFormacao(colaborador.getFormacao());
		setExperiencia(colaborador.getExperiencia());
		setTipoColaborador(colaborador.getTipoColaborador());
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
