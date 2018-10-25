package br.com.unibh.rest.api;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.unibh.negocio.dto.Credencial;
import br.com.unibh.negocio.dto.UsuarioResource;
import br.com.unibh.negocio.exceptions.AutenticacaoException;
import br.com.unibh.negocio.service.SegurancaService;
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
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.HOUR_OF_DAY, 1);
			String token = Jwts.builder().setSubject("users/authentication").setExpiration(calendar.getTime())
					.setClaims(dados).signWith(SignatureAlgorithm.HS256, "redu-web".getBytes("UTF-8")).compact();
			return Response.ok().header(HttpHeaders.AUTHORIZATION, token).build();
		} catch (AutenticacaoException e) {
			return Response.status(Status.FORBIDDEN).entity(e.getMessage()).build();
		}
	}
}
