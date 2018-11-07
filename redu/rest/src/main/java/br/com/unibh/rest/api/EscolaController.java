package br.com.unibh.rest.api;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.unibh.negocio.service.EscolaService;

@Path("escola")
@Stateless
public class EscolaController {

	@EJB(lookup = EscolaService.LOOKUP)
	private EscolaService escolaService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response leituraDados() {
		escolaService.carregarEscolas();
		return Response.ok().build();
	}
}
