package br.com.unibh.rest.api;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.unibh.negocio.dto.DoacaoResource;
import br.com.unibh.negocio.service.DoacaoService;

@Stateless
@Path("doacao")
public class DoacaoController {

	@EJB(lookup = DoacaoService.LOOKUP)
	private DoacaoService doacaoService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrarDoacao(DoacaoResource doacao) {
		return Response.status(Status.OK).entity(doacaoService.cadastrarDoacao(doacao)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("buscar-por-colaborador/{idColaborador}")
	public Response buscaPorColaborador(@PathParam("idColaborador") Long id) {
		return Response.status(Status.OK).entity(doacaoService.buscarPorColaborador(id)).build();
	}
}
