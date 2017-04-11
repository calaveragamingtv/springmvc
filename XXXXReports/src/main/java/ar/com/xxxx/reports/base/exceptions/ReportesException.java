package ar.com.xxxx.reports.base.exceptions;

import ar.com.xxxx.commons.constants.Constantes;

/**
 * <p>Excepcion general Reportes</p>
 * @since 23/03/2017
 * @author nconde
 *
 */
public class ReportesException extends Exception {


	/**
	 *
	 */
	private static final long serialVersionUID = 78723164268448118L;

	/**
	 * <p>Mensaje por default.</p>
	 */
	private static final String MESSAGE = Constantes.EXCEPCION_MESSAGE_REPORTS;

	/**
	 * <p>Constructor</p>
	 * @param s Mensaje
	 * @since 23/03/2017
	 * @author nconde
	 */
	public ReportesException (final String s){
		super(s);
	}

	/**
	 * <p>Constructor mensaje por default.</p>
	 * @param s Mensaje
	 * @since 23/03/2017
	 * @author nconde
	 */
	public ReportesException (){
		super(MESSAGE);
	}


}
