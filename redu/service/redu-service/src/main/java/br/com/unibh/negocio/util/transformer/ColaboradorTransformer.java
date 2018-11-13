package br.com.unibh.negocio.util.transformer;

import br.com.unibh.negocio.dto.ColaboradorResource;
import br.com.unibh.negocio.util.BaseTransformer;
import br.com.unibh.redu.core.entities.Colaborador;

public class ColaboradorTransformer implements BaseTransformer<Colaborador, ColaboradorResource> {

	protected ColaboradorTransformer() {
		super();

	}

	private static ColaboradorTransformer colaboradorTransformer;

	public static ColaboradorTransformer getInstance() {
		if (colaboradorTransformer == null) {
			colaboradorTransformer = new ColaboradorTransformer();
		}
		return colaboradorTransformer;
	}

	@Override
	public ColaboradorResource toResource(Colaborador e) {
		if (e == null) {
			return null;
		}
		ColaboradorResource r = new ColaboradorResource(UsuarioTransformer.getInstance().toResource(e));
		r.setFormacao(e.getFormacao());
		r.setExperiencia(e.getExperiencia());
		r.setTipoColaborador(TipoColaboradorTransformer.getInstance().toResource(e.getTipoColaborador()));
		return r;
	}

	@Override
	public Colaborador toEntity(ColaboradorResource r) {
		if (r == null) {
			return null;
		}
		Colaborador e = new Colaborador(UsuarioTransformer.getInstance().toEntity(r));
		e.setFormacao(r.getFormacao());
		e.setExperiencia(r.getExperiencia());
		e.setTipoColaborador(TipoColaboradorTransformer.getInstance().toEntity(r.getTipoColaborador()));
		return e;
	}

}
