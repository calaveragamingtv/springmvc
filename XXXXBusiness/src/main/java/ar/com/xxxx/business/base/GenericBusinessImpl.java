package ar.com.xxxx.business.base;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.com.xxxx.business.base.exceptions.BusinessException;
import ar.com.xxxx.persistence.base.IGenericDao;
import ar.com.xxxx.persistence.base.exceptions.PersistenceException;

/**
 * <p>
 * Business General.
 * </p>
 *
 * @author usuario
 * @since 23/03/2017
 *
 * @param <E>
 *            Entidad
 * @param <K>
 *            Tipo de id de la Entidad
 */
@Service
public abstract class GenericBusinessImpl<E, K> implements IGenericBusiness<E, K> {

    /**
     * <p>
     * Generic dao.
     * </p>
     */
	private IGenericDao<E, K> genericDao;

	/**
	 * <p>
	 * Constructor sobre cargado.
	 * </p>
	 *
	 * @param genericDao
	 *            dao por dfecto
	 * @author nconde
	 */
	public GenericBusinessImpl(final IGenericDao<E, K> genericDao) {
		this.genericDao = genericDao;
	}

	/**
	 * <p>
	 * Constructor.
	 * </p>
	 *
	 * @author nconde
	 */
	public GenericBusinessImpl() {
	    super();
	}

	/**
	 *
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveOrUpdate(final E entity) throws BusinessException {
		try {
			genericDao.saveOrUpdate(entity);
		} catch (PersistenceException e) {
			throw new BusinessException(e.getMessage(), e.getCause());
		}
	}
    /**
     *
     */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<E> getAll() throws BusinessException {
		List<E> lista;
		try {
			lista = genericDao.getAll();
		} catch (PersistenceException e) {
			throw new BusinessException(e.getMessage(), e.getCause());
		}
		return lista;
	}

	/**
	 *
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public E get(final K id) throws BusinessException {
		E entidad;
		try {
			entidad = genericDao.find(id);
		} catch (PersistenceException e) {
			throw new BusinessException(e.getMessage(), e.getCause());
		}
		return entidad;
	}

	/**
	 *
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void add(E entity) throws BusinessException {
		try {
			genericDao.add(entity);
		} catch (PersistenceException e) {
			throw new BusinessException(e.getMessage(), e.getCause());
		}
	}

	/**
	 *
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(final E entity) throws BusinessException {
		try {
			genericDao.update(entity);
		} catch (PersistenceException e) {
			throw new BusinessException(e.getMessage(), e.getCause());
		}
	}

	/**
	 *
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(final E entity) throws BusinessException {
		try {
			genericDao.remove(entity);
		} catch (PersistenceException e) {
			throw new BusinessException(e.getMessage(), e.getCause());
		}
	}
}