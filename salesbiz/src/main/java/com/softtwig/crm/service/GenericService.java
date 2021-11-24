package com.softtwig.crm.service;

import java.util.Date;
import java.util.List;

import com.softtwig.crm.exception.SalesBizException;


public interface GenericService<E> {

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
	/*void create(List<BODTO<E>> list) throws MySalesException;*/

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
	/*void update(List<BODTO<E>> list) throws MySalesException;*/

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

	E findById(Long long1) throws SalesBizException;

}
