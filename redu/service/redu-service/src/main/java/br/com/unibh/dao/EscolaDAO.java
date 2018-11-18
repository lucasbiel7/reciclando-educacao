package br.com.unibh.dao;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.unibh.redu.core.entities.Escola;

@Dependent
public class EscolaDAO extends BaseDAO {

	public List<Escola> buscarTodos() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Escola> query = builder.createQuery(Escola.class);
		Root<Escola> root = query.from(Escola.class);
		query.orderBy(builder.asc(root.get("nomeEscola")));
		return entityManager.createQuery(query).getResultList();
	}

	public List<Escola> buscarPorNome(String nome) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Escola> query = builder.createQuery(Escola.class);
		Root<Escola> root = query.from(Escola.class);
		query.where(builder.like(builder.upper(root.get("nomeEscola")), "%" + nome.toUpperCase() + "%"))
				.orderBy(builder.asc(root.get("nomeEscola")));
		return entityManager.createQuery(query).getResultList();
	}
}
