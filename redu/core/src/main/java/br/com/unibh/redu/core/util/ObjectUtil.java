package br.com.unibh.redu.core.util;

/**
 * Utilitarios para trabalhar com objeto
 * 
 * @author lgdutra1
 *
 */
public class ObjectUtil {

	
	public static <T> T cast(Object object, Class<T> classe) {
		return classe.cast(object);
	}
}
