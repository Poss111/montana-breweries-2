package com.montanabrews.daos;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class MontanaBrewsBaseDao <T extends Serializable> {
	
	private static final Logger LOG = LoggerFactory.getLogger(MontanaBrewsBaseDao.class);

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
		LOG.info("Finding an instace of '{}' with id of '{}'", classy, id);
		return (T) getCurrentSession().get(classy, id);
	}
	
	/**
	 * Find all records of given type
	 * @return
	 */
	public List<T> findAll() {
		LOG.info("Finding all instaces of '{}'", classy);
		return getCurrentSession().createQuery("from " + classy.getName()).list();
	}
	
	/**
	 * Create the given record
	 * @param entity
	 */
	public void create(T entity) {
		LOG.info("Creating an instace of '{}' with given details '{}'", classy, entity);
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
