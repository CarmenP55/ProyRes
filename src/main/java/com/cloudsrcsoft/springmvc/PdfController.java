package com.cloudsrcsoft.springmvc;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.cloudsrcsoft.beans.*;
import com.cloudsrcsoft.dao.VerDaoImpl;


@Controller
public class PdfController {	
	@Autowired
	VerDaoImpl verDaoImpl;
	
	@RequestMapping(value="Proyecto.pdf")
	ModelAndView generatePdf(HttpServletRequest request,
			  HttpServletResponse response) throws Exception {
			  int proyectoId = Integer.parseInt(request.getParameter("id_proyecto"));
		      List<Requerimientos> listRequerimientos = verDaoImpl.verRequerimientosPro(proyectoId);
		      List<Diseno> listDiseno = verDaoImpl.verDisenoPro(proyectoId);
		      List<Pruebas> listPruebas = verDaoImpl.verPruebasPro(proyectoId);
		      List<Riesgos> listRiesgos = verDaoImpl.verRiesgosPro(proyectoId);
		      Empresa empresa=verDaoImpl.getDetailsEmp(proyectoId);
		      User userDes=verDaoImpl.getDetailsUs(proyectoId);
		      User userRes=verDaoImpl.getDetailsRes(proyectoId);
		      Proyectos proyectos = verDaoImpl.getDetailsPro(proyectoId);
		      ModelAndView model = new ModelAndView("pdfView", "command", proyectos);
		      model.addObject("listRequerimientos", listRequerimientos);
		      model.addObject("listDiseno", listDiseno);
		      model.addObject("listPruebas", listPruebas);
		      model.addObject("listRiesgos", listRiesgos);
		      model.addObject("userDes", userDes);
		      model.addObject("userRes", userRes);
		      model.addObject("empresa", empresa);
		      model.addObject("proyectos", proyectos);
		      return model;
	}
	
	@RequestMapping(value="ET.pdf")
	ModelAndView generatePdfET(HttpServletRequest request,
			  HttpServletResponse response) throws Exception {
			  int proyectoId = Integer.parseInt(request.getParameter("id_proyecto"));
		      List<Diseno> listDiseno = verDaoImpl.verDisenoPro(proyectoId);
		      Proyectos proyectos = verDaoImpl.getDetailsPro(proyectoId);
		      Empresa empresa=verDaoImpl.getDetailsEmp(proyectoId);
		      User user=verDaoImpl.getDetailsUs(proyectoId);
		      ModelAndView model = new ModelAndView("et", "empresa", empresa);
		      model.addObject("listDiseno", listDiseno);
		      model.addObject("proyectos", proyectos);
		      model.addObject("userDes", user);
		      return model;
	}	
}