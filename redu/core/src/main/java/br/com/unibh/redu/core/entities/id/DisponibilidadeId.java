package br.com.unibh.redu.core.entities.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.unibh.redu.core.entities.Colaborador;
import br.com.unibh.redu.core.enums.DiaSemana;

/**
 * 
 * @author Lucas Gabriel
 *
 */
@Embeddable
public class DisponibilidadeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8249050249285782367L;

	@ManyToOne(targetEntity = Colaborador.class, optional = false)
	@JoinColumn(name = "id_colaborador", referencedColumnName = "id")
	private Colaborador colaborador;
	@Column(name = "dia_semana", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private DiaSemana diaSemana;

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colaborador == null) ? 0 : colaborador.hashCode());
		result = prime * result + ((diaSemana == null) ? 0 : diaSemana.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisponibilidadeId other = (DisponibilidadeId) obj;
		if (colaborador == null) {
			if (other.colaborador != null)
				return false;
		} else if (!colaborador.equals(other.colaborador))
			return false;
		if (diaSemana != other.diaSemana)
			return false;
		return true;
	}

}
