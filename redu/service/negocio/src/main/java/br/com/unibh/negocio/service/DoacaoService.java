package br.com.unibh.negocio.service;

import java.util.List;

import javax.ejb.Remote;

import br.com.unibh.negocio.dto.DoacaoResource;

@Remote
public interface DoacaoService {

	public static final String LOOKUP = "ejb:/redu-service/DoacaoBean!br.com.unibh.negocio.service.DoacaoService";

	/**
	 * Retorna lista de doações realizadas
	 * 
	 * @param doacaoResource
	 * @return
	 */
	public List<DoacaoResource> cadastrarDoacao(DoacaoResource doacaoResource);

	/**
	 * Retorna a lista de doações por colaborador
	 * 
	 * @param id
	 * @return
	 */
	public List<DoacaoResource> buscarPorColaborador(Long id);
}
