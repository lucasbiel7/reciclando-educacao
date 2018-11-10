package br.com.unibh.ejb.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.unibh.dao.TipoColaboradorDAO;
import br.com.unibh.negocio.dto.TipoColaboradorResource;
import br.com.unibh.negocio.service.ColaboradorService;
import br.com.unibh.negocio.util.transformer.TipoColaboradorTransformer;

/**
 * 
 * @author Lucas Gabriel
 *
 */
@Stateless
public class ColaboradorBean implements ColaboradorService {

	@Inject
	private TipoColaboradorDAO tipoColaboradorDAO;

	@Override
	public List<TipoColaboradorResource> pegarTiposDeColaboradores() {
		return tipoColaboradorDAO.buscarTipoColaborador().stream()
				.map(TipoColaboradorTransformer.getInstance()::toResource).collect(Collectors.toList());
	}

}
