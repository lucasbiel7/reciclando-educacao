package br.com.unibh.redu.core.entities;

import java.io.Serializable;

import br.com.unibh.redu.core.util.ObjectUtil;


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
	
	public abstract T getId();

	public abstract void setId(T id) ;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity<T> other;
		if(obj instanceof BaseEntity) {
			other = ObjectUtil.cast(obj, getClass());
		}else {
			return false;
		}
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
