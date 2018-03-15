package com.cloudsrcsoft.springmvc;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cloudsrcsoft.beans.*;
import com.cloudsrcsoft.dao.VerDaoImpl;

@Controller
public class Basic {	
	@Autowired
	VerDaoImpl verDao;
	//pagina principal amdinistrador
	@RequestMapping(value="irInicio**", method = RequestMethod.GET)
	public ModelAndView inicio(){
		ModelAndView model=new ModelAndView();
		model.setViewName("Inicio");
		return model;
	}
	//pagina principal super
	@RequestMapping(value="Admin**")
	public ModelAndView inicioAdmin(){
		ModelAndView model=new ModelAndView();
		model.setViewName("Admin");
		return model;
	}	
	
	@RequestMapping(value="Registros", method = RequestMethod.GET)
	public ModelAndView reg(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView MV=new ModelAndView();
		MV.setViewName("Registros");
		return MV;
	}

	
	@RequestMapping(value="RegistrosA", method = RequestMethod.GET)
	public ModelAndView regA(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id_proyecto"));
		ModelAndView MV=new ModelAndView();
		MV.setViewName("RegistrosA");
		List<Modulo> listModulos=verDao.verModulos(id);
		List<Diseno> listDiseno=verDao.verDiseno(id);
		List<Pruebas> listPruebas=verDao.verPruebasPro(id);
		List<Requerimientos> listRequerimientos=verDao.verRequerimientosPro(id);
		List<Riesgos> listRiesgos=verDao.verRiesgosPro(id);
		MV.addObject("diseno", new Diseno());
		MV.addObject("modulo", new Modulo());
		MV.addObject("req", new Requerimientos());
		MV.addObject("pruebas", new Pruebas());
		MV.addObject("riesgos", new Riesgos());
		MV.addObject("listModulos", listModulos);
		MV.addObject("listDiseno", listDiseno);
		MV.addObject("listRiesgos", listRiesgos);
		MV.addObject("listRequerimientos", listRequerimientos);
		MV.addObject("listPruebas", listPruebas);
		return MV;
	}
	//ver p admin
	@RequestMapping("ListaPro")
	public ModelAndView regP() {
		ModelAndView MV=new ModelAndView();
		List<Proyectos> listProyectos= verDao.verProyectos();
		MV.setViewName("ListaProyectos");
		MV.addObject("listProyectos", listProyectos);
		return MV;
	}
	//lista p su
	@RequestMapping("ListaProA")
	public ModelAndView regPA() {
		ModelAndView MV=new ModelAndView();
		List<Proyectos> listProyectos= verDao.verProyectos();
		MV.setViewName("ListaProyectosA");
		MV.addObject("listProyectos", listProyectos);
		return MV;
	}
	
	@RequestMapping("ProyectosAd.html**")
	public ModelAndView proyectosAdmin() {
		ModelAndView MV=new ModelAndView();
		List<Proyectos> listProyectos= verDao.verProyectos();
		List<Empresa> listEmpresas=verDao.verEmpresa();
		MV.setViewName("ProyectosAd");
		MV.addObject("listProyectos", listProyectos);
		MV.addObject("listEmpresas", listEmpresas);
		MV.addObject("proyectos", new Proyectos());
		return MV;
	}
	//lista p admin
	@RequestMapping("ListaVer**")
	public ModelAndView regPV() {
		ModelAndView MV=new ModelAndView();
		List<Proyectos> listProyectos= verDao.verProyectos();
		MV.setViewName("ListaProyectosVer");
		MV.addObject("listProyectos", listProyectos);
		return MV;
	}		
		
}
