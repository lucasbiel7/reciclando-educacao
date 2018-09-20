package br.com.unibh.redu.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.unibh.redu.core.util.Constante;

@Entity
@Table(name = "alternativa", schema = Constante.DATABASE)
public class Alternativa extends BaseEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3527356751406997992L;
	@Id
	@GeneratedValue
	@Column(name = "id_alternativa")
	private Long id;

	@Column(name = "txt_alternativa")
	private String textoAlternativa;

	@ManyToOne(targetEntity = Pergunta.class, optional = false)
	@JoinColumn(name = "id_pergunta", referencedColumnName = "id_pergunta")
	private Pergunta pergunta;

	@Column(name = "vl_coeficiente")
	public Double coeficiente;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getTextoAlternativa() {
		return textoAlternativa;
	}

	public void setTextoAlternativa(String textoAlternativa) {
		this.textoAlternativa = textoAlternativa;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(Double coeficiente) {
		this.coeficiente = coeficiente;
	}

}
