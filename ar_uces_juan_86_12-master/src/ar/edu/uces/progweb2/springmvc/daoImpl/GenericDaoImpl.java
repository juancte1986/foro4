package ar.edu.uces.progweb2.springmvc.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.progweb2.springmvc.dao.GenericDao;

@Transactional(readOnly = true)
@Component
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	private Class<T> persistentClass;
	protected SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (T) session.get(getPersistentClass(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return (List<T>) session.createQuery("FROM" + getPersistentClass());
	}

	// Borrado fisico, estari bueno implementar un borrado logico
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public void saveOrUpdate(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(entity);
	}

	public Long getCount() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(getPersistentClass());
		return (Long) criteria.setProjection(Projections.rowCount())
				.uniqueResult();
	}

}
