package br.com.unibh.redu.core.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.unibh.redu.core.util.Constante;

/**
 * 
 * @author Lucas Gabriel
 *
 */
@Entity
@Table(name = "questionario", schema = Constante.DATABASE)
public class Questionario extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4147892705581288036L;

	@Id
	@Column(name = "id_questionario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@ManyToOne(targetEntity = Lote.class, optional = false)
	@JoinColumn(name = "id_lote", referencedColumnName = "id_lote")
	private Lote lote;

	@ManyToOne(targetEntity = Escola.class, optional = false)
	@JoinColumn(name = "id_escola", referencedColumnName = "id_escola")
	private Escola escola;

	@Column(name = "tx_descricao", nullable = true)
	private String descricao;

	@Column(name = "dt_realizado", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date realizado;

	@Column(name = "vl_concluido")
	private boolean concluido;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getRealizado() {
		return realizado;
	}

	public void setRealizado(Date realizado) {
		this.realizado = realizado;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
