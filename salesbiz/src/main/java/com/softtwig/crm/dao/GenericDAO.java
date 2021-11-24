package com.softtwig.crm.dao;

import java.util.Date;
import java.util.List;

import com.softtwig.crm.exception.SalesBizException;

/**
 * This class to be form an common function for this application
 * 
 * @author Scube Technologies
 * @param <E>
 * 
 */

public interface GenericDAO<E> {

	/**
	 * Creates a new entity and copies properties of given entity.
	 * 
	 * @param entity
	 * @throws MySalesException
	 *             ;
	 */
	E create(E entity) throws SalesBizException;

	/**
	 * Create list of new entity and copies properties of given entity.
	 * 
	 * @param entity
	 * @throws MySalesException
	 *             ;
	 */
	void create(List<E> list) throws SalesBizException;

	/**
	 * Deletes given entity from database
	 * 
	 * @param entity
	 * @throws MySalesException
	 */
	void delete(Long id) throws SalesBizException;

	/**
	 * Deletes given list of entity from database
	 * 
	 * @param entity
	 * @throws MySalesException
	 *             ;
	 */
	void deleteAll(List<E> entityList) throws SalesBizException;

	/**
	 * Updates given entity to the database
	 * 
	 * @param entity
	 * @throws MySalesException
	 */
	void update(E entity) throws SalesBizException;

	/**
	 * Updates given list of entity to the database
	 * 
	 * @param entity
	 * @throws MySalesException
	 */
	void update(List<E> list) throws SalesBizException;

	/**
	 * Retrieve entity with given criteria.
	 * 
	 * @param entity
	 * @throws MySalesException
	 *             ;
	 */

	E findByCriteria(E entity) throws SalesBizException;

	/**
	 * Retrieve entity with given name String.
	 * 
	 * @param entity
	 * @throws MySalesException
	 *             ;
	 */

	E findByParam(String entityParam, String entityParamValue)
			throws SalesBizException;

	/**
	 * Retrieve entity with given date.
	 * 
	 * @param entity
	 * @throws MySalesException
	 *             ;
	 */

	List<E> findByDate(Date fDate, Date tDate) throws SalesBizException;

	/**
	 * Retrieve entity with given id.
	 * 
	 * @param entity
	 * @throws MySalesException
	 *             ;
	 */

	E findById(Long id) throws SalesBizException;

	/**
	 * Retrieve All entity from the database.
	 * 
	 * @param entity
	 * @throws MySalesException
	 *             ;
	 */
	List<E> retrieveAll() throws SalesBizException;



}
