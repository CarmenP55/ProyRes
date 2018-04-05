package com.cloudsrcsoft.springmvc;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cloudsrcsoft.beans.*;
import com.cloudsrcsoft.dao.UserDaoImpl;
import com.cloudsrcsoft.dao.VerDaoImpl;

@Controller
public class RegistrationController {
  @Autowired
  public UserDaoImpl userDaoImpl;
  
  @Autowired
  public VerDaoImpl verDaoImpl;
  
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView("register");
	  List<Empresa> listEmpresa = verDaoImpl.verEmpresa();
	  mav.addObject("listEmpresa", listEmpresa);
	  mav.addObject("user", new User());
	  return mav;
  }
  
  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("user") User user) {
	  userDaoImpl.register(user);
	  ModelAndView mav = new ModelAndView("Admin");
  	  mav.addObject("enviados", "Los datos han sido enviados!");
	  return mav;
  }
  
  @RequestMapping(value = "/disenoProcessA", method = RequestMethod.POST)
  public ModelAndView addDisA(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("diseno") Diseno diseno) {
	  userDaoImpl.diseno(diseno);  
	  ModelAndView mav = new ModelAndView("Admin");
	  mav.addObject("diseno", new Diseno());
	  mav.addObject("enviados", "Los datos han sido enviados!");
	  return mav;
  }
  
  @RequestMapping(value = "/TareasC.html", method = RequestMethod.GET)
  public ModelAndView showRegister2s(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView("TareasC");	 	 
	  return mav;
  }
	
  @RequestMapping(value = "/register2", method = RequestMethod.GET)
  public ModelAndView showRegister2(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView("registrar");
	  List<Empresa> listEmpresa = verDaoImpl.verEmpresa();
	  mav.addObject("listEmpresa", listEmpresa);
	  mav.addObject("user", new User());
	  return mav;
  }
  
  @RequestMapping(value = "/registerProcessD", method = RequestMethod.POST)
  public ModelAndView addUsera(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("user") User user) {
	  userDaoImpl.register(user);
	  ModelAndView mav = new ModelAndView("Inicio");
  	  mav.addObject("enviados", "Los datos han sido enviados!");
	  return mav;
  }
  //add proy ad
  @RequestMapping(value = "/Alta", method = RequestMethod.GET)
  public ModelAndView showProyectos(HttpServletRequest request, HttpServletResponse response) {
 	  int emId = Integer.parseInt(request.getParameter("id"));
	  List<User> listUsuarios = verDaoImpl.getUserBy(emId);
	  List<User> listUsuarios2 = verDaoImpl.getUserByType();
	  ModelAndView mav = new ModelAndView("AltaProyectos");
	  mav.addObject("listUsuarios", listUsuarios);
	  mav.addObject("listUsuarios2", listUsuarios2);
	  mav.addObject("proyectos", new Proyectos());
	  return mav;
  }
  //add proy su
  @RequestMapping(value = "/AltaA**", method = RequestMethod.GET)
  public ModelAndView showProyectosA(HttpServletRequest request, HttpServletResponse response) {
 	  int emId = Integer.parseInt(request.getParameter("id"));
	  List<User> listUsuarios = verDaoImpl.getUserBy(emId);
	  List<User> listUsuarios2 = verDaoImpl.getUserByType();
	  ModelAndView mav = new ModelAndView("AltaProyectosA");
	  mav.addObject("listUsuarios", listUsuarios);
	  mav.addObject("listUsuarios2", listUsuarios2);
	  mav.addObject("proyectos", new Proyectos());
	  return mav;
  }
  
  @RequestMapping(value = "/proyectosProcessA", method = RequestMethod.POST)
  public ModelAndView addProyectoA(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("proyectos") Proyectos proyectos) {
	 userDaoImpl.proyectos(proyectos);
	 ModelAndView mav = new ModelAndView("Admin");
	 mav.addObject("proyectos", new Proyectos());
 	 mav.addObject("enviados", "Los datos han sido enviados!");
	 return mav;
  }
  
  @RequestMapping(value="/Proyectos.html**")
	public ModelAndView listEmp(ModelAndView model) throws IOException{
	  List<Empresa> listEmpresa = verDaoImpl.verEmpresa();
	  model.addObject("listEmpresa", listEmpresa);
	  model.setViewName("Proyecto");
	  return model;
	}
  
  @RequestMapping(value = "/proyectosProcess", method = RequestMethod.POST)
  public ModelAndView addProyecto(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("proyectos") Proyectos proyectos) {
	 userDaoImpl.proyectos(proyectos);
	 ModelAndView mav = new ModelAndView("Inicio");
	 mav.addObject("proyectos", new Proyectos());
 	 mav.addObject("enviados", "Los datos han sido enviados!");
	 return mav;
  }
  //reg mod ad
  @RequestMapping(value = "/Modulos.html", method = RequestMethod.GET)
  public ModelAndView crearModulos(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("AltaModulos");
    List<Proyectos> listProyectos = verDaoImpl.verProyectos();
	mav.addObject("listProyectos", listProyectos);
	mav.addObject("modulo", new Modulo());
    return mav;
  }  
  
  @RequestMapping(value = "/modulosProcess", method = RequestMethod.POST)
  public ModelAndView addModulo(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("modulo") Modulo modulo) {	  
	  userDaoImpl.modulo(modulo);
	  ModelAndView mav = new ModelAndView("Inicio");
	  mav.addObject("modulo", new Modulo());
	  mav.addObject("enviados", "Los datos han sido enviados!");
	  return mav;
  }

  @RequestMapping(value = "/modulosProcessA", method = RequestMethod.POST)
  public ModelAndView addModuloA(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("modulo") Modulo modulo) {
  userDaoImpl.modulo(modulo);
  ModelAndView mav = new ModelAndView("Admin");
  mav.addObject("modulo", new Modulo());  
  mav.addObject("enviados", "Los datos han sido enviados!");
  return mav;
  }
  //add req ad
  @RequestMapping(value = "/Requerimientos.html**", method = RequestMethod.GET)
  public ModelAndView showReq(HttpServletRequest request, HttpServletResponse response) {
	int id = Integer.parseInt(request.getParameter("id_proyecto"));
    ModelAndView mav = new ModelAndView("AltaRequerimientos");
    List<Modulo> listModulos = verDaoImpl.verModulos(id);
	mav.addObject("listModulos", listModulos);
    mav.addObject("requerimientos", new Requerimientos());
    return mav;
  }
  
  @RequestMapping(value = "/reqProcess", method = RequestMethod.POST)
  public ModelAndView addReq(HttpServletResponse response, HttpServletRequest request, 
  @RequestParam("archivo") MultipartFile archivo) throws IOException{
	  Requerimientos requerimientos= new Requerimientos();
	  requerimientos.setNombre_archivo(archivo.getOriginalFilename());
	  requerimientos.setTipo_archivo(archivo.getContentType());     
	  requerimientos.setArchivo(archivo.getBytes());	  
	  requerimientos.setId_pro(Integer.parseInt(request.getParameter("id_pro")));
	  requerimientos.setId_mod(Integer.parseInt(request.getParameter("id_mod")));
	  requerimientos.setTipo(request.getParameter("tipo"));
	  requerimientos.setActividad(request.getParameter("actividad"));
	  requerimientos.setDescripcion(request.getParameter("descripcion"));
	  requerimientos.setCriticidad(request.getParameter("criticidad"));
	  requerimientos.setAccion(request.getParameter("accion"));
	  requerimientos.setEntrega(request.getParameter("entrega"));
	  requerimientos.setSolucion(request.getParameter("solucion"));
	  requerimientos.setComentarios(request.getParameter("comentarios"));
	  userDaoImpl.requerimientos(requerimientos);
	  ModelAndView mav = new ModelAndView("Inicio");
	  mav.addObject("requerimientos", new Requerimientos());
  	  mav.addObject("enviados", "Los datos han sido enviados!");
	  return mav;
  }
  //add req su
  @RequestMapping(value = "/RequerimientosA.html**", method = RequestMethod.GET)
  public ModelAndView showReqA(HttpServletRequest request, HttpServletResponse response) {
	int id = Integer.parseInt(request.getParameter("id_proyecto"));
    ModelAndView mav = new ModelAndView("AltaRequerimientosA");
    List<Modulo> listModulos = verDaoImpl.verModulos(id);
	mav.addObject("listModulos", listModulos);
    mav.addObject("requerimientos", new Requerimientos());
    return mav;
  }
  
  @RequestMapping(value = "/reqProcessA", method = RequestMethod.POST)
  public ModelAndView addReqA(HttpServletResponse response, HttpServletRequest request, 
  @RequestParam("archivo") MultipartFile archivo) throws IOException{
	  Requerimientos requerimientos= new Requerimientos();
	  requerimientos.setNombre_archivo(archivo.getOriginalFilename());
	  requerimientos.setTipo_archivo(archivo.getContentType());     
	  requerimientos.setArchivo(archivo.getBytes());	  
	  requerimientos.setId_pro(Integer.parseInt(request.getParameter("id_pro")));
	  requerimientos.setId_mod(Integer.parseInt(request.getParameter("id_mod")));
	  requerimientos.setTipo(request.getParameter("tipo"));
	  requerimientos.setActividad(request.getParameter("actividad"));
	  requerimientos.setDescripcion(request.getParameter("descripcion"));
	  requerimientos.setCriticidad(request.getParameter("criticidad"));
	  requerimientos.setEntrega(request.getParameter("entrega"));
	  requerimientos.setAccion(request.getParameter("accion"));
	  requerimientos.setSolucion(request.getParameter("solucion"));
	  requerimientos.setComentarios(request.getParameter("comentarios"));
	  userDaoImpl.requerimientos(requerimientos);
	  ModelAndView mav = new ModelAndView("Admin");
	  mav.addObject("requerimientos", new Requerimientos());
  	  mav.addObject("enviados", "Los datos han sido enviados!");
	  return mav;
  }
  
  //LISTA DE modulos paara despues ingresar el diseño
  @RequestMapping(value = "/ModDis.html**", method = RequestMethod.GET)
  public ModelAndView showDisD(HttpServletRequest request, HttpServletResponse response) {
	  int id = Integer.parseInt(request.getParameter("id_proyecto"));
	  List<Modulo> listModulos = verDaoImpl.verModulos(id);
	  ModelAndView mav = new ModelAndView("ListaModulosD");
	  mav.addObject("listModulos", listModulos);
	  return mav;
  }
  
  @RequestMapping(value = "/ModDisT.html", method = RequestMethod.GET)
  public ModelAndView showDisDS(HttpServletRequest request, HttpServletResponse response) {
	  int id = Integer.parseInt(request.getParameter("id_proyecto"));
	  List<Modulo> listModulos = verDaoImpl.verModulos(id);
	  ModelAndView mav = new ModelAndView("ListaDisenoTareas");
	  mav.addObject("listModulos", listModulos);
	  return mav;
  }
  
  //reg dis ad
  @RequestMapping(value = "/Disenio.html", method = RequestMethod.GET)
  public ModelAndView showDis(HttpServletRequest request, HttpServletResponse response) {
	  int id = Integer.parseInt(request.getParameter("id"));
	  ModelAndView mav = new ModelAndView("AltaDiseno");
	  List<Requerimientos> listRequerimientos = verDaoImpl.verRequerimientos(id);
	  mav.addObject("listRequerimientos", listRequerimientos);
	  mav.addObject("diseno", new Diseno());
	  return mav;
  }
  //reg dis sup
  @RequestMapping(value = "/DisenioA.html", method = RequestMethod.GET)
  public ModelAndView showDisA(HttpServletRequest request, HttpServletResponse response) {
	  int id = Integer.parseInt(request.getParameter("id"));
	  ModelAndView mav = new ModelAndView("AltaDisenoA");
	  List<Requerimientos> listRequerimientos = verDaoImpl.verRequerimientos(id);
	  mav.addObject("listRequerimientos", listRequerimientos);
	  mav.addObject("diseno", new Diseno());
	  return mav;
  }
  
  @RequestMapping(value = "/CrearTareas.html", method = RequestMethod.GET)
  public ModelAndView showDisAs(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView("Tareas");
	  mav.addObject("tareas", new Tareas());
	  return mav;
  }
  
  
  @RequestMapping(value = "/subtareasC", method = RequestMethod.POST)
  public ModelAndView addTareasC(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("subtareas") SubTareas subtareas) {
	  //userDaoImpl.tareas(subtareas);  
	  ModelAndView mav = new ModelAndView("Admin");
	  mav.addObject("subtareas", new SubTareas());
  	  mav.addObject("enviados", "Los datos han sido enviados!");
	  return mav;
  }
  
  @RequestMapping(value = "/tareasProcessC", method = RequestMethod.POST)
  public ModelAndView addTareas(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("tareas") Tareas tareas) {
	  userDaoImpl.tareas(tareas);  
	  ModelAndView mav = new ModelAndView("Admin");
  	  mav.addObject("enviados", "Los datos han sido enviados!");
	  mav.addObject("tareas", new Tareas());
	  return mav;
  }
  
  @RequestMapping(value = "/CrearSub.html", method = RequestMethod.GET)
  public ModelAndView showDisAsD(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView("Subtareas");
	  List<Tareas> listTareas = verDaoImpl.verTareas();
	  mav.addObject("subtareas", new SubTareas());
	  mav.addObject("listTareas", listTareas);
	  return mav;
  }
  
  @RequestMapping(value = "/subProcess", method = RequestMethod.POST)
  public ModelAndView addTareasD(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("tareas") SubTareas subtareas) {
	  userDaoImpl.subtareas(subtareas);  
	  ModelAndView mav = new ModelAndView("Admin");
	  mav.addObject("tareas", new Tareas());	  
  	  mav.addObject("enviados", "Los datos han sido enviados!");
	  return mav;
  }
  
  @RequestMapping(value = "/disenoProcess", method = RequestMethod.POST)
  public ModelAndView addDis(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("diseno") Diseno diseno) {
	  userDaoImpl.diseno(diseno);  
	  ModelAndView mav = new ModelAndView("Inicio");
	  mav.addObject("diseno", new Diseno());
  	  mav.addObject("enviados", "Los datos han sido enviados!");
	  return mav;
  }
  
  @RequestMapping(value = "/Riesgos.html**", method = RequestMethod.GET)
  public ModelAndView showRie(HttpServletRequest request, HttpServletResponse response) {
	  int id = Integer.parseInt(request.getParameter("id_proyecto"));
	  Proyectos pro=verDaoImpl.getById(id);
	  if (pro.getModelo().equals("Cascada")) {
		  ModelAndView mav = new ModelAndView("Inicio");
		  mav.addObject("msg", "El metodo Cascada no gestiona riesgos");
		  return mav;
	  }
	  else {
		  ModelAndView mav = new ModelAndView("AltaRiesgos");
		  List<Modulo> listModulos = verDaoImpl.verModulos(id);
		  mav.addObject("listModulos", listModulos);
		  mav.addObject("riesgos", new Riesgos());
		  return mav;
	  }
  }
  
  @RequestMapping(value = "/riesgosProcess", method = RequestMethod.POST)
  public ModelAndView addRie(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("riesgos") Riesgos riesgos) {
	  userDaoImpl.riesgos(riesgos);
	  ModelAndView mav = new ModelAndView("Inicio");
	  mav.addObject("riesgos", new Riesgos());
  	  mav.addObject("enviados", "Los datos han sido enviados!");
	  return mav;
  }
  
  @RequestMapping(value = "/RiesgosA.html**", method = RequestMethod.GET)
  public ModelAndView showRieA(HttpServletRequest request, HttpServletResponse response) {
	  int id = Integer.parseInt(request.getParameter("id_proyecto"));
	  ModelAndView mav = new ModelAndView("AltaRiesgosA");
	  List<Modulo> listModulos = verDaoImpl.verModulos(id);
	  mav.addObject("listModulos", listModulos);
	  mav.addObject("riesgos", new Riesgos());
	  return mav;
  }
  
  @RequestMapping(value = "/riesgosProcessA", method = RequestMethod.POST)
  public ModelAndView addRieA(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("riesgos") Riesgos riesgos) {
	  userDaoImpl.riesgos(riesgos);
	  ModelAndView mav = new ModelAndView("Admin");
  	  mav.addObject("enviados", "Los datos han sido enviados!");
	  mav.addObject("riesgos", new Riesgos());
	  return mav;
  }
 
  @RequestMapping(value = "/Empresa.html**", method = RequestMethod.GET)
  public ModelAndView showEm(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView("Empresa");
	  mav.addObject("empresa", new Empresa());
	  return mav;
  }
  
  @RequestMapping(value = "/empresaProcess", method = RequestMethod.POST)
  public ModelAndView addEm(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("empresa") Empresa empresa) {
	  userDaoImpl.empresa(empresa);
	  ModelAndView mav = new ModelAndView("Inicio");
  	  mav.addObject("enviados", "Los datos han sido enviados!");
	  mav.addObject("empresa", new Empresa());
	  return mav;
  }
  
  @RequestMapping(value = "/EmpresaA.html**", method = RequestMethod.GET)
  public ModelAndView showEmA(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView("EmpresaA");
	  mav.addObject("empresa", new Empresa());
	  return mav;
  }
  
  @RequestMapping(value = "/empresaProcessA", method = RequestMethod.POST)
  public ModelAndView addEmA(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("empresa") Empresa empresa) {
	  userDaoImpl.empresa(empresa);
	  ModelAndView mav = new ModelAndView("Admin");
  	  mav.addObject("enviados", "Los datos han sido enviados!");
	  mav.addObject("empresa", new Empresa());
	  return mav;
  }
 //add pru ad
  @RequestMapping(value = "/Pruebas.html**", method = RequestMethod.GET)
  public ModelAndView showPrue(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView("AltaPruebas");
	  int id = Integer.parseInt(request.getParameter("id"));
	  List<Requerimientos> listRequerimientos = verDaoImpl.verRequerimientos(id);
	  mav.addObject("listRequerimientos", listRequerimientos);
	  List<User> listUsuarios=verDaoImpl.getUserByType();
	  mav.addObject("pruebas", new Pruebas());
	  mav.addObject("listUsuarios", listUsuarios);
	  return mav;
  }
  
  @RequestMapping(value = "/pruebasProcess", method = RequestMethod.POST)
  public ModelAndView addPrue(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("Pruebas") Pruebas pruebas) {
	  userDaoImpl.pruebas(pruebas);
	  ModelAndView mav = new ModelAndView("Inicio");
  	  mav.addObject("enviados", "Los datos han sido enviados!");
	  mav.addObject("pruebas", new Pruebas());
	  return mav;
  }
  //add pru su
  @RequestMapping(value = "/PruebasA.html**", method = RequestMethod.GET)
  public ModelAndView showPrueA(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView("AltaPruebasA");
	  int id = Integer.parseInt(request.getParameter("id"));
	  List<User> listUsuarios=verDaoImpl.getUserByType();
	  List<Requerimientos> listRequerimientos = verDaoImpl.verRequerimientos(id);
	  mav.addObject("listRequerimientos", listRequerimientos);
	  mav.addObject("pruebas", new Pruebas());
	  mav.addObject("listUsuarios", listUsuarios);
	  return mav;
  }
  
  @RequestMapping(value = "/pruebasProcessA", method = RequestMethod.POST)
  public ModelAndView addPrueA(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("Pruebas") Pruebas pruebas) {
	  userDaoImpl.pruebas(pruebas);
	  ModelAndView mav = new ModelAndView("Admin");	
  	  mav.addObject("enviados", "Los datos han sido enviados!");
	  mav.addObject("pruebas", new Pruebas());
	  return mav;
  }
  
  @RequestMapping(value = "/Mantenimiento.html", method = RequestMethod.GET)
  public ModelAndView addMant(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView("Mantenimiento");
	  return mav;
  }
  
  @RequestMapping(value = "/Cliente.html**", method = RequestMethod.GET)
  public ModelAndView cliente(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView("Cliente");
	  return mav;
  }
  //issues admin
  @RequestMapping(value = "/IssuesD.html**", method = RequestMethod.GET)
  public ModelAndView showIssu(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView("Issues");
	  List<Proyectos> listProyectos = verDaoImpl.verProyectos();
	  mav.addObject("listProyectos", listProyectos);
	  mav.addObject("issues", new Issues());
	  String e = request.getParameter("e");
	  User l=verDaoImpl.getUserBy(e);
	  int id=l.getId();
	  mav.addObject("id", id);
	  return mav;
  }
  
  @RequestMapping(value = "/issuesProcess", method = RequestMethod.POST)
	public ModelAndView iss(HttpServletRequest request, @RequestParam("archivo") MultipartFile archivo) throws IOException{
		Issues issues = new Issues();
		issues.setProyecto(Integer.parseInt(request.getParameter("proyecto")));
		issues.setDescripcion(request.getParameter("descripcion"));
		issues.setCriticidad(request.getParameter("criticidad"));
		issues.setComentarios(request.getParameter("comentarios"));
		issues.setSolicitante(request.getParameter("solicitante"));
		issues.setNombre(archivo.getOriginalFilename());
	    issues.setType(archivo.getContentType());     
	    issues.setArchivo(archivo.getBytes());
	    ModelAndView mav=null;
	    int id = Integer.parseInt(request.getParameter("id_sol"));
	    issues.setId_sol(id);
	    if (id==0) {
	    	mav = new ModelAndView("Inicio");
	    	mav.addObject("errorMessage", "No se ha encontrado el solicitante");
	    }
	    else {
	    	userDaoImpl.issues(issues);
			mav = new ModelAndView("Inicio");
	    	mav.addObject("enviados", "Los datos han sido enviados!");
	    }
	    		
		return mav;
	}
  
  //add is cli
  @RequestMapping(value = "/Issues", method = RequestMethod.GET)
  public ModelAndView issu(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView("IssuesC");
	  String e = request.getParameter("e");
	  User l=verDaoImpl.getUserBy(e);
	  int id=l.getId();
	  mav.addObject("id", id);
	  List<Proyectos> listProyectos = verDaoImpl.verProyectosC(id);
	  mav.addObject("listProyectos", listProyectos);
	  mav.addObject("issues", new Issues());
	  return mav;
  }
  //add iss cli
  @RequestMapping(value = "/issuesP", method = RequestMethod.POST)
	public ModelAndView processFileP(HttpServletRequest request, @RequestParam("archivo") MultipartFile archivo) throws IOException{
		Issues issues = new Issues();
		issues.setDescripcion(request.getParameter("descripcion"));
		issues.setCriticidad(request.getParameter("criticidad"));
		issues.setComentarios(request.getParameter("comentarios"));
		issues.setSolicitante(request.getParameter("solicitante"));
		issues.setNombre(archivo.getOriginalFilename());
	    issues.setType(archivo.getContentType());     
	    issues.setArchivo(archivo.getBytes());
	    ModelAndView mav=null;
	    issues.setProyecto(Integer.parseInt(request.getParameter("proyecto")));
	    int id = Integer.parseInt(request.getParameter("id_sol"));
	    issues.setId_sol(id);
	    if (id==0) {
	    	mav = new ModelAndView("Cliente");
	    	mav.addObject("errorMessage", "No se ha encontrado el solicitante");
	    }
	    else {
	    	userDaoImpl.issues(issues);
			mav = new ModelAndView("Cliente");
	    	mav.addObject("enviados", "Los datos han sido enviados!");
	    }
	    		
		return mav;
	}
  //add iss su
  @RequestMapping(value = "/IssuesAdmin**", method = RequestMethod.GET)
  public ModelAndView issuA(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView("IssuesAdmin");
	  List<Proyectos> listProyectos = verDaoImpl.verProyectos();
	  mav.addObject("listProyectos", listProyectos);
	  String e = request.getParameter("e");
	  User l=verDaoImpl.getUserBy(e);
	  int id=l.getId();
	  mav.addObject("issues", new Issues());
	  mav.addObject("id", id);
	  return mav;
  }
  
	@RequestMapping(value = "/issuesProcessA", method = RequestMethod.POST)
	public ModelAndView processFileUpload(HttpServletRequest request, @RequestParam("archivo") MultipartFile archivo) throws IOException{
		Issues issues = new Issues();
		issues.setDescripcion(request.getParameter("descripcion"));
		issues.setCriticidad(request.getParameter("criticidad"));
		issues.setComentarios(request.getParameter("comentarios"));
		issues.setSolicitante(request.getParameter("solicitante"));
		issues.setNombre(archivo.getOriginalFilename());
	    issues.setType(archivo.getContentType());
	    issues.setProyecto(Integer.parseInt(request.getParameter("proyecto")));
	    issues.setArchivo(archivo.getBytes());
	    ModelAndView mav=null;
	    int id = Integer.parseInt(request.getParameter("id_sol"));
	    issues.setId_sol(id);
	    if (id==0) {
	    	mav = new ModelAndView("Admin");
	    	mav.addObject("errorMessage", "No se ha encontrado el solicitante");
	    }
	    else {
	    	userDaoImpl.issues(issues);
	    	mav = new ModelAndView("Admin");
	    	mav.addObject("enviados", "Los datos han sido enviados!");
	    }
	    		
		return mav;
	}
   
  @RequestMapping(value = "/Reportes.html", method = RequestMethod.GET)
  public ModelAndView addRep(HttpServletRequest request, HttpServletResponse response) {	  
	  ModelAndView mav = null;
	  try {
		  mav = new ModelAndView("Reportes");
		  String e = request.getParameter("e");	  
		  User l=verDaoImpl.getUserBy(e);
		  int id=l.getId();
		  List<Proyectos> listProyectos = verDaoImpl.verProyectosRes(id);
		  List<Actividades> listAct=verDaoImpl.verActividades();
		  mav.addObject("id", id);
		  mav.addObject("listAct", listAct);
		  mav.addObject("listProyectos", listProyectos);
		  mav.addObject("reportes", new Reportes());		  
	  }
	  catch (NullPointerException npe) {
		  mav = new ModelAndView("login");
	  }
	  
	  return mav;
  }
  
  @RequestMapping(value = "/reportesProcess", method = RequestMethod.POST)
  public ModelAndView addPrueF(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("Reportes") Reportes reportes) {
	  userDaoImpl.reportes(reportes);
	  ModelAndView mav = new ModelAndView("Inicio");
	  mav.addObject("enviados", "Los datos han sido enviados!");
	  return mav;
  }
  
  @RequestMapping(value = "/Actividades.html", method = RequestMethod.GET)
  public ModelAndView addAct(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView("Actividades");
	  mav.addObject("actividades", new Actividades());
	  return mav;
  }
  
  @RequestMapping(value = "/actividadesProcess", method = RequestMethod.POST)
  public ModelAndView addActF(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("Actividades") Actividades actividades) {
	  userDaoImpl.actividades(actividades);
	  ModelAndView mav = new ModelAndView("Admin");
  	  mav.addObject("enviados", "Los datos han sido enviados!");
	  return mav;
  }
  
}