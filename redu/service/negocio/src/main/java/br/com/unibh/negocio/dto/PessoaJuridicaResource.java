package br.com.unibh.negocio.dto;

public class PessoaJuridicaResource extends ColaboradorResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4138205494579829369L;
	private String razaoSocial;

	private String nomeFantasia;

	private String tamanho;

	private String banner;

	private String cnpj;

	public PessoaJuridicaResource() {
		super();
	}

	public PessoaJuridicaResource(ColaboradorResource resource) {
		super(resource);
		setFormacao(resource.getFormacao());
		setExperiencia(resource.getExperiencia());
		setTipoColaborador(resource.getTipoColaborador());
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
