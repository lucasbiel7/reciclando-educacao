package br.com.unibh.ejb.services;

import javax.ejb.Stateless;

import br.com.unibh.negocio.dto.Credencial;
import br.com.unibh.negocio.service.SegurancaService;

@Stateless
public class SegurancaBean implements SegurancaService {

	@Override
	public void login(Credencial credencial) {

	}

}
