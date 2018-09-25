package br.com.unibh.redu.core.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.unibh.redu.core.entities.id.QuestionarioPerguntaId;
import br.com.unibh.redu.core.util.Constante;

@Entity
@Table(name = "questionario_pergunta", schema = Constante.DATABASE)
public class QuestionarioPergunta extends BaseEntity<QuestionarioPerguntaId> {

	@EmbeddedId
	private QuestionarioPerguntaId id;

	@Override
	public QuestionarioPerguntaId getId() {
		return id;
	}

	@Override
	public void setId(QuestionarioPerguntaId id) {
		this.id = id;
	}

}
