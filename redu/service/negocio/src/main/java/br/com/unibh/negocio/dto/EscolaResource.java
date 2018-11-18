package br.com.unibh.negocio.dto;

public class EscolaResource extends UsuarioResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4976570225326247085L;

	private String nomeEscola;
	private String telefone;
	private String diretor;
	public Long pontuacaoEstrutura;

	public EscolaResource() {
		super();
	}

	public EscolaResource(UsuarioResource resource) {
		super(resource);
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public Long getPontuacaoEstrutura() {
		return pontuacaoEstrutura;
	}

	public void setPontuacaoEstrutura(Long pontuacaoEstrutura) {
		this.pontuacaoEstrutura = pontuacaoEstrutura;
	}

}
