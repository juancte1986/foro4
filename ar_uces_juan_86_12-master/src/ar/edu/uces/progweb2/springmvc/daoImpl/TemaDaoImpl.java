package ar.edu.uces.progweb2.springmvc.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.progweb2.springmvc.dao.TemaDao;
import ar.edu.uces.progweb2.springmvc.model.Genero;
import ar.edu.uces.progweb2.springmvc.model.Tema;

@Transactional(readOnly = true)
@Component
public class TemaDaoImpl extends GenericDaoImpl<Tema> implements TemaDao{
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Tema> getTemasByGenero(Long idGenero) {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query q = session.createQuery("FROM Tema t where t.genero.id = :genero_id"); 
		q.setParameter("genero_id", idGenero);
		
		return q.list();
	}
	
	@Override
	public Long getCountTemaByGenero (Long idGenero) {
		Session session = sessionFactory.getCurrentSession();
		Query q= session.createQuery("FROM Tema t where id_genero = :id");
		q.setParameter("id", idGenero);
		return new Long(q.list().size());
	}
}
