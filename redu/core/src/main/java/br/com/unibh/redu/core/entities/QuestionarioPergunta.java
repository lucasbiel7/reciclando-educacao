package br.com.unibh.redu.core.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.unibh.redu.core.entities.id.QuestionarioPerguntaId;
import br.com.unibh.redu.core.util.Constante;

/**
 * 
 * @author Lucas Gabriel
 *
 */
@Entity
@Table(name = "questionario_pergunta", schema = Constante.DATABASE)
public class QuestionarioPergunta extends BaseEntity<QuestionarioPerguntaId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1124985551271003352L;

	@EmbeddedId
	private QuestionarioPerguntaId id;

	@ManyToOne(targetEntity = Alternativa.class, optional = true)
	@Column(name = "id_alternativa", nullable = true)
	private Alternativa alternativa;

	@Override
	public QuestionarioPerguntaId getId() {
		return id;
	}

	@Override
	public void setId(QuestionarioPerguntaId id) {
		this.id = id;
	}

}
