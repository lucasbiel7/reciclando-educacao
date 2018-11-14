package br.com.unibh.negocio.service;

import java.util.List;

import javax.ejb.Remote;

import br.com.unibh.negocio.dto.ColaboradorResource;
import br.com.unibh.negocio.dto.TipoColaboradorResource;
import br.com.unibh.negocio.exceptions.EmailExistenteException;

@Remote
public interface ColaboradorService {

	public static final String LOOKUP = "ejb:/redu-service/ColaboradorBean!br.com.unibh.negocio.service.ColaboradorService";

	/**
	 * Retorna todos os tipos de colaboradores
	 * 
	 * @return
	 */
	List<TipoColaboradorResource> pegarTiposDeColaboradores();

	void cadastrar(ColaboradorResource colaboradorResource) throws EmailExistenteException;

}
