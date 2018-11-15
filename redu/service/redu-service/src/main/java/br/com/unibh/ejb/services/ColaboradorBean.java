package br.com.unibh.ejb.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.unibh.dao.ColaboradorDAO;
import br.com.unibh.dao.TipoColaboradorDAO;
import br.com.unibh.dao.UsuarioDAO;
import br.com.unibh.negocio.dto.ColaboradorResource;
import br.com.unibh.negocio.dto.PessoaFisicaResource;
import br.com.unibh.negocio.dto.PessoaJuridicaResource;
import br.com.unibh.negocio.dto.TipoColaboradorResource;
import br.com.unibh.negocio.exceptions.EmailExistenteException;
import br.com.unibh.negocio.service.ColaboradorService;
import br.com.unibh.negocio.util.transformer.ColaboradorTransformer;
import br.com.unibh.negocio.util.transformer.PessoaFisicaTransformer;
import br.com.unibh.negocio.util.transformer.PessoaJuridicaTransformer;
import br.com.unibh.negocio.util.transformer.TipoColaboradorTransformer;
import br.com.unibh.redu.core.entities.Colaborador;
import br.com.unibh.redu.core.entities.Usuario;

/**
 * 
 * @author Lucas Gabriel
 *
 */
@Stateless
public class ColaboradorBean implements ColaboradorService {

	@Inject
	private TipoColaboradorDAO tipoColaboradorDAO;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Inject
	private ColaboradorDAO colaboradorDAO;

	@Override
	public List<TipoColaboradorResource> pegarTiposDeColaboradores() {
		return tipoColaboradorDAO.buscarTipoColaborador().stream()
				.map(TipoColaboradorTransformer.getInstance()::toResource).collect(Collectors.toList());
	}

	@Override
	public void cadastrar(ColaboradorResource colaboradorResource) throws EmailExistenteException {
		List<Usuario> usuarios = usuarioDAO.buscarPorEmail(colaboradorResource.getEmail());
		if (!usuarios.isEmpty()) {
			throw new EmailExistenteException("Já existe algum usuário com esse e-mail!");
		}
		Colaborador colaborador;
		if (colaboradorResource instanceof PessoaFisicaResource) {
			colaborador = PessoaFisicaTransformer.getInstance().toEntity((PessoaFisicaResource) colaboradorResource);
		} else if (colaboradorResource instanceof PessoaJuridicaResource) {
			colaborador = PessoaJuridicaTransformer.getInstance()
					.toEntity((PessoaJuridicaResource) colaboradorResource);
		} else {
			colaborador = ColaboradorTransformer.getInstance().toEntity(colaboradorResource);
		}
		colaboradorDAO.salvar(colaborador);
	}

	@Override
	public void excluir(Long usuario) {
		Colaborador colaborador = colaboradorDAO.pegarPorId(usuario);
		colaboradorDAO.excluir(colaborador);
	}

}
