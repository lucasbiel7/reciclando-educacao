package br.com.unibh.negocio.service;

import java.util.List;

import javax.ejb.Remote;

import br.com.unibh.negocio.dto.EscolaResource;

/**
 * 
 * @author lucas
 *
 */
@Remote
public interface EscolaService {
	public static final String LOOKUP = "ejb:/redu-service/EscolaBean!br.com.unibh.negocio.service.EscolaService";

	/**
	 * Método criado para buscar todas as escolas da aplicação
	 * 
	 * 
	 * @return
	 */
	public List<EscolaResource> buscarTodos();

	/**
	 * Filtra as escolas por nome
	 * 
	 * @param nome
	 * @return
	 */
	public List<EscolaResource> buscarPorNome(String nome);
}
