package br.com.unibh.redu.core.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.unibh.redu.core.entities.id.DisponibilidadeId;
import br.com.unibh.redu.core.util.Constante;

@Entity
@Table(name = "disponibilidade", schema = Constante.DATABASE)
public class Disponibilidade extends BaseEntity<DisponibilidadeId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2142231104949997238L;

	@EmbeddedId
	private DisponibilidadeId id;
	@Column(name = "vl_horas", nullable = false)
	private Integer horas;

	@Override
	public DisponibilidadeId getId() {
		return id;
	}

	@Override
	public void setId(DisponibilidadeId id) {
		this.id = id;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

}
