package br.com.unibh.negocio.service;

import javax.ejb.Remote;

import br.com.unibh.negocio.dto.DoacaoResource;

@Remote
public interface DoacaoService {

	public static final String LOOKUP = "ejb:/redu-service/DoacaoBean!br.com.unibh.negocio.service.DoacaoService";

	public DoacaoResource cadastrarDoacao(DoacaoResource doacaoResource);
}
