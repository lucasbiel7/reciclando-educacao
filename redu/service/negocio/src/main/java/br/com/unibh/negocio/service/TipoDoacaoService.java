package br.com.unibh.negocio.service;

import java.util.List;

import javax.ejb.Remote;

import br.com.unibh.negocio.dto.TipoDoacaoResource;

/**
 * Servico EJB para recuperar os tipos de doações
 * 
 * @author Lucas Gabriel
 *
 */
@Remote
public interface TipoDoacaoService {

	public static final String LOOKUP = "ejb:/redu-service/TipoDoacaoBean!br.com.unibh.negocio.service.TipoDoacaoService";

	/**
	 * Método para buscar todos os tipos de doações que não possuem pai
	 * 
	 * @return Lista dos tipos de doaçoes
	 */
	List<TipoDoacaoResource> buscarTipoDoacao();

	/**
	 * Buscar tipos de doações pelo pai
	 * 
	 * 
	 * @param id
	 * @return Lista de tipos de doação filho
	 * 
	 */
	List<TipoDoacaoResource> buscarTipoDoacao(Long id);

}
