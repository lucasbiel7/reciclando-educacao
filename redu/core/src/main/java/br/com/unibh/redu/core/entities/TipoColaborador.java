package br.com.unibh.redu.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.unibh.redu.core.util.Constante;

@Entity
@Table(name = "tipo_colaborador", schema = Constante.DATABASE)
public class TipoColaborador extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4427549528252073438L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	@Column(name = "tx_descricao")
	private String descricao;

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

}
