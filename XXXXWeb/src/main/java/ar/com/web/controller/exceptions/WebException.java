package ar.com.web.controller.exceptions;

import ar.com.xxxx.commons.constants.Constantes;

/**
 * <p>Excepcion general de la capa Web</p>
 * @author nconde
 * @since 23/03/2017
 *
 */
public class WebException extends Exception {


	/**
	 *
	 */
	private static final long serialVersionUID = -5466547138616524996L;
	/**
	 * <p>Mensaje por default de la excepcion.</p>
	 */
	private static final String MESSAGE = Constantes.EXCEPCION_MESSAGE_WEB;

	/**
	 * <p>Constructor</p>
	 * @param s Mensaje
	 * @since 23/03/2017
	 * @author nconde
	 */
	public WebException (final String s){
		super(s);
	}

	/**
	 * <p>Constructor mensaje por default.</p>
	 * @param s Mensaje
	 * @since 23/03/2017
	 * @author nconde
	 */
	public WebException (){
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
	public WebException(final String message, final Throwable cause) {
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
	public WebException(final Throwable cause) {
		super(cause);
	}



}
