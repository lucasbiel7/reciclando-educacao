package br.com.unibh.negocio.util.transformer;

import br.com.unibh.negocio.dto.TipoColaboradorResource;
import br.com.unibh.negocio.util.BaseTransformer;
import br.com.unibh.redu.core.entities.TipoColaborador;

public class TipoColaboradorTransformer implements BaseTransformer<TipoColaborador, TipoColaboradorResource> {

	protected TipoColaboradorTransformer() {
		super();
	}

	private static TipoColaboradorTransformer tipoColaboradorTransformer;

	public static TipoColaboradorTransformer getInstance() {
		if (tipoColaboradorTransformer == null) {
			tipoColaboradorTransformer = new TipoColaboradorTransformer();
		}
		return tipoColaboradorTransformer;
	}

	@Override
	public TipoColaboradorResource toResource(TipoColaborador e) {
		if (e == null) {
			return null;
		}
		TipoColaboradorResource r = new TipoColaboradorResource();
		r.setDescricao(e.getDescricao());
		r.setId(e.getId());
		return r;
	}

	@Override
	public TipoColaborador toEntity(TipoColaboradorResource r) {
		if (r == null) {
			return null;
		}
		TipoColaborador e = new TipoColaborador();
		e.setDescricao(r.getDescricao());
		e.setId(r.getId());
		return e;
	}

}
