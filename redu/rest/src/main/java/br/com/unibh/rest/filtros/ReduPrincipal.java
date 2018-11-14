package br.com.unibh.rest.filtros;

import java.security.Principal;

import br.com.unibh.negocio.dto.UsuarioResource;

public class ReduPrincipal implements Principal {

	private final UsuarioResource usuarioResource;

	public ReduPrincipal(UsuarioResource usuarioResource) {
		this.usuarioResource = usuarioResource;
	}

	public UsuarioResource getUsuarioResource() {
		return usuarioResource;
	}

	@Override
	public String getName() {
		return usuarioResource.getNome();
	}

}
