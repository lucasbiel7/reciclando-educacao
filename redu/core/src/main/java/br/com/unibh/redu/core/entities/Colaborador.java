package br.com.unibh.redu.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.unibh.redu.core.util.Constante;

/**
 * 
 * @author Lucas Gabriel
 *
 */
@Entity
@Table(name = "colaborador", schema = Constante.DATABASE)
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class Colaborador extends Usuario {

	/**
	* 
	*/
	private static final long serialVersionUID = 3804358778171401213L;

	@Column(name = "tx_formacao", nullable = true)
	private String formacao;
	@Column(name = "tx_experiencia", nullable = true)
	private String experiencia;
	@ManyToOne(targetEntity = TipoColaborador.class, optional = false)
	@JoinColumn(name = "id_tipo_colaborador", referencedColumnName = "id")
	private TipoColaborador tipoColaborador;

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public TipoColaborador getTipoColaborador() {
		return tipoColaborador;
	}

	public void setTipoColaborador(TipoColaborador tipoColaborador) {
		this.tipoColaborador = tipoColaborador;
	}

}
