package br.com.unibh.redu.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.unibh.redu.core.util.Constante;

@Entity
@Table(name = "lote", schema = Constante.DATABASE)
public class Lote extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4109500868249250925L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_lote")
	private Long id;

	@ManyToOne(targetEntity = TipoDoacao.class, optional = false)
	@JoinColumn(name = "id_tipo_doacao", referencedColumnName = "id_tipo_doacao")
	private TipoDoacao tipoDoacao;

	@ManyToOne(targetEntity = Escola.class, optional = true)
	@JoinColumn(name = "id_escola", referencedColumnName = "")
	private Escola escola;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public TipoDoacao getTipoDoacao() {
		return tipoDoacao;
	}

	public void setTipoDoacao(TipoDoacao tipoDoacao) {
		this.tipoDoacao = tipoDoacao;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

}
