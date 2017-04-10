package ar.com.xxxx.business.base;


import java.util.List;

import ar.com.xxxx.business.base.exceptions.BusinessException;

/**
 * <p>
 * Interface Generica del business.
 * </p>
 *
 * @author nconde
 * @since 23/03/2017
 *
 * @param <E>
 *            Entidad
 * @param <K>
 *            Tipo de Id
 */

public interface IGenericBusiness<E, K> {

	/**
	 * <p>
	 * Guarda o actualiza.
	 * </p>
	 *
	 * @author nconde
	 * @param entity
	 *            <p>
	 *            Entidad que sera insertada o actualizada.
	 *            </p>
	 * @throws BusinessException
	 *             <p>
	 *             Excepcion que podria llegar a lanzar.
	 *             </p>
	 */
	void saveOrUpdate(E entity) throws BusinessException;

	/**
	 * <p>
	 * Lista todos los resultados.
	 * </p>
	 *
	 * @author nconde
	 * @return
	 *         <p>
	 *         Retorna un lista de objetos
	 *         </p>
	 * @throws BusinessException
	 *             <p>
	 *             Excepcion que podria llegar a lanzar.
	 *             </p>
	 */
	List<E> getAll() throws BusinessException;

	/**
	 * <p>
	 * Busca por id.
	 * </p>
	 *
	 * @author nconde
	 * @param id
	 *            <p>
	 *            Es el primary del objeto a buscar.
	 *            </p>
	 * @return
	 *         <p>
	 *         Retorna un objeto.
	 *         </p>
	 * @throws BusinessException
	 *             <p>
	 *             Excepcion que podria llegar a lanzar.
	 *             </p>
	 */
	E get(K id) throws BusinessException;

	/**
	 * <p>
	 * Insert.
	 * </p>
	 *
	 * @author nconde
	 * @param entity
	 *            <p>
	 *            Retorna un objeto
	 *            </p>
	 * @throws BusinessException
	 *             <p>
	 *             Excepcion que podria llegar a lanzar.
	 *             </p>
	 */
	void add(E entity) throws BusinessException;

	/**
	 * <p>
	 * Actualiza.
	 * </p>
	 *
	 * @author nconde
	 * @param entity
	 *            <p>
	 *            Retorna un objeto
	 *            </p>
	 * @throws BusinessException
	 *             <p>
	 *             Excepcion que podria llegar a lanzar.
	 *             </p>
	 */
	void update(E entity) throws BusinessException;

	/**
	 * <p>
	 * Elimina.
	 * </p>
	 *
	 * @author nconde
	 * @param entity
	 *            <p>
	 *            Retorna un objeto
	 *            </p>
	 * @throws BusinessException
	 *             <p>
	 *             Excepcion que podria llegar a lanzar.
	 *             </p>
	 */
	void remove(E entity) throws BusinessException;
}