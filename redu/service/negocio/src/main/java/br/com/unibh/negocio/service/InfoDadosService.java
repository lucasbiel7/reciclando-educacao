package br.com.unibh.negocio.service;

import javax.ejb.Remote;

/**
 * 
 * @author Lucas Gabriel
 *
 */
@Remote
public interface InfoDadosService {

	public static final String LOOKUP = "ejb:/redu-service/InfoDadosBean!br.com.unibh.negocio.service.InfoDadosService";

	/**
	 * Método criado para realizar a leitura do arquivo CSV e carregar as escolas
	 * utilizando conhecimento dos dados do infodados para recuperar informações
	 * importantes sobre as escolas
	 * 
	 * 
	 */
	public void carregarEscolas();

}
