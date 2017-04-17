package ar.com.web.controller.usuario;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.com.web.controller.base.VerifyRecaptcha;
import ar.com.web.controller.exceptions.WebException;
import ar.com.xxxx.business.base.exceptions.BusinessException;
import ar.com.xxxx.business.impl.IUsuarioBusiness;
import ar.com.xxxx.commons.constants.Constantes;
import ar.com.xxxx.entities.bo.Usuario;
import ar.com.xxxx.entities.dto.UsuarioDTO;

/**
 * <p>
 * Controlador general de usuarios
 * </p>
 *
 * @author usuario
 *
 */
@Controller
public class UsuarioController {

    /**
     * <p>
     * Es el logger de la clase UsuarioController.
     * </p>
     */
    private static final Logger LOGGER = Logger.getLogger(UsuarioController.class);


    @Value("${login.recaptcha}")
    private String mensajeErrorRecaptcha;

    /**
     * <p>
     * Business del usuario
     * </p>
     */
    @Autowired
    private transient IUsuarioBusiness iUsuarioBusiness;

    /**
     * <p>
     * Busca todos los usuarios.
     * </p>
     *
     * @param model
     * @return
     * @throws WebException
     */
    @RequestMapping(value = "/usuarios")
    public ModelAndView listUsuarios(final ModelAndView model) throws WebException {
        LOGGER.info(Constantes.LOGGER_ENTRANDO + "listUsuarios");
        try {
            final List<Usuario> listUsuarios = iUsuarioBusiness.getAll();
            model.addObject("listUsuarios", listUsuarios);
            model.setViewName("usuario/usuarios");
        } catch (BusinessException e) {
            throw new WebException(e.getMessage(), e.getCause());
        }
        LOGGER.info(Constantes.LOGGER_SALIENDO + "listUsuarios");
        return model;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(final ModelAndView model) throws WebException {
        LOGGER.info(Constantes.LOGGER_ENTRANDO + "login");

        model.setViewName("login");

        LOGGER.info(Constantes.LOGGER_SALIENDO + "login");
        return model;
    }

    /**
     * <p>
     * Metodo el cual agrega un nuevo usuario.
     * </p>
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/nuevoUsuario", method = RequestMethod.GET)
    public ModelAndView newUsuario(final ModelAndView model) {
        LOGGER.info(Constantes.LOGGER_ENTRANDO + "newUsuario");
        final UsuarioDTO usuario = new UsuarioDTO();
        model.addObject("usuario", usuario);
        model.setViewName("usuario/usuarioAlta");
        LOGGER.info(Constantes.LOGGER_SALIENDO + "newUsuario");
        return model;
    }

    /**
     * <p>
     * Guarda un usuario
     * </p>
     *
     * @param usuario
     * @param result
     * @return
     * @throws IOException
     * @throws WebException
     */
    @RequestMapping(value = "/guardarUsuario", method = RequestMethod.POST)
    public ModelAndView saveUsuario(@Valid @ModelAttribute("usuario") final UsuarioDTO usuario, final BindingResult result, HttpServletRequest request)
            throws IOException, WebException {
        LOGGER.info(Constantes.LOGGER_ENTRANDO + "saveUsuario");
        ModelAndView model;
        // get reCAPTCHA request param
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        System.out.println(gRecaptchaResponse);
        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
        if (!verify) {
           usuario.setRecaptchaMessage(this.mensajeErrorRecaptcha);
        }

        if (result.hasErrors() || !verify) {
            model = new ModelAndView("usuario/usuarioAlta");
        } else {
            model = new ModelAndView();
            try {
                Usuario usuarioBO = usuario.invert();
                if (usuario.getId() == 0) {
                    // if employee id is 0 then creating the
                    // employee other updating the employee
                    iUsuarioBusiness.add(usuarioBO);
                } else {
                    iUsuarioBusiness.saveOrUpdate(usuarioBO);
                }

                model = listUsuarios(new ModelAndView());

            } catch (BusinessException e) {
                throw new WebException(e.getMessage(), e.getCause());
            }
        }
        LOGGER.info(Constantes.LOGGER_SALIENDO + "saveUsuario");
        return model;
    }

    /**
     * <p>
     * Controller borra un usuario
     * <p>
     *
     * @author nconde
     * @param request
     * @return
     * @throws IOException
     * @throws WebException
     */
    @RequestMapping(value = "/borrarUsuario", method = RequestMethod.GET)
    public ModelAndView borrarUsuario(final HttpServletRequest request) throws IOException, WebException {
        LOGGER.info(Constantes.LOGGER_ENTRANDO + "borrarUsuario");
        ModelAndView model = new ModelAndView();
        try {
            final int idUsuario = Integer.parseInt(request.getParameter("id"));
            final Usuario usuario = new Usuario();
            usuario.setId(idUsuario);
            iUsuarioBusiness.remove(usuario);
            model = listUsuarios(model);
        } catch (BusinessException e) {
            throw new WebException(e.getMessage(), e.getCause());
        }
        LOGGER.info(Constantes.LOGGER_SALIENDO + "borrarUsuario");
        return model;
    }

    /**
     * <p>
     * Controller borra un usuario
     * <p>
     *
     * @author nconde
     * @param request
     * @return
     * @throws IOException
     * @throws WebException
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(final HttpServletRequest request, HttpServletResponse response)
            throws IOException, WebException {
        LOGGER.info(Constantes.LOGGER_ENTRANDO + "logout");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        ModelAndView model = new ModelAndView("login");
        LOGGER.info(Constantes.LOGGER_SALIENDO + "logout");
        return model;
    }

    /**
     * <p>
     * Controller Modifica un usuario
     * </p>
     *
     * @param request
     * @return
     * @throws WebException
     */
    @RequestMapping(value = "/modifcarUsuario", method = RequestMethod.GET)
    public ModelAndView editContact(final HttpServletRequest request) throws WebException {
        LOGGER.info(Constantes.LOGGER_ENTRANDO + "editContact");
        ModelAndView model = null;
        try {
            final int idUsuario = Integer.parseInt(request.getParameter("id"));
            final Usuario usuarioBO = iUsuarioBusiness.get(idUsuario);
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.convert(usuarioBO);
            model = new ModelAndView("usuario/usuarioAlta");
            model.addObject("usuario", usuarioDTO);

        } catch (BusinessException e) {
            throw new WebException(e.getMessage(), e.getCause());
        }
        LOGGER.info(Constantes.LOGGER_SALIENDO + "editContact");
        return model;
    }

    /**
     * <p>
     * Genera un reporte de usuarios
     * </p>
     *
     * @param response
     * @return ResponseEntity<byte[]>
     * @throws WebException
     * @since nconde
     * @since 20/03/2017
     */
    @RequestMapping(value = "/reporteUsuario", method = RequestMethod.GET)
    public ResponseEntity<byte[]> reportsContact(final HttpServletResponse response) throws WebException {
        LOGGER.info(Constantes.LOGGER_ENTRANDO + "reportsContact");
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=usuariosReportes.pdf");

        try {

            final byte[] pdf = iUsuarioBusiness.reportsUsuarios();
            response.setContentLength(pdf.length);
            response.getOutputStream().write(pdf);
            response.getOutputStream().flush();
        } catch (IOException e) {
            throw new WebException(e.getMessage(), e.getCause());
        } catch (BusinessException e) {
            throw new WebException(e.getMessage(), e.getCause());
        }
        LOGGER.info(Constantes.LOGGER_SALIENDO + "reportsContact");
        return null;
    }

    /**
     * <p>
     * Llamamos al webservices del dolar hoy y verificamos que valor trae
     * </p>
     *
     * @param usuario
     * @return
     * @throws WebException
     */
    @ResponseBody
    @RequestMapping(value = "/dolarHoy", method = RequestMethod.POST)
    public String updateHosting(@RequestBody final Usuario usuario) throws WebException {
        LOGGER.info(Constantes.LOGGER_ENTRANDO + "updateHosting");
        String valorDolar;
        try {
            valorDolar = iUsuarioBusiness.traerDatosDesdeWebservices();
        } catch (BusinessException e) {
            throw new WebException(e.getMessage(), e.getCause());
        }
        LOGGER.info(Constantes.LOGGER_SALIENDO + "updateHosting");
        return valorDolar;
    }

    /**
     * <p>
     * Forzador de Excepcion business
     * </p>
     *
     * @param response
     * @return ResponseEntity<byte[]>
     * @throws WebException
     * @throws BusinessException
     * @since nconde
     * @since 20/03/2017
     */
    @RequestMapping(value = "/excepcionUsuario", method = RequestMethod.GET)
    public ModelAndView forzarExcepcion(final HttpServletRequest request) throws WebException {
        LOGGER.info(Constantes.LOGGER_ENTRANDO + "forzarExcepcion");
        try {

            iUsuarioBusiness.pruebalanzarExcepcion();
        } catch (BusinessException e) {
            throw new WebException(e.getMessage(), e.getCause());
        }
        LOGGER.info(Constantes.LOGGER_SALIENDO + "forzarExcepcion");
        return new ModelAndView();
    }

    /**
     * @return the iUsuarioBusiness
     */
    public IUsuarioBusiness getiUsuarioBusiness() {
        return iUsuarioBusiness;
    }

    /**
     * @param iUsuarioBusiness
     *            the iUsuarioBusiness to set
     */
    public void setiUsuarioBusiness(final IUsuarioBusiness iUsuarioBusiness) {
        this.iUsuarioBusiness = iUsuarioBusiness;
    }

    /**
     * @return the mensajeErrorRecaptcha
     */
    public String getMensajeErrorRecaptcha() {
        return mensajeErrorRecaptcha;
    }

    /**
     * @param mensajeErrorRecaptcha the mensajeErrorRecaptcha to set
     */
    public void setMensajeErrorRecaptcha(String mensajeErrorRecaptcha) {
        this.mensajeErrorRecaptcha = mensajeErrorRecaptcha;
    }

}
