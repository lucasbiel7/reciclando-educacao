package br.com.unibh.redu.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.unibh.redu.core.enums.Tamanho;
import br.com.unibh.redu.core.util.Constante;

/**
 * 
 * @author Lucas Gabriel
 *
 */
@Entity
@Table(name = "pessoa_juridica", schema = Constante.DATABASE)
@PrimaryKeyJoinColumn(name = "id_pessoa_juridica", referencedColumnName = "id_colaborador")
public class PessoaJuridica extends Colaborador {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4689044085267487030L;

	@Column(name = "tx_razao_social", nullable = false)
	private String razaoSocial;

	@Column(name = "tx_nome_fantasia", nullable = false)
	private String nomeFantasia;

	@Column(name = "vl_tamanho", nullable = true)
	private Tamanho tamanho;

	@Column(name = "tx_cnpj", nullable = false)
	private String cnpj;

	@Lob
	@Column(name = "banner")
	private String banner;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(Colaborador entity) {
		super(entity);
		setFormacao(entity.getFormacao());
		setExperiencia(entity.getExperiencia());
		setTipoColaborador(entity.getTipoColaborador());
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

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
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
