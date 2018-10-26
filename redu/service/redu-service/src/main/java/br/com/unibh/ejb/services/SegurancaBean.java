package br.com.unibh.ejb.services;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import br.com.unibh.dao.UsuarioDAO;
import br.com.unibh.negocio.dto.Credencial;
import br.com.unibh.negocio.dto.UsuarioResource;
import br.com.unibh.negocio.exceptions.AutenticacaoException;
import br.com.unibh.negocio.service.SegurancaService;
import br.com.unibh.negocio.util.transformer.UsuarioTransformer;
import br.com.unibh.redu.core.entities.Usuario;
import br.com.unibh.redu.core.util.Encriptacao;

@Stateless
public class SegurancaBean implements SegurancaService {

	@Inject
	private UsuarioDAO usuarioDAO;

	@Override
	public UsuarioResource login(Credencial credencial) throws AutenticacaoException {
		Usuario usuario;
		try {
			credencial.setSenha(Encriptacao.getInstance().criptar(credencial.getSenha()));
			usuario = usuarioDAO.buscarUsuario(credencial);
		} catch (NoResultException e) {
			throw new AutenticacaoException("Usuário ou senha incorretos!");
		}
		return UsuarioTransformer.getInstance().toResource(usuario);
	}

}
