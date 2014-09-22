package br.com.persistence;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.model.Usuario;

@Repository
public class UsuarioDAO extends DaoGenerico<Usuario, Long> {

	@PersistenceContext
	private EntityManager manager;

	@PostConstruct
	public void init() {
		entityManager = manager;
	}
	
	public Usuario buscaPorLoginESenha(Usuario usuario) {

		try {
			Query query = entityManager.createQuery("from Usuario usuario where usuario.email = :email AND usuario.senha = :senha");
			query.setParameter("email", usuario.getEmail());
			query.setParameter("senha", usuario.getSenha());

			if (!query.getResultList().isEmpty()) {
				return (Usuario) query.getResultList().get(0);
			}

			return null;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
}