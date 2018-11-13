package br.com.unibh.negocio.util.transformer;

import br.com.unibh.negocio.dto.EnderecoResource;
import br.com.unibh.negocio.util.BaseTransformer;
import br.com.unibh.redu.core.entities.Endereco;

public class EnderecoTransformer implements BaseTransformer<Endereco, EnderecoResource> {

	protected EnderecoTransformer() {
		super();
	}

	private static EnderecoTransformer enderecoTransformer;

	public static EnderecoTransformer getInstance() {
		if (enderecoTransformer == null) {
			enderecoTransformer = new EnderecoTransformer();
		}
		return enderecoTransformer;
	}

	@Override
	public EnderecoResource toResource(Endereco e) {
		if (e == null) {
			return null;
		}
		EnderecoResource r = new EnderecoResource();
		r.setId(e.getId());
		r.setBairro(e.getBairro());
		r.setCep(e.getCep());
		r.setLogradouro(e.getLogradouro());
		r.setMunicipio(e.getMunicipio());
		r.setNumero(e.getNumero());
		r.setUf(e.getUf());
		return r;
	}

	@Override
	public Endereco toEntity(EnderecoResource r) {
		if (r == null) {
			return null;
		}
		Endereco e = new Endereco();
		e.setId(r.getId());
		e.setBairro(r.getBairro());
		e.setCep(r.getCep());
		e.setLogradouro(r.getLogradouro());
		e.setMunicipio(r.getMunicipio());
		e.setNumero(r.getNumero());
		e.setUf(r.getUf());
		return e;
	}

}
