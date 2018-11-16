package br.com.unibh.rest.api;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.unibh.negocio.dto.DoacaoResource;

@Stateless
@Path("doacao")
public class DoacaoController {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarDoacao(DoacaoResource doacao) {
		return Response.status(Status.OK).build();
	}
}
