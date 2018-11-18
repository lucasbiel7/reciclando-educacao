package br.com.unibh.ejb.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.unibh.dao.EscolaDAO;
import br.com.unibh.negocio.dto.EscolaResource;
import br.com.unibh.negocio.service.EscolaService;
import br.com.unibh.negocio.util.transformer.EscolaTransformer;

@Stateless
public class EscolaBean implements EscolaService {

	@Inject
	private EscolaDAO escolaDAO;

	@Override
	public List<EscolaResource> buscarTodos() {
		return escolaDAO.buscarTodos().stream().map(EscolaTransformer.getInstance()::toResource)
				.collect(Collectors.toList());
	}

	@Override
	public List<EscolaResource> buscarPorNome(String nome) {
		return escolaDAO.buscarPorNome(nome).stream().map(EscolaTransformer.getInstance()::toResource)
				.collect(Collectors.toList());

	}

}
