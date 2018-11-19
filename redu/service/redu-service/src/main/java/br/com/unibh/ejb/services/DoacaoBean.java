package br.com.unibh.ejb.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.unibh.dao.DoacaoDAO;
import br.com.unibh.negocio.dto.DoacaoResource;
import br.com.unibh.negocio.service.DoacaoService;
import br.com.unibh.negocio.util.transformer.DoacaoTransformer;
import br.com.unibh.redu.core.entities.Doacao;

@Stateless
public class DoacaoBean implements DoacaoService {

	@Inject
	private DoacaoDAO doacaoDAO;

	@Override
	public List<DoacaoResource> cadastrarDoacao(DoacaoResource doacaoResource) {
		List<DoacaoResource> doacoes = new ArrayList<>();
		for (int i = 0; i < doacaoResource.getQuantidade(); i++) {
			Doacao doacao = DoacaoTransformer.getInstance().toEntity(doacaoResource);
			doacao = doacaoDAO.salvar(doacao);
			doacoes.add(DoacaoTransformer.getInstance().toResource(doacao));
		}
		return doacoes;
	}

	@Override
	public List<DoacaoResource> buscarPorColaborador(Long id) {
		return doacaoDAO.buscarPorColaborador(id).stream().map(DoacaoTransformer.getInstance()::toResource)
				.collect(Collectors.toList());
	}

}
