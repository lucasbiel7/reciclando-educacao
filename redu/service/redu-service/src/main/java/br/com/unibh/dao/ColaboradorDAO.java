package br.com.unibh.dao;

import javax.enterprise.context.Dependent;

import br.com.unibh.redu.core.entities.Colaborador;

@Dependent
public class ColaboradorDAO extends BaseDAO {

	public Colaborador pegarPorId(Long id) {
		return super.pegarPorId(Colaborador.class, id);
	}
}
