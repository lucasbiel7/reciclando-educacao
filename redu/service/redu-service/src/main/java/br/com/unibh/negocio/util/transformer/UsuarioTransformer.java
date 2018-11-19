package br.com.unibh.negocio.util.transformer;

import br.com.unibh.negocio.dto.UsuarioResource;
import br.com.unibh.negocio.util.BaseTransformer;
import br.com.unibh.redu.core.entities.Usuario;
import br.com.unibh.redu.core.util.Encriptacao;

public class UsuarioTransformer implements BaseTransformer<Usuario, UsuarioResource> {

	private UsuarioTransformer() {
		super();
	}

	private static UsuarioTransformer usuarioTransformer;

	public static UsuarioTransformer getInstance() {
		if (usuarioTransformer == null) {
			usuarioTransformer = new UsuarioTransformer();
		}
		return usuarioTransformer;
	}

	@Override
	public UsuarioResource toResource(Usuario e) {
		if (e == null) {
			return null;
		}
		UsuarioResource r = new UsuarioResource();
		r.setId(e.getId());
		r.setNome(e.getNome());
		r.setSenha(e.getSenha());
		r.setEmail(e.getEmail());
		r.setImagem(e.getImagem());
		r.setEndereco(EnderecoTransformer.getInstance().toResource(e.getEndereco()));
		r.setAdministrador(e.isAdministrador());
		return r;
	}

	@Override
	public Usuario toEntity(UsuarioResource r) {
		if (r == null) {
			return null;
		}
		Usuario e = new Usuario();
		e.setId(r.getId());
		e.setNome(r.getNome());
		e.setSenha(Encriptacao.getInstance().criptar(r.getSenha()));
		e.setEmail(r.getEmail());
		e.setImagem(r.getImagem());
		e.setEndereco(EnderecoTransformer.getInstance().toEntity(r.getEndereco()));
		e.setAdministrador(r.isAdministrador());
		return e;
	}

}
