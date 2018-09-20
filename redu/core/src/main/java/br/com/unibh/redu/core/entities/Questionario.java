package br.com.unibh.redu.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.unibh.redu.core.util.Constante;

@Entity
@Table(name = "questionario", schema = Constante.DATABASE)
public class Questionario extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4147892705581288036L;

	@Id
	@Column(name = "id_questionario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
