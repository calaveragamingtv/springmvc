package ar.com.xxxx.commons.constants;

/**
 * <p> Constantes de la aplicacion.</p>
 *
 * @author nconde
 * @since 20/03/2017
 */
public final class Constantes {


	/**
	 * Contiene el nombre del report "XXXXReporte" el reporte ya esta compilado
	 */
	public static final String REPORTE_NAME_XXXX_REPORTE = "XXXXReporte.jasper";

	/**
	 * Contiene la url del servicio de cambio de moneda
	 */
	public static final String SERVICES_URL_CAMBIO_MONEDA = "http://www.webservicex.com/currencyconvertor.asmx";

	/**
	 * Contiene la url de la operacion cambio de moneda
	 */
	public static final String SERVICES_URL_OPERACION_CAMBIO_MONEDA = "http://www.webserviceX.NET/ConversionRate";

	/**
	 * Contiene el mensaje de error de PERSISTENCIA general.
	 */
	public static final String EXCEPCION_MESSAGE_PERSISTENCIA ="Error en la capa de persistencia";

	/**
	 * Contiene el mensaje de error de BUSINESS general.
	 */
	public static final String EXCEPCION_MESSAGE_BUSINESS ="Error en la capa de Business";

	/**
	 * Contiene el mensaje de error de SERVICES general.
	 */
	public static final String EXCEPCION_MESSAGE_SERVICES ="Error en la capa de Services";

	/**
	 * Contiene el mensaje de error de REPORTES general.
	 */
	public static final String EXCEPCION_MESSAGE_REPORTS ="Error en la capa de Reportes";

	/**
	 * Contiene el mensaje de error de WEB general.
	 */
	public static final String EXCEPCION_MESSAGE_WEB ="Error en la capa web";

	/**
	 *  Contiene el mensaje que se debe utilizar al entrar a un metodo.
	 */
	public static final String LOGGER_ENTRANDO ="Entrando a: ";

	/**
	 * Contiene el mensaje que se debe utilizar al salir de un metodo.
	 */
	public static final String LOGGER_SALIENDO ="Saliendo de: ";


	/***********************************     TEST     ***************************************/
	   /**
     * Mensaje para BO nulos
     */
    public static final String NULO ="El BO es nulo";

    /**
     * Mensaje para BO NO nulos
     */
    public static final String NO_NULO ="El BO NO es nulo";


    /**
     * Mensaje para valor falso
     */
    public static final String VALOR_FALSO ="El valor es falso";


    /**
     * Mensaje para valor verdadero
     */
    public static final String VALOR_VERDADERO ="El valor es verdadero";



    /**
     * <p>Constructor privado para evitar crear una instancia de la clase.</p>
     */
    private Constantes(){

    }



}
