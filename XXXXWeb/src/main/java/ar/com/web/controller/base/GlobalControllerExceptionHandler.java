package ar.com.web.controller.base;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import ar.com.web.controller.exceptions.WebException;

/**
 * <p>Manejador de expceciones</p>
 * @author usuario
 * @since 23/03/2017
 *
 */
@ControllerAdvice
class GlobalControllerExceptionHandler {

    /**
     * <p>Url de la pagina de error</p>
     */
    public static final String DEFAULT_ERROR_VIEW = "base/error";


    /**
     * <p>Atrapa los errores por default.</p>
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = WebException.class)
    public ModelAndView   defaultErrorHandler(final HttpServletRequest req, final Exception e)  {

     final  ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
      mav.addObject("name", e.getClass().getSimpleName());
	  mav.addObject("message", e.getMessage());
	  mav.addObject("stack", e.getCause().getMessage());
      return mav;
    }


//    @ExceptionHandler(NoHandlerFoundException.class)
//    @ResponseStatus(value= HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public ErrorResponse requestHandlingNoHandlerFound() {
//        return new ErrorResponse("custom_404", "message for 404 error code");
//    }
}
