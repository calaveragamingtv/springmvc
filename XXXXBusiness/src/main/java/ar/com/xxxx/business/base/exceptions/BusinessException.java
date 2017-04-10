package ar.com.xxxx.business.base.exceptions;

import ar.com.xxxx.commons.constants.Constantes;

/**
 * <p>Excepcion general Business</p>
 * @since 23/03/2017
 * @author nconde
 *
 */
public class BusinessException extends Exception {


	/**
	 *
	 */
	private static final long serialVersionUID = 5970316086924006385L;
	/**
	 * <p>Es el mensaje por default de la excepcion.</p>
	 */
	private static final String MESSAGE = Constantes.EXCEPCION_MESSAGE_BUSINESS;

	/**
	 * <p>Constructor</p>
	 * @param s Mensaje
	 * @since 23/03/2017
	 * @author nconde
	 */
	public BusinessException (final String s){
		super(s);
	}

	/**
	 * <p>Constructor mensaje por default.</p>
	 * @param s Mensaje
	 * @since 23/03/2017
	 * @author nconde
	 */
	public BusinessException (){
		super(MESSAGE);
	}

	/**
	 * <p>
	 * Constructor mensaje y throw
	 * </p>
	 *
	 * @param message
	 *            Mensaje de error
	 * @param cause
	 *            Causa del error
	 * @since 27/03/2017
	 * @author nconde
	 *
	 */
	public BusinessException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * <p>
	 * Constructor solo con el throw
	 * </p>
	 *
	 * @param cause
	 *            Causa del error
	 * @since 27/03/2017
	 * @author nconde
	 *
	 */
	public BusinessException(final Throwable cause) {
		super(cause);
	}

}
