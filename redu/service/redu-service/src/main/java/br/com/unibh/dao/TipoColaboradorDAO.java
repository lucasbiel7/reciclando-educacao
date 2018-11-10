package br.com.unibh.dao;

import java.util.List;

import javax.enterprise.context.Dependent;

import br.com.unibh.redu.core.entities.TipoColaborador;

@Dependent
public class TipoColaboradorDAO extends BaseDAO {

	public List<TipoColaborador> buscarTipoColaborador() {
		return buscarTodos(TipoColaborador.class);
	}
}
