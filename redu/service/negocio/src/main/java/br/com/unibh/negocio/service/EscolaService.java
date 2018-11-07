package br.com.unibh.negocio.service;

import javax.ejb.Remote;

/**
 * 
 * @author Lucas Gabriel
 *
 */
@Remote
public interface EscolaService {

	public static final String LOOKUP = "ejb:/redu-service/EscolaBean!br.com.unibh.negocio.service.EscolaService";

	/**
	 * Método criado para realizar a leitura do arquivo CSV e carregar as escolas
	 * utilizando conhecimento dos dados do infodados para recuperar informações
	 * importantes sobre as escolas
	 * 
	 * 
	 */
	public void carregarEscolas();
}
