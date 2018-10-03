package br.com.unibh.negocio.util;

/**
 * 
 * Interface base para realizar as transformações dos objetos transacionais para
 * objetos não transacionais
 * 
 * Quando for implementar essa classe deve-se criar uma classe com construtor
 * privado com o metodo getInstance() para recupera a instancia unica da classe
 * 
 * @author Lucas Gabriel
 *
 * @param <E> Entidade transformada
 * @param <R> Resource transformado
 */
public interface BaseTransformer<E, R> {

	R toResource(E e);

	E toEntity(R r);
}
