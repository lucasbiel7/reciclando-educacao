package br.com.unibh.ejb.services;

import javax.ejb.Stateless;

import br.com.unibh.negocio.dto.DoacaoResource;
import br.com.unibh.negocio.service.DoacaoService;

@Stateless
public class DoacaoBean implements DoacaoService {

	@Override
	public DoacaoResource cadastrarDoacao(DoacaoResource doacaoResource) {
		return null;
	}

}
