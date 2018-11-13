package br.com.unibh.dao;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.unibh.negocio.dto.Credencial;
import br.com.unibh.redu.core.entities.Usuario;

@Dependent
public class UsuarioDAO extends BaseDAO {

	public Usuario buscarUsuario(Credencial credencial) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
		Root<Usuario> root = query.from(Usuario.class);
		query.where(builder.equal(root.get("email"), credencial.getEmail()),
				builder.equal(root.get("senha"), credencial.getSenha()));
		return entityManager.createQuery(query).getSingleResult();
	}

	public List<Usuario> buscarPorEmail(String email) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
		Root<Usuario> root = query.from(Usuario.class);
		query.where(builder.equal(root.get("email"), email));
		return entityManager.createQuery(query).getResultList();
	}

}
