package ar.com.xxxx.business.impl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.wsdl.ConversionRateResponse;

import ar.com.xxxx.services.ConversionMonedaCliente;
import ar.com.xxxx.services.exception.ServicesException;

/**
 * <p>
 * Esta clase contiene los servicios que utiliza los business
 * </p>
 *
 * @author nconde
 * @since 23/03/2017
 */
@Service
public class ServicesBusinessImpl implements IServicesBusiness {

    /**
     * <p>El cliente que consulta el estado
     * de la conversion de la moneda.</p>
     */
	@Autowired
	ConversionMonedaCliente cms;

	/**
	 * <p>Consulta del precio del dolar</p>
	 * @author nconde
	 * @return String el valor del dolar
	 * @throws ServicesException
	 */
	@Override
    public String getConsultarMetodoGeneral() throws ServicesException {
		ConversionRateResponse crr;
		String returnValue;

		try {
			crr = cms.convertirMoneda();
			returnValue = String.valueOf(crr.getConversionRateResult());
		} catch (ServicesException e) {
			throw new ServicesException();
		}
		return returnValue;
	}

}
