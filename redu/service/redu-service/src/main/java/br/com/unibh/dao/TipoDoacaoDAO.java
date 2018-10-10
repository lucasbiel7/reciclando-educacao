package br.com.unibh.dao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.unibh.redu.core.entities.TipoDoacao;

@Model
public class TipoDoacaoDAO extends BaseDAO {

	public List<TipoDoacao> buscarTipoDoacao() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TipoDoacao> query = criteriaBuilder.createQuery(TipoDoacao.class);
		Root<TipoDoacao> root = query.from(TipoDoacao.class);
		query.where(criteriaBuilder.isNull(root.get("tipoDoacao")));
		return entityManager.createQuery(query).getResultList();
	}

	public List<TipoDoacao> buscarTipoDoacao(Long id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TipoDoacao> query = criteriaBuilder.createQuery(TipoDoacao.class);
		Root<TipoDoacao> root = query.from(TipoDoacao.class);
		query.where(criteriaBuilder.equal(root.get("tipoDoacao").get("id"), id));
		return entityManager.createQuery(query).getResultList();
	}

}