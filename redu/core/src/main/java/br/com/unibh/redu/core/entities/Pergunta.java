package br.com.unibh.redu.core.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.unibh.redu.core.util.Constante;

@Entity
@Table(name = "pergunta", schema = Constante.DATABASE)
public class Pergunta extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1715379740980180800L;

	@Id
	@Column(name = "id_pergunta")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "txt_pergunta")
	private String textoPergunta;

	@OneToMany(mappedBy = "pergunta")
	private Set<Alternativa> alternativas;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getTextoPergunta() {
		return textoPergunta;
	}

	public void setTextoPergunta(String textoPergunta) {
		this.textoPergunta = textoPergunta;
	}

}
