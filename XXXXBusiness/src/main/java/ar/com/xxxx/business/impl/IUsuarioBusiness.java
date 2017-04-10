package ar.com.xxxx.business.impl;

import ar.com.xxxx.business.base.IGenericBusiness;
import ar.com.xxxx.business.base.exceptions.BusinessException;
import ar.com.xxxx.entities.bo.Usuario;


/**
 * <p> Interface de USUARIOS</p>
 * @author nconde
 * @since 14/03/2017
 *
 */

public interface IUsuarioBusiness extends IGenericBusiness<Usuario,Integer>{

	/**
	 * <p>Reporte de usuarios</p>
	 *
	 * @return byte[]
	 * @author nconde
	 * @since 20/03/2017
	 */
	byte[] reportsUsuarios() throws BusinessException;


	/**
	 * <p>Ejemplo de prueba para ver como funciona el atrapado de la excepcion</p>
	 * @throws BusinessException
	 */
	void pruebalanzarExcepcion() throws BusinessException;


    /**
     * <p>Trae los datos desde el Webservices.</p>
     * @return
     * @throws BusinessException
     */
    String traerDatosDesdeWebservices() throws BusinessException;


}

