package persistence;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Usuario;

@Repository
public class UsuarioDAO extends DaoGenerico<Usuario, Long>{
	
	//@Autowired
	
	
	public Usuario buscaPorLoginESenha(Usuario usuario) {
				
		try {
			Query query = entityManager.createQuery("from Usuario usuario where usuario.email = :email AND usuario.senha = :senha");
		        query.setParameter("email", usuario.getEmail());
		        query.setParameter("senha", usuario.getSenha());
		        
		        if(!query.getResultList().isEmpty()){
		        	return (Usuario) query.getResultList().get(0);
		        }
		        
		        return null;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
}


