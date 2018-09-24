package br.com.unibh.redu.core.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.unibh.redu.core.entities.id.QuestionarioPerguntaId;
import br.com.unibh.redu.core.util.Constante;

@Entity
@Table(name="questionario_pergunta", schema = Constante.DATABASE)
public class QuestionarioPergunta extends BaseEntity<QuestionarioPerguntaId>{

	private QuestionarioPerguntaId id;
	
}
