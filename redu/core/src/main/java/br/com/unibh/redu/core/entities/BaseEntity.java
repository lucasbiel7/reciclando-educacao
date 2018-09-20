package br.com.unibh.redu.core.entities;

import java.io.Serializable;


/**
 * Classe generica de mapeamento de objeto relacional
 * @author aluno
 *
 * @param <T>
 */
public abstract class BaseEntity<T extends Serializable> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 737855517620780894L;
	
	public abstract void setId(T id);
	public abstract T getId();

}
