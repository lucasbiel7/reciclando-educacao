package br.com.unibh.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.unibh.redu.core.entities.BaseEntity;

@Model
public class BaseDAO {

	@PersistenceContext(unitName = "Redu")
	protected EntityManager entityManager;

	public BaseDAO() {

	}

	public <T extends BaseEntity<?>> T salvar(T t) {
		if (t.getId() == null) {
			entityManager.persist(t);
			return t;
		}
		return entityManager.merge(t);
	}

	public <T extends BaseEntity<?>> void excluir(T t) {
		entityManager.remove(t);
	}

	public <T extends BaseEntity<?>> List<T> buscarTodos(Class<T> clazz) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(clazz);
		query.from(clazz);
		return entityManager.createQuery(query).getResultList();
	}

	protected <T extends BaseEntity<?>> T pegarPorId(Class<T> clazz, Serializable id) {
		return entityManager.find(clazz, id);
	}

}
