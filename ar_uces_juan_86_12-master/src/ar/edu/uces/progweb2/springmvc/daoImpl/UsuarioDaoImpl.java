package ar.edu.uces.progweb2.springmvc.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.uces.progweb2.springmvc.model.Usuario;

@Transactional(readOnly = false)
@Component
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario>{
	
	// sessionFactory lo obtengo a traves de spring context

	public Usuario buscarUsuario(Usuario usuario){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Usuario u where u.user=:user and u.pass=:pass");
		query.setParameter("user", usuario.getUser());
		query.setParameter("pass", usuario.getPass());
		return (Usuario) query.uniqueResult();
	}
	
	public boolean isUserDisponible(Usuario usuario){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Usuario u where u.user=:user");
		query.setParameter("user", usuario.getUser());
		 if(query.uniqueResult() != null){
			return false; 
		}else{
			return true;
		}
	}
}	
