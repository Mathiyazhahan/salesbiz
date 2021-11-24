/**
 * 
 */
package com.softtwig.crm.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.softtwig.crm.dao.GenericDAO;
import com.softtwig.crm.exception.SalesBizException;

/**
 * @author SCUBE
 *
 */
public class GenericServiceImpl<E> implements GenericService<E> {
	
	@Autowired
	private GenericDAO genericDAO;

	/* (non-Javadoc)
	 * @see com.softtwig.crm.service.GenericService#create(java.lang.Object)
	 */
	@Override
	public E create(E entity) throws SalesBizException {
		
		return (E) genericDAO.create(entity);
	}

	/* (non-Javadoc)
	 * @see com.softtwig.crm.service.GenericService#create(java.util.List)
	 */
	/*@Override
	public void create(List<BODTO<E>> list) throws MySalesException {
		
		
	}*/

	/* (non-Javadoc)
	 * @see com.softtwig.crm.service.GenericService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) throws SalesBizException {
		
		
	}

	/* (non-Javadoc)
	 * @see com.softtwig.crm.service.GenericService#deleteAll(java.util.List)
	 */
	@Override
	public void deleteAll(List<E> entityList) throws SalesBizException {
		
		
	}

	/* (non-Javadoc)
	 * @see com.softtwig.crm.service.GenericService#update(java.lang.Object)
	 */
	@Override
	public void update(E entity) throws SalesBizException {
		
		
	}

	/* (non-Javadoc)
	 * @see com.softtwig.crm.service.GenericService#update(java.util.List)
	 */
	/*@Override
	public void update(List<BODTO<E>> list) throws MySalesException {
		
		
	}
*/
	/* (non-Javadoc)
	 * @see com.softtwig.crm.service.GenericService#findByCriteria(java.lang.Object)
	 */
	@Override
	public E findByCriteria(E entity) throws SalesBizException {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.softtwig.crm.service.GenericService#findByParam(java.lang.String, java.lang.String)
	 */
	@Override
	public E findByParam(String entityParam, String entityParamValue)
			throws SalesBizException {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.softtwig.crm.service.GenericService#findByDate(java.util.Date, java.util.Date)
	 */
	@Override
	public List<E> findByDate(Date fDate, Date tDate) throws SalesBizException {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.softtwig.crm.service.GenericService#findById(java.lang.Long)
	 */
	@Override
	public E findById(Long long1) throws SalesBizException {
		
		return null;
	}

}
