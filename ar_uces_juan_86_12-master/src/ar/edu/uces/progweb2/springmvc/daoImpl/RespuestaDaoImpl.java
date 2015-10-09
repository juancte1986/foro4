package ar.edu.uces.progweb2.springmvc.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.progweb2.springmvc.dao.RespuestaDao;
import ar.edu.uces.progweb2.springmvc.model.Respuesta;


@Transactional(readOnly = true)
@Component
public class RespuestaDaoImpl extends GenericDaoImpl<Respuesta> implements RespuestaDao{
	
	@SuppressWarnings("unchecked")
	public List<Respuesta> getRespuestas(Long idTema) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q = session.createQuery("FROM Respuesta r where r.tema.id = :tema_id"); 
		q.setParameter("tema_id", idTema);
		return q.list();
	}

	@Override
	public Long getCountByUser(Long idUser) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT count(*) FROM Respuesta r where r.sender.id = :id_user");
		query.setParameter("id_user", idUser);
		return (Long) query.uniqueResult();
	}
}
