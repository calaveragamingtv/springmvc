package ar.com.xxxx.reports.base.impl;

import java.io.InputStream;
import java.util.HashMap;

import ar.com.xxxx.commons.constants.Constantes;
import ar.com.xxxx.reports.base.IReporte;
import ar.com.xxxx.reports.base.exceptions.ReportesException;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * <p>
 * Generador del reporte XXXXReporte
 * </p>
 *
 * @author nconde
 * @since 20/03/2017
 *
 */
public class XXXXReporte implements IReporte {

    /**
     * <p>
     * Creando el reporte XXXXReporte
     * </p>
     *
     * @author nconde
     * @since 20/03/2017
     *
     * @return byte[]
     */
    @Override
    public byte[] crearReporte(HashMap<String, Object> hm) throws ReportesException {

        byte[] pdfGenerado = null;
        try {
            final InputStream file = getClass().getResourceAsStream("/" + Constantes.REPORTE_NAME_XXXX_REPORTE);

            final JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);
            final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hm, new JREmptyDataSource());
            pdfGenerado = JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (JRException e) {
            throw new ReportesException();
        }

        return pdfGenerado;
    }

    /**
     * <p>
     * Realiza la busqueda de datos para el reporte XXXXReporte
     * </p>
     *
     * @author nconde
     * @since 20/03/2017
     *
     * @return byte[]
     * @throws ReportesException
     */
    @Override
    public byte[] cargarReporte(HashMap<String, Object> hm) throws ReportesException {
        return this.crearReporte(hm);
    }

}
