package com.cloudsrcsoft.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value = "/loginProcess", method = RequestMethod.GET)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response) {	  	  
		  ModelAndView mav = new ModelAndView();
			  if (request.isUserInRole("ROLE_ADMIN")) 
				  mav.setViewName("Inicio");
			  if (request.isUserInRole("ROLE_USER")) 
				  mav.setViewName("Cliente");
			  if (request.isUserInRole("ROLE_SUPER")) 
				  mav.setViewName("Admin");
	    return mav;
	  }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Datos invalidos!");
		}
		if (logout != null) {
			model.addObject("msg", "Sesion finalizada correctamente.");
		}
		model.setViewName("login");
		return model;
	}
}
