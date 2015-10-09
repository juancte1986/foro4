package ar.edu.uces.progweb2.springmvc.dao;

import java.util.List;

public abstract interface GenericDao<T>{
	
	public T getById(Long id);

	public List<T> findAll();

	public void delete(T entity);
	
	public void saveOrUpdate(T entity);
	
	public Long getCount();
}
