package br.com.unibh.negocio.util.transformer;

import br.com.unibh.negocio.dto.DoacaoResource;
import br.com.unibh.negocio.util.BaseTransformer;
import br.com.unibh.redu.core.entities.Doacao;

public class DoacaoTransformer implements BaseTransformer<Doacao, DoacaoResource> {

	@Override
	public DoacaoResource toResource(Doacao e) {
		if (e == null) {
			return null;
		}
		DoacaoResource r = new DoacaoResource();
		r.setAlocado(e.isAlocado());
		r.setCaracteristica(e.getCaracteristica());
		r.setColaborador(ColaboradorTransformer.getInstance().toResource(e.getColaborador()));
		r.setEndereco(EnderecoTransformer.getInstance().toResource(e.getEndereco()));
		r.setEstadoDoacao(e.getEstadoDoacao().name());
		r.setId(e.getId());

		return r;
	}

	@Override
	public Doacao toEntity(DoacaoResource r) {
		if (r == null) {
			return null;
		}
		Doacao e = new Doacao();

		return e;
	}

}
