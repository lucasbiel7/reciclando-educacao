package br.com.unibh.rest.api;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.unibh.negocio.service.EscolaService;
import br.com.unibh.negocio.service.InfoDadosService;

@Path("escola")
@Stateless
public class EscolaController {

	@EJB(lookup = InfoDadosService.LOOKUP)
	private InfoDadosService infoDadosService;

	@EJB(lookup = EscolaService.LOOKUP)
	private EscolaService escolaService;

	@GET
	@Path("carregar-dados")
	@Produces(MediaType.APPLICATION_JSON)
	public Response leituraDados() {
		// Desativado porque já subiu as escolas para a base de dados
		infoDadosService.carregarEscolas();
		return Response.status(Status.NOT_ACCEPTABLE).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarEscolas() {
		return Response.status(Status.OK).entity(escolaService.buscarTodos()).build();
	}

	@GET
	@Path("{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarEscolas(@PathParam("nome") String nome) {
		return Response.status(Status.OK).entity(escolaService.buscarPorNome(nome)).build();
	}

}
