package br.com.unibh.dao;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.unibh.redu.core.entities.Doacao;

@Dependent
public class DoacaoDAO extends BaseDAO {

	public List<Doacao> buscarPorColaborador(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Doacao> query = builder.createQuery(Doacao.class);
		Root<Doacao> root = query.from(Doacao.class);
		query.where(builder.equal(root.get("colaborador").get("id"), id));
		return entityManager.createQuery(query).getResultList();
	}

}
