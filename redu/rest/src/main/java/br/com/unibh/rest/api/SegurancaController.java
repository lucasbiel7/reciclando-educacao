package br.com.unibh.rest.api;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import br.com.unibh.negocio.dto.Credencial;
import br.com.unibh.negocio.dto.UsuarioResource;
import br.com.unibh.negocio.exceptions.AutenticacaoException;
import br.com.unibh.negocio.service.SegurancaService;
import br.com.unibh.rest.config.SecurityConstant;
import br.com.unibh.rest.filtros.ReduPrincipal;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("seguranca")
@Stateless
public class SegurancaController {

	@EJB(lookup = SegurancaService.LOOKUP)
	private SegurancaService segurancaService;

	/**
	 * Método gerado para criar o token de autorização da aplicação
	 * 
	 * @param credencial
	 * @return
	 * @throws UnsupportedEncodingException
	 * 
	 */
	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(Credencial credencial) throws UnsupportedEncodingException {
		try {
			Map<String, Object> dados = new HashMap<>();
			UsuarioResource usuarioResource = segurancaService.login(credencial);
			dados.put("nome", usuarioResource.getNome());
			dados.put("email", usuarioResource.getEmail());
			dados.put("id", usuarioResource.getId());
			dados.put("endereco", usuarioResource.getEndereco());
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MINUTE, SecurityConstant.TIME_EXPIRATION);
			String token = Jwts.builder().setClaims(dados).addClaims(Jwts.claims().setExpiration(calendar.getTime()))
					.addClaims(Jwts.claims().setSubject("users/authentication"))
					.signWith(SignatureAlgorithm.HS512, SecurityConstant.KEY).compact();
			return Response.ok().header(HttpHeaders.AUTHORIZATION, token).build();
		} catch (AutenticacaoException e) {
			return Response.status(Status.FORBIDDEN).entity(e.getMessage()).build();
		}
	}

	/**
	 * 
	 * Criar metodo para recuperar dados do usuário
	 * 
	 * @return
	 */
	@GET
	@Path("usuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Response usuarioLogado(@Context SecurityContext securityContext) {
		if (securityContext.getUserPrincipal() instanceof ReduPrincipal) {
			ReduPrincipal usuarioPrincipal = (ReduPrincipal) securityContext.getUserPrincipal();
			if (usuarioPrincipal.getUsuarioResource() != null) {
				UsuarioResource usuario = segurancaService.buscarUsuario(usuarioPrincipal.getUsuarioResource().getId());
				return Response.ok(usuario).build();
			}
		}
		return Response.status(Status.FORBIDDEN).build();
	}
}
