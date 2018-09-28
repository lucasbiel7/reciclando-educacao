package br.com.unibh.redu.core.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.unibh.redu.core.util.Constante;

@Entity
@Table(name="pessoa_juridica",schema = Constante.DATABASE)
@PrimaryKeyJoinColumn(name="id" ,referencedColumnName="id")
public class PessoaJuridica extends Colaborador{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4689044085267487030L;
	

}
