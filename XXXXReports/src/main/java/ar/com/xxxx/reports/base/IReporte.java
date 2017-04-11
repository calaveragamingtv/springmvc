package ar.com.xxxx.reports.base;

import java.util.HashMap;

import ar.com.xxxx.reports.base.exceptions.ReportesException;

/**
 * Interface con metodos comunes de la generacion de reportes.
 * @author usuario
 * @since 23/03/2017
 *
 */
public interface IReporte {

	/**
	 * <p>Creando el reporte  XXXXReporte</p>
	 *
	 * @author nconde
	 * @since 20/03/2017
	 *
	 * @return byte[]
	 */
     byte[] crearReporte(final HashMap<String, Object>  hm) throws ReportesException;

    /**
     * <p>Realiza la busqueda de datos para el reporte XXXXReporte</p>
     * @author nconde
	 * @since 20/03/2017
	 *
	 * @return byte[]
     */
     byte[] cargarReporte(final HashMap<String, Object>  hm) throws ReportesException;

}
