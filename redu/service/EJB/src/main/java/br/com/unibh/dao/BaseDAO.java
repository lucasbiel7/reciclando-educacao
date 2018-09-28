package br.com.unibh.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDAO {

	@PersistenceContext(name = "Redu")
	protected EntityManager entityManager;

	public BaseDAO() {

	}
}
