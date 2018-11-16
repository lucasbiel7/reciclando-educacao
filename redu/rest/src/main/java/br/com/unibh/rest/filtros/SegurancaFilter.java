package br.com.unibh.rest.filtros;

import java.io.IOException;
import java.security.Principal;
import java.util.Calendar;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import br.com.unibh.negocio.dto.UsuarioResource;
import br.com.unibh.rest.config.SecurityConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Provider
@PreMatching
public class SegurancaFilter implements ContainerRequestFilter, ContainerResponseFilter {

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

	/**
	 * Renovando a data de expiração do token
	 */
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		String token = requestContext.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
		if (token != null) {
			Claims campos = Jwts.parser().setSigningKey(SecurityConstant.KEY)
					.parseClaimsJws(token.replaceAll("Bearer", "").trim()).getBody();
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MINUTE, SecurityConstant.TIME_EXPIRATION);
			token = Jwts.builder().setClaims(campos).addClaims(Jwts.claims().setExpiration(calendar.getTime()))
					.addClaims(Jwts.claims().setSubject("users/authentication"))
					.signWith(SignatureAlgorithm.HS512, SecurityConstant.KEY).compact();
			responseContext.getHeaders().add(HttpHeaders.AUTHORIZATION, token);
		}
	}

}
