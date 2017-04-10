package ar.com.xxxx.business.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.com.xxxx.business.base.GenericBusinessImpl;
import ar.com.xxxx.business.base.exceptions.BusinessException;
import ar.com.xxxx.business.impl.services.IServicesBusiness;
import ar.com.xxxx.entities.bo.Usuario;
import ar.com.xxxx.persistence.base.IGenericDao;
import ar.com.xxxx.persistence.dao.IUsuarioDAO;
import ar.com.xxxx.reports.base.exceptions.ReportesException;
import ar.com.xxxx.reports.base.impl.XXXXReporte;
import ar.com.xxxx.services.exception.ServicesException;

/**
 * <p>
 * Usuarios Business implementado
 * </p>
 *
 * @author nconde
 *
 * @since 20/03/2017
 *
 */
@Service
public class UsuarioBusinessImpl extends GenericBusinessImpl<Usuario, Integer> implements IUsuarioBusiness {

    /**
     * <p>
     * Es el dao que se utiliza.
     * </p>
     */
    private IUsuarioDAO usuarioDao;

    /**
     * <p>
     * Carga el servicio (Webservices).
     * </p>
     */
    @Autowired
    private IServicesBusiness servicesBusinessImpl;

    /**
     * <p>
     * Es el constructor de la clase.
     * </p>
     *
     * @param genericDao
     */
    @Autowired
    public UsuarioBusinessImpl(@Qualifier("usuarioDAOImpl") final IGenericDao<Usuario, Integer> genericDao) {
        super(genericDao);
        this.usuarioDao = (IUsuarioDAO) genericDao;

    }

    /**
     * @return the usuarioDao
     */
    public IUsuarioDAO getUsuarioDao() {
        return usuarioDao;
    }

    /**
     * @param usuarioDao
     *            the usuarioDao to set
     */
    public void setUsuarioDao(final IUsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    /**
     * <p>
     * Reporte de usuarios
     * </p>
     *
     * @return byte[]
     * @throws BusinessException
     */
    @Override
    public byte[] reportsUsuarios() throws BusinessException {
        final XXXXReporte xxxxReporte = new XXXXReporte();
        final HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("ID", "123");
        byte[] reporte;
        try {
            reporte = xxxxReporte.cargarReporte(hm);
        } catch (ReportesException e) {
            throw new BusinessException(e.getMessage(), e.getCause());
        }
        return reporte;
    }

    /**
     * <p>
     * Ejemplo de prueba lanzar excepcion
     * </p>
     *
     * @throws BusinessException
     * @author nconde
     */
    @Override
    public void pruebalanzarExcepcion() throws BusinessException {
        throw new BusinessException("Error forzado", new BusinessException());
    }

    /**
     * <p>Trae los datos desde el Webservices.</p>
     * @return
     * @throws BusinessException
     */
    @Override
    public String traerDatosDesdeWebservices() throws BusinessException {
        String valorDolar;
        try {
            valorDolar = servicesBusinessImpl.getConsultarMetodoGeneral();
        } catch (ServicesException e) {
            throw new BusinessException(e.getMessage(), e.getCause());
        }
        return valorDolar;
    }
}
