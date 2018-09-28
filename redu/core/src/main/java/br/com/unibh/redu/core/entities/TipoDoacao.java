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
@Table(name = "tipo_doacao", schema = Constante.DATABASE)
public class TipoDoacao extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4754441299501089578L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipo_doacao")
	private Long id;

	@Column(name = "tx_descricao", nullable = false)
	private String descricao;

	@ManyToOne(targetEntity = TipoDoacao.class, optional = true)
	@JoinColumn(name = "id_tipo_doacao", referencedColumnName = "id_tipo_doacao")
	private TipoDoacao tipoDoacao;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoDoacao getTipoDoacao() {
		return tipoDoacao;
	}

	public void setTipoDoacao(TipoDoacao tipoDoacao) {
		this.tipoDoacao = tipoDoacao;
	}

}
