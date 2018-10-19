package br.com.unibh.rest.api;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.unibh.negocio.dto.Credencial;

@Path("seguranca")
@Stateless
public class SegurancaController {

	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(Credencial credencial) {

		return Response.ok().build();
	}
}
