package br.com.unibh.rest.api;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.unibh.negocio.service.TipoDoacaoService;

@Stateless
@Path("formulario-doador")
public class FormularioDoadorController {

	@EJB(lookup = TipoDoacaoService.LOOKUP)
	private TipoDoacaoService tipoDoacaoService;

	@GET
	@Path("buscar-tipos-doacao")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarTiposDoacao() {
		return Response.ok(tipoDoacaoService.buscarTipoDoacao()).build();
	}

	@GET
	@Path("buscar-tipos-doacao/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarTiposDoacao(@PathParam("id") Long id) {
		return Response.ok(tipoDoacaoService.buscarTipoDoacao(id)).build();
	}

}
