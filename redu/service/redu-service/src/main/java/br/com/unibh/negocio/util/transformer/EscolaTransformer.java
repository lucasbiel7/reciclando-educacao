package br.com.unibh.negocio.util.transformer;

import br.com.unibh.negocio.dto.EscolaResource;
import br.com.unibh.negocio.util.BaseTransformer;
import br.com.unibh.redu.core.entities.Escola;

public class EscolaTransformer implements BaseTransformer<Escola, EscolaResource> {

	protected EscolaTransformer() {
		super();
	}

	private static EscolaTransformer transformer;

	public static EscolaTransformer getInstance() {
		if (transformer == null) {
			transformer = new EscolaTransformer();
		}
		return transformer;
	}

	@Override
	public EscolaResource toResource(Escola e) {
		if (e == null) {
			return null;
		}
		EscolaResource r = new EscolaResource(UsuarioTransformer.getInstance().toResource(e));
		r.setDiretor(e.getDiretor());
		r.setNomeEscola(e.getNomeEscola());
		r.setPontuacaoEstrutura(e.getPontuacaoEstrutura());
		r.setTelefone(e.getTelefone());
		return r;

	}

	@Override
	public Escola toEntity(EscolaResource r) {
		if (r == null) {
			return null;
		}
		Escola e = new Escola(UsuarioTransformer.getInstance().toEntity(r));
		e.setDiretor(r.getDiretor());
		e.setNomeEscola(r.getNomeEscola());
		e.setPontuacaoEstrutura(r.getPontuacaoEstrutura());
		e.setTelefone(r.getTelefone());
		return e;
	}

}
