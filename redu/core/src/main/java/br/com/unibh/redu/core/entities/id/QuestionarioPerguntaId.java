package br.com.unibh.redu.core.entities.id;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.unibh.redu.core.entities.Pergunta;
import br.com.unibh.redu.core.entities.Questionario;


/**
 * 
 * @author Lucas Gabriel
 *
 */
@Embeddable
public class QuestionarioPerguntaId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3775227023341675875L;

	@ManyToOne(targetEntity = Questionario.class, optional = false)
	@JoinColumn(name = "id_questionario", referencedColumnName = "id_questionario")
	private Questionario questionario;
	@ManyToOne(targetEntity = Pergunta.class, optional = false)
	@JoinColumn(name = "id_pergunta", referencedColumnName = "id_pergunta")
	private Pergunta pergunta;

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pergunta == null) ? 0 : pergunta.hashCode());
		result = prime * result + ((questionario == null) ? 0 : questionario.hashCode());
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
		QuestionarioPerguntaId other = (QuestionarioPerguntaId) obj;
		if (pergunta == null) {
			if (other.pergunta != null)
				return false;
		} else if (!pergunta.equals(other.pergunta))
			return false;
		if (questionario == null) {
			if (other.questionario != null)
				return false;
		} else if (!questionario.equals(other.questionario))
			return false;
		return true;
	}

}
