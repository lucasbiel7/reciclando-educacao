package br.com.unibh.rest.filtros;

import java.io.IOException;
import java.security.Principal;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import br.com.unibh.negocio.dto.UsuarioResource;
import br.com.unibh.rest.config.SecurityConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Provider
@PreMatching
public class SegurancaFilter implements ContainerRequestFilter {

	private UsuarioResource usuarioResource;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		String token = requestContext.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
		if (token != null) {
			Claims campos = Jwts.parser().setSigningKey(SecurityConstant.KEY)
					.parseClaimsJws(token.replaceAll("Bearer", "").trim()).getBody();
			usuarioResource = new UsuarioResource();
			usuarioResource.setId(campos.get("id", Long.class));
			usuarioResource.setEmail(campos.get("email", String.class));
			usuarioResource.setNome(campos.get("nome", String.class));
		}

		requestContext.setSecurityContext(new SecurityContext() {

			@Override
			public boolean isUserInRole(String role) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isSecure() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Principal getUserPrincipal() {
				return new ReduPrincipal(usuarioResource);
			}

			@Override
			public String getAuthenticationScheme() {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}

}
