package br.com.unibh.negocio.util.transformer;

import br.com.unibh.negocio.dto.UsuarioResource;
import br.com.unibh.negocio.util.BaseTransformer;
import br.com.unibh.redu.core.entities.Usuario;

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
		e.setSenha(r.getSenha());
		e.setEmail(r.getEmail());
		return e;
	}

}
