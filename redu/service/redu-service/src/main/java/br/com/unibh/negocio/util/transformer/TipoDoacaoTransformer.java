package br.com.unibh.negocio.util.transformer;

import br.com.unibh.negocio.dto.TipoDoacaoResource;
import br.com.unibh.negocio.util.BaseTransformer;
import br.com.unibh.redu.core.entities.TipoDoacao;

/**
 * Classe para transformar a entidade tipo doacao para resource e vice e versa
 * 
 * @author Lucas Gabriel
 *
 */
public class TipoDoacaoTransformer implements BaseTransformer<TipoDoacao, TipoDoacaoResource> {

	private static TipoDoacaoTransformer tipoDoacaoTransformer;

	private TipoDoacaoTransformer() {
		super();
	}

	@Override
	public TipoDoacaoResource toResource(TipoDoacao e) {
		if (e == null) {
			return null;
		}
		TipoDoacaoResource r = new TipoDoacaoResource();
		r.setDescricao(e.getDescricao());
		r.setTipoDoacao(toResource(e.getTipoDoacao()));
		r.setId(e.getId());
		return r;
	}

	@Override
	public TipoDoacao toEntity(TipoDoacaoResource r) {
		if (r == null) {
			return null;
		}
		TipoDoacao e = new TipoDoacao();
		e.setDescricao(r.getDescricao());
		e.setTipoDoacao(toEntity(r.getTipoDoacao()));
		e.setId(r.getId());
		return e;
	}

	public static TipoDoacaoTransformer getInstance() {
		if (tipoDoacaoTransformer == null) {
			tipoDoacaoTransformer = new TipoDoacaoTransformer();
		}
		return tipoDoacaoTransformer;
	}

}
