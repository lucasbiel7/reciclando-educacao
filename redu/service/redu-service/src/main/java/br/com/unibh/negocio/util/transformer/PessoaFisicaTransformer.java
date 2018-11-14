package br.com.unibh.negocio.util.transformer;

import br.com.unibh.negocio.dto.PessoaFisicaResource;
import br.com.unibh.negocio.util.BaseTransformer;
import br.com.unibh.redu.core.entities.PessoaFisica;

public class PessoaFisicaTransformer implements BaseTransformer<PessoaFisica, PessoaFisicaResource> {

	protected PessoaFisicaTransformer() {
		super();

	}

	private static PessoaFisicaTransformer pessoaFisicaTransformer;

	public static PessoaFisicaTransformer getInstance() {
		if (pessoaFisicaTransformer == null) {
			pessoaFisicaTransformer = new PessoaFisicaTransformer();
		}
		return pessoaFisicaTransformer;
	}

	@Override
	public PessoaFisicaResource toResource(PessoaFisica e) {
		if (e == null) {
			return null;
		}
		PessoaFisicaResource r = new PessoaFisicaResource(ColaboradorTransformer.getInstance().toResource(e));
		r.setCpf(e.getCpf());
		return r;
	}

	@Override
	public PessoaFisica toEntity(PessoaFisicaResource r) {
		if (r == null) {
			return null;
		}
		PessoaFisica e = new PessoaFisica(ColaboradorTransformer.getInstance().toEntity(r));
		e.setCpf(r.getCpf());
		return e;
	}

}
