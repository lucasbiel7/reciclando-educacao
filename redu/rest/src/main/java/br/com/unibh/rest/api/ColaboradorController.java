package br.com.unibh.rest.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.unibh.negocio.dto.PessoaFisicaResource;
import br.com.unibh.negocio.dto.PessoaJuridicaResource;
import br.com.unibh.negocio.dto.TipoColaboradorResource;
import br.com.unibh.negocio.exceptions.EmailExistenteException;
import br.com.unibh.negocio.service.ColaboradorService;

@Stateless
@Path("colaborador")
public class ColaboradorController {

	@EJB(lookup = ColaboradorService.LOOKUP)
	private ColaboradorService colaboradorService;

	@GET
	@Path("tipo-colaborador")
	@Produces(MediaType.APPLICATION_JSON)
	public Response tipoColaboiradores() {
		List<TipoColaboradorResource> tipoColaboradores = colaboradorService.pegarTiposDeColaboradores();
		return Response.status(Status.OK).entity(tipoColaboradores).build();
	}

	@POST
	@Path("cadastrar-fisica")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(PessoaFisicaResource colaborador) {
		try {
			colaboradorService.cadastrar(colaborador);
			return Response.ok().build();
		} catch (EmailExistenteException e) {
			return Response.status(Status.PRECONDITION_FAILED).entity(e.getMessage()).build();
		}

	}

	@POST
	@Path("cadastrar-juridica")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(PessoaJuridicaResource colaborador) {
		try {
			colaboradorService.cadastrar(colaborador);
			return Response.ok().build();
		} catch (EmailExistenteException e) {
			return Response.status(Status.PRECONDITION_FAILED).entity(e.getMessage()).build();
		}
	}

}
