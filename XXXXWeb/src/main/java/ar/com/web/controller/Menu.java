package ar.com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * <p>Controlador del menu.</p>
 * @author nconde
 * @since 28/03/2017
 *
 */
@Controller
public class Menu {


    /**
     * <p>Redirecciona al menu</p>
     * @return
     */
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		final String message = "<br><div style='text-align:center;'>"
				+ "<h3>Menu</h3>Este mensaje viene de menu Menu.java</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}

}