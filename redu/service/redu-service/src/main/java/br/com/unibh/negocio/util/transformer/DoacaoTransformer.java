package br.com.unibh.negocio.util.transformer;

import br.com.unibh.negocio.dto.DoacaoResource;
import br.com.unibh.negocio.util.BaseTransformer;
import br.com.unibh.redu.core.entities.Doacao;
import br.com.unibh.redu.core.enums.EstadoDoacaoEnum;

public class DoacaoTransformer implements BaseTransformer<Doacao, DoacaoResource> {

	protected DoacaoTransformer() {
		super();

	}

	private static DoacaoTransformer transformer;

	public static DoacaoTransformer getInstance() {
		if (transformer == null) {
			transformer = new DoacaoTransformer();
		}
		return transformer;
	}

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
		r.setLote(LoteTransformer.getInstance().toResource(e.getLote()));
		r.setRevisado(e.isRevisado());
		r.setTipoDoacao(TipoDoacaoTransformer.getInstance().toResource(e.getTipoDoacao()));
		return r;
	}

	@Override
	public Doacao toEntity(DoacaoResource r) {
		if (r == null) {
			return null;
		}
		Doacao e = new Doacao();
		e.setAlocado(r.isAlocado());
		e.setCaracteristica(r.getCaracteristica());
		e.setColaborador(ColaboradorTransformer.getInstance().toEntity(r.getColaborador()));
		e.setEndereco(EnderecoTransformer.getInstance().toEntity(r.getEndereco()));
		e.setEstadoDoacao(EstadoDoacaoEnum.getEstadoDoacao(r.getEstadoDoacao()));
		e.setId(r.getId());
		e.setLote(LoteTransformer.getInstance().toEntity(r.getLote()));
		e.setRevisado(r.isRevisado());
		e.setTipoDoacao(TipoDoacaoTransformer.getInstance().toEntity(r.getTipoDoacao()));
		return e;
	}

}
