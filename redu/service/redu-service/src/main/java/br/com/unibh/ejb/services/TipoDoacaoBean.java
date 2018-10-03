package br.com.unibh.ejb.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.unibh.dao.TipoDoacaoDAO;
import br.com.unibh.negocio.dto.TipoDoacaoResource;
import br.com.unibh.negocio.service.TipoDoacaoService;
import br.com.unibh.negocio.util.transformer.TipoDoacaoTransformer;

/**
 * Serviços relacionados ao tipo de doação
 * 
 * @author Lucas Gabriel
 *
 */
@Stateless
public class TipoDoacaoBean implements TipoDoacaoService {

	@Inject
	private TipoDoacaoDAO tipoDoacaoDAO;

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<TipoDoacaoResource> buscarTipoDoacao() {
		return tipoDoacaoDAO.buscarTipoDoacao().stream().map(TipoDoacaoTransformer.getInstance()::toResource)
				.collect(Collectors.toList());
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<TipoDoacaoResource> buscarTipoDoacao(Long id) {
		return tipoDoacaoDAO.buscarTipoDoacao(id).stream().map(TipoDoacaoTransformer.getInstance()::toResource)
				.collect(Collectors.toList());
	}

}
