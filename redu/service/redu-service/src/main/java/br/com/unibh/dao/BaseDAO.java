package br.com.unibh.dao;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Model
public class BaseDAO {

	@PersistenceContext(unitName = "Redu")
	protected EntityManager entityManager;

	public BaseDAO() {

	}
}
