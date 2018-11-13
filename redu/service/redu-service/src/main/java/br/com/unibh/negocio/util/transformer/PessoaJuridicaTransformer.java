package br.com.unibh.negocio.util.transformer;

import br.com.unibh.negocio.dto.PessoaJuridicaResource;
import br.com.unibh.negocio.util.BaseTransformer;
import br.com.unibh.redu.core.entities.PessoaJuridica;
import br.com.unibh.redu.core.enums.Tamanho;

public class PessoaJuridicaTransformer implements BaseTransformer<PessoaJuridica, PessoaJuridicaResource> {

	protected PessoaJuridicaTransformer() {
		super();

	}

	private static PessoaJuridicaTransformer pessoaJuridicaTransformer;

	public static PessoaJuridicaTransformer getInstance() {
		if (pessoaJuridicaTransformer == null) {
			pessoaJuridicaTransformer = new PessoaJuridicaTransformer();
		}
		return pessoaJuridicaTransformer;
	}

	@Override
	public PessoaJuridicaResource toResource(PessoaJuridica e) {
		if (e == null) {
			return null;
		}
		PessoaJuridicaResource r = new PessoaJuridicaResource(ColaboradorTransformer.getInstance().toResource(e));
		r.setBanner(e.getBanner());
		r.setRazaoSocial(e.getRazaoSocial());
		r.setNomeFantasia(e.getNomeFantasia());
		r.setTamanho(e.getTamanho().name());
		return r;
	}

	@Override
	public PessoaJuridica toEntity(PessoaJuridicaResource r) {
		if (r == null) {
			return null;
		}
		PessoaJuridica e = new PessoaJuridica(ColaboradorTransformer.getInstance().toEntity(r));
		e.setBanner(r.getBanner());
		e.setRazaoSocial(r.getRazaoSocial());
		e.setNomeFantasia(r.getNomeFantasia());
		e.setTamanho(Tamanho.valueOf(r.getTamanho()));
		return e;
	}

}
