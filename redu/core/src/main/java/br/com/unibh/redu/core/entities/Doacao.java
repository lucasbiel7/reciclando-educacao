package br.com.unibh.redu.core.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.unibh.redu.core.enums.EstadoDoacaoEnum;
import br.com.unibh.redu.core.util.Constante;

/**
 * 
 * @author Lucas Gabriel
 *
 */
@Entity
@Table(name = "doacao", schema = Constante.DATABASE)
public class Doacao extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8161905434478770356L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_doacao")
	private Long id;

	@Column(name = "tx_caracteristica")
	private String caracteristica;

	@ManyToOne(targetEntity = TipoDoacao.class, optional = false)
	@JoinColumn(name = "id_tipo_doacao", referencedColumnName = "id_tipo_doacao")
	private TipoDoacao tipoDoacao;

	@ManyToOne(targetEntity = Colaborador.class, optional = false)
	@JoinColumn(name = "id_colaborador", referencedColumnName = "id_colaborador")
	private Colaborador colaborador;

	@Enumerated(EnumType.STRING)
	@Column(name = "vl_estado_doacao", nullable = false)
	private EstadoDoacaoEnum estadoDoacao;

	@Column(name = "vl_revisado", nullable = false)
	public boolean revisado;

	@Column(name = "vl_alocado", nullable = false)
	public boolean alocado;

	@OneToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco", nullable = true)
	private Endereco endereco;

	@ManyToOne(targetEntity = Lote.class, optional = true)
	@JoinColumn(name = "id_lote", referencedColumnName = "id_lote")
	private Lote lote;

	@Column(name = "vl_coletado", nullable = false)
	private boolean coletado;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public TipoDoacao getTipoDoacao() {
		return tipoDoacao;
	}

	public void setTipoDoacao(TipoDoacao tipoDoacao) {
		this.tipoDoacao = tipoDoacao;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public EstadoDoacaoEnum getEstadoDoacao() {
		return estadoDoacao;
	}

	public void setEstadoDoacao(EstadoDoacaoEnum estadoDoacao) {
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public boolean isColetado() {
		return coletado;
	}

	public void setColetado(boolean coletado) {
		this.coletado = coletado;
	}

}
