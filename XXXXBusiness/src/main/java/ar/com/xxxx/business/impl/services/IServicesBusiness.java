package ar.com.xxxx.business.impl.services;

import ar.com.xxxx.services.exception.ServicesException;

/**
 * <p>
 * Interfaces que utilizan todos los servicios
 * </p>
 *
 * @author nconde
 * @since 23/03/2017
 *
 */
public interface IServicesBusiness {

	/**
	 * <p>
	 * Consulta generica del metodo principal del webservices
	 * </p>
	 * @author nconde
	 * @return
	 * 	<p>Se retorna un string siendo el resultado de una consulta</p>
	 */
	String getConsultarMetodoGeneral() throws ServicesException ;

}
