package br.com.unibh.negocio.util.transformer;

import br.com.unibh.negocio.dto.LoteResource;
import br.com.unibh.negocio.util.BaseTransformer;
import br.com.unibh.redu.core.entities.Lote;

public class LoteTransformer implements BaseTransformer<Lote, LoteResource> {

	protected LoteTransformer() {
		super();

	}

	private static LoteTransformer transformer;

	public static LoteTransformer getInstance() {
		if (transformer == null) {
			transformer = new LoteTransformer();
		}
		return transformer;
	}

	@Override
	public LoteResource toResource(Lote e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lote toEntity(LoteResource r) {
		// TODO Auto-generated method stub
		return null;
	}
}
