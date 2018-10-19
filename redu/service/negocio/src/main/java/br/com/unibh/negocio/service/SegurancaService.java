package br.com.unibh.negocio.service;

import javax.ejb.Remote;

import br.com.unibh.negocio.dto.Credencial;

@Remote
public interface SegurancaService {

	public static final String LOOKUP = "ejb:/redu-service/SegurancaBean!br.com.unibh.negocio.service.SegurancaService";

	public void login(Credencial credencial);
}
