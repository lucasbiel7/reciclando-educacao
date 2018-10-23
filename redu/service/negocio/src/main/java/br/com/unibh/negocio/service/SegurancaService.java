package br.com.unibh.negocio.service;

import javax.ejb.Remote;

import br.com.unibh.negocio.dto.Credencial;
import br.com.unibh.negocio.dto.UsuarioResource;
import br.com.unibh.negocio.exceptions.AutenticacaoException;

@Remote
public interface SegurancaService {

	public static final String LOOKUP = "ejb:/redu-service/SegurancaBean!br.com.unibh.negocio.service.SegurancaService";

	public UsuarioResource login(Credencial credencial) throws AutenticacaoException;
}
