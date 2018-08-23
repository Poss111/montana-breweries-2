package com.montanabrews.daos;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class MontanaBrewsBaseDao <T extends Serializable> {

	private Class<T> classy;
	
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * @param classy the classy to set
	 */
	public void setClassy(Class<T> classy) {
		this.classy = classy;
	}

	/**
	 * @return the sessionFactory
	 */
	public final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}	
	
	/**
	 * Find a record by given id
	 * @param id
	 * @return
	 */
	public T findOne(long id) {
		return (T) getCurrentSession().get(classy, id);
	}
	
	/**
	 * Find all records of given type
	 * @return
	 */
	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + classy.getName()).list();
	}
	
	/**
	 * Create the given record
	 * @param entity
	 */
	public void create(T entity) {
		getCurrentSession().persist(entity);
	}
	
	/**
	 * Update a given record
	 * @param entity
	 */
	public void update(T entity) {
		getCurrentSession().merge(entity);
	}
	
	/**
	 * Delete a given record
	 * @param entity
	 */
	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}
	
	/**
	 * Delete a record by the Object Id
	 * @param entityId
	 */
	public void deleteById(long entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}
	
}
