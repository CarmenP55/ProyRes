package com.cloudsrcsoft.springmvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cloudsrcsoft.beans.*;
import com.cloudsrcsoft.dao.EditDaoImpl;
import com.cloudsrcsoft.dao.VerDaoImpl;

@Controller
public class EditController {
	@Autowired
	EditDaoImpl editDaoImpl;	
	@Autowired
	VerDaoImpl verDaoImpl;
	
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public ModelAndView saveProyecto(@ModelAttribute Proyectos proyectos) {
	      editDaoImpl.save(proyectos);
	      return new ModelAndView("Inicio");
	  }
	  
	  @RequestMapping(value = "/editProyecto", method = RequestMethod.GET)
	  public ModelAndView editProyecto(HttpServletRequest request) {
	      int proyectoId = Integer.parseInt(request.getParameter("id_proyecto"));
	      List<Empresa> listEmpresa = verDaoImpl.verEmpresa();
	  	  List<User> listUsuarios2 = verDaoImpl.getUserByType();
	      Proyectos proyectos = verDaoImpl.getById(proyectoId);
	      ModelAndView model = new ModelAndView("UpdateProyectos");
	      model.addObject("listEmpresa", listEmpresa);
	      model.addObject("proyectos", proyectos);
	      model.addObject("listUsuarios2", listUsuarios2);
	      return model;
	  }
	  
	  @RequestMapping(value = "/saveA", method = RequestMethod.POST)
	  public ModelAndView saveProyectoA(@ModelAttribute Proyectos proyectos) {
	      editDaoImpl.save(proyectos);
	      return new ModelAndView("Admin");
	  }
	  
	  @RequestMapping(value = "/editProyectoA", method = RequestMethod.GET)
	  public ModelAndView editProyectoA(HttpServletRequest request) {
	      int proyectoId = Integer.parseInt(request.getParameter("id_proyecto"));
	      List<Empresa> listEmpresa = verDaoImpl.verEmpresa();
	  	  List<User> listUsuarios2 = verDaoImpl.getUserByType();
	      Proyectos proyectos = verDaoImpl.getById(proyectoId);
	      ModelAndView model = new ModelAndView("UpdateProyectosAd");
	      model.addObject("listEmpresa", listEmpresa);
	      model.addObject("proyectos", proyectos);
	      model.addObject("listUsuarios2", listUsuarios2);
	      return model;
	  }
	  
	  @RequestMapping(value = "/updateMod", method = RequestMethod.POST)
	  public ModelAndView saveModulo(@ModelAttribute Modulo modulo) {
	      editDaoImpl.updateMod(modulo);
	      return new ModelAndView("Inicio");
	  }
	  
	  @RequestMapping(value = "/updateModulos", method = RequestMethod.GET)
	  public ModelAndView editModulo(HttpServletRequest request) {
	      int moduloId = Integer.parseInt(request.getParameter("id"));
	      Modulo modulo = verDaoImpl.getModulos(moduloId);
	      ModelAndView model = new ModelAndView("UpdateModulos");
	      model.addObject("modulo", modulo);
	      return model;
	  }
	  
	  @RequestMapping(value = "/updateModA", method = RequestMethod.POST)
	  public ModelAndView saveModuloA(@ModelAttribute Modulo modulo) {
	      editDaoImpl.updateMod(modulo);
	      return new ModelAndView("Admin");
	  }
	  
	  @RequestMapping(value = "/updateModulosA", method = RequestMethod.GET)
	  public ModelAndView editModuloA(HttpServletRequest request) {
	      int moduloId = Integer.parseInt(request.getParameter("id"));
	      Modulo modulo = verDaoImpl.getModulos(moduloId);
	      ModelAndView model = new ModelAndView("UpdateModulosA");
	      model.addObject("modulo", modulo);
	      return model;
	  }
	
	  @RequestMapping(value = "/updateReq", method = RequestMethod.POST)
	  public ModelAndView updateReq(@ModelAttribute Requerimientos requerimientos) {
	      editDaoImpl.updateReq(requerimientos);
	      return new ModelAndView("Inicio");
	  }
	  
	  @RequestMapping(value = "/updateRequerimiento", method = RequestMethod.GET)
	  public ModelAndView updateReq(HttpServletRequest request) {
	      int reqId = Integer.parseInt(request.getParameter("id_req"));
	      Requerimientos requerimientos = verDaoImpl.getReq(reqId);
	      ModelAndView model = new ModelAndView("UpdateReq");
	      model.addObject("requerimientos", requerimientos);
	      return model;
	  }
	  
	  @RequestMapping(value = "/updateReqA", method = RequestMethod.POST)
	  public ModelAndView updateReqA(@ModelAttribute Requerimientos requerimientos) {
	      editDaoImpl.updateReq(requerimientos);
	      return new ModelAndView("Admin");
	  }
	  
	  @RequestMapping(value = "/updateRequerimientoA", method = RequestMethod.GET)
	  public ModelAndView updateReqA(HttpServletRequest request) {
	      int reqId = Integer.parseInt(request.getParameter("id_req"));
	      Requerimientos requerimientos = verDaoImpl.getReq(reqId);
	      ModelAndView model = new ModelAndView("UpdateReqA");
	      model.addObject("requerimientos", requerimientos);
	      return model;
	  }
	  
	  @RequestMapping(value = "/updateDis", method = RequestMethod.POST)
	  public ModelAndView updateDis(@ModelAttribute Diseno diseno) {
	      editDaoImpl.updateDis(diseno);
	      return new ModelAndView("Inicio");
	  }
	  
	  @RequestMapping(value = "/updateDiseno", method = RequestMethod.GET)
	  public ModelAndView updateDise(HttpServletRequest request) {
	      int disId = Integer.parseInt(request.getParameter("id"));
	      Diseno diseno = verDaoImpl.getDis(disId);
	      ModelAndView model = new ModelAndView("UpdateDis");
	      model.addObject("diseno", diseno);
	      return model;
	  }
	  
	  @RequestMapping(value = "/updateDisA", method = RequestMethod.POST)
	  public ModelAndView updateDisA(@ModelAttribute Diseno diseno) {
	      editDaoImpl.updateDis(diseno);
	      return new ModelAndView("Admin");
	  }
	  
	  @RequestMapping(value = "/updateDisenoA", method = RequestMethod.GET)
	  public ModelAndView updateDiseA(HttpServletRequest request) {
	      int disId = Integer.parseInt(request.getParameter("id"));
	      Diseno diseno = verDaoImpl.getDis(disId);
	      ModelAndView model = new ModelAndView("UpdateDisA");
	      model.addObject("diseno", diseno);
	      return model;
	  }
	  
	  @RequestMapping(value = "/updatePru", method = RequestMethod.POST)
	  public ModelAndView updatePru(@ModelAttribute Pruebas pruebas) {
	      editDaoImpl.updatePru(pruebas);
	      return new ModelAndView("Inicio");
	  }
	  
	  @RequestMapping(value = "/updatePruebas", method = RequestMethod.GET)
	  public ModelAndView updatePru(HttpServletRequest request) {
	      int prueId = Integer.parseInt(request.getParameter("id"));
	      Pruebas pruebas = verDaoImpl.getPrue(prueId);
	      ModelAndView model = new ModelAndView("UpdatePru");
	      model.addObject("pruebas", pruebas);
	      return model;
	  }
	  
	  @RequestMapping(value = "/updatePruA", method = RequestMethod.POST)
	  public ModelAndView updatePruA(@ModelAttribute Pruebas pruebas) {
	      editDaoImpl.updatePru(pruebas);
	      return new ModelAndView("Admin");
	  }
	  
	  @RequestMapping(value = "/updatePruebasA", method = RequestMethod.GET)
	  public ModelAndView updatePruA(HttpServletRequest request) {
	      int prueId = Integer.parseInt(request.getParameter("id"));
	      Pruebas pruebas = verDaoImpl.getPrue(prueId);
	      ModelAndView model = new ModelAndView("UpdatePruA");
	      model.addObject("pruebas", pruebas);
	      return model;
	  }
	  
	  @RequestMapping(value = "/updateRie", method = RequestMethod.POST)
	  public ModelAndView updateRie(@ModelAttribute Riesgos riesgos) {
	      editDaoImpl.updateRie(riesgos);
	      return new ModelAndView("Inicio");
	  }
	  
	  @RequestMapping(value = "/updateRiesgos", method = RequestMethod.GET)
	  public ModelAndView updateRie(HttpServletRequest request) {
	      int rieId = Integer.parseInt(request.getParameter("id"));
	      Riesgos riesgos = verDaoImpl.getRie(rieId);
	      ModelAndView model = new ModelAndView("UpdateRie");
	      model.addObject("riesgos", riesgos);
	      return model;
	  }
	  
	  @RequestMapping(value = "/updateRieA", method = RequestMethod.POST)
	  public ModelAndView updateRieA(@ModelAttribute Riesgos riesgos) {
	      editDaoImpl.updateRie(riesgos);
	      return new ModelAndView("Admin");
	  }
	  
	  @RequestMapping(value = "/updateRiesgosA", method = RequestMethod.GET)
	  public ModelAndView updateRieA(HttpServletRequest request) {
	      int rieId = Integer.parseInt(request.getParameter("id"));
	      Riesgos riesgos = verDaoImpl.getRie(rieId);
	      ModelAndView model = new ModelAndView("UpdateRieA");
	      model.addObject("riesgos", riesgos);
	      return model;
	  }
	  
	  //Actualizar issues desarrollador
	  @RequestMapping(value = "/updateIss", method = RequestMethod.POST)
	  public ModelAndView updateIss(@ModelAttribute Issues issues) {
	      editDaoImpl.updateIssues(issues);
	      return new ModelAndView("Inicio");
	  }
	  
	  @RequestMapping(value = "/updateIssues", method = RequestMethod.GET)
	  public ModelAndView updateIss(HttpServletRequest request) {
	      int issId = Integer.parseInt(request.getParameter("id"));
	      Issues issues = verDaoImpl.getIssues(issId);
	      List<Proyectos> listProyectos = verDaoImpl.verProyectos();
	      ModelAndView model = new ModelAndView("UpdateIssues");
	      model.addObject("listProyectos", listProyectos);
	      model.addObject("issues", issues);
	      return model;
	  }
	  
	  //actualizar issues superadmin
	  @RequestMapping(value = "/updateIssA", method = RequestMethod.POST)
	  public ModelAndView updateIssA(@ModelAttribute Issues issues) {
	      editDaoImpl.updateIssuesA(issues);
	      return new ModelAndView("Admin");
	  }
	  
	  @RequestMapping(value = "/updateIssuesA", method = RequestMethod.GET)
	  public ModelAndView updateIssA(HttpServletRequest request) {
	      int issId = Integer.parseInt(request.getParameter("id"));
	      Issues issues = verDaoImpl.getIssues(issId);
	      List<Proyectos> listProyectos = verDaoImpl.verProyectos();
	      ModelAndView model = new ModelAndView("UpdateIssuesA");
	      model.addObject("listProyectos", listProyectos);
	      model.addObject("issues", issues);
	      return model;
	  }
	  
	  //actualizar issues clientes
	  @RequestMapping(value = "/updateIssC", method = RequestMethod.POST)
	  public ModelAndView updateIssC(@ModelAttribute Issues issues) {
	      editDaoImpl.updateIssuesC(issues);
	      return new ModelAndView("Cliente");
	  }
	  
	  @RequestMapping(value = "/updateIssuesC", method = RequestMethod.GET)
	  public ModelAndView updateIssC(HttpServletRequest request) {
	      int issId = Integer.parseInt(request.getParameter("id"));
	      Issues issues = verDaoImpl.getIssues(issId);
	      List<Proyectos> listProyectos = verDaoImpl.verProyectos();
	      ModelAndView model = new ModelAndView("UpdateIssuesC");
	      model.addObject("listProyectos", listProyectos);
	      model.addObject("issues", issues);
	      return model;
	  }
	  
	  @RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
	  public ModelAndView updateEmp(@ModelAttribute Empresa empresa) {
	      editDaoImpl.updateEmpresas(empresa);
	      return new ModelAndView("Inicio");
	  }
	  
	  @RequestMapping(value = "/updateEmpresa", method = RequestMethod.GET)
	  public ModelAndView updateEmp(HttpServletRequest request) {
	      int emId = Integer.parseInt(request.getParameter("id"));
	      Empresa empresa = verDaoImpl.getEmpresas(emId);
	      ModelAndView model = new ModelAndView("UpdateEmpresa");
	      model.addObject("empresa", empresa);
	      return model;
	  }
	  
	  @RequestMapping(value = "/updateEmpA", method = RequestMethod.POST)
	  public ModelAndView updateEmpA(@ModelAttribute Empresa empresa) {
	      editDaoImpl.updateEmpresas(empresa);
	      return new ModelAndView("Admin");
	  }
	  
	  @RequestMapping(value = "/updateEmpresaA", method = RequestMethod.GET)
	  public ModelAndView updateEmpA(HttpServletRequest request) {
	      int emId = Integer.parseInt(request.getParameter("id"));
	      Empresa empresa = verDaoImpl.getEmpresas(emId);
	      ModelAndView model = new ModelAndView("UpdateEmpresaA");
	      model.addObject("empresa", empresa);
	      return model;
	  }
	  
	  @RequestMapping(value = "/updateUsu", method = RequestMethod.POST)
	  public ModelAndView updateUs(@ModelAttribute User user) {
	      editDaoImpl.updateUsuarios(user);
	      return new ModelAndView("Admin");
	  }
	  
	  @RequestMapping(value = "/updateUsuarios", method = RequestMethod.GET)
	  public ModelAndView updateUsu(HttpServletRequest request) {
	      int emId = Integer.parseInt(request.getParameter("id"));
	      User user = verDaoImpl.getUser(emId);
	      ModelAndView model = new ModelAndView("UpdateUser");
	      model.addObject("user", user);
	      return model;
	  }
	  
	  @RequestMapping(value = "/updateUsuC", method = RequestMethod.POST)
	  public ModelAndView updateUsc(@ModelAttribute User user) {
	      editDaoImpl.updateUsuariosC(user);
	      return new ModelAndView("Cliente");
	  }
	  //cambio ps cliente
	  @RequestMapping(value = "/PassC**", method = RequestMethod.GET)
	  public ModelAndView updateUsuc(HttpServletRequest request) {
		  String e = request.getParameter("e");
		  User l=verDaoImpl.getUserBy(e);
		  int id=l.getId();
	      User user = verDaoImpl.getUser(id);
	      ModelAndView model = new ModelAndView("ModP");
	      model.addObject("user", user);
	      return model;
	  }
	  
	  @RequestMapping(value = "/updateUsuD", method = RequestMethod.POST)
	  public ModelAndView updateUscD(@ModelAttribute User user) {
	      editDaoImpl.updateUsuariosC(user);
	      return new ModelAndView("Inicio");
	  }
	  //cambio ps admin
	  @RequestMapping(value = "/PassD**", method = RequestMethod.GET)
	  public ModelAndView updateUsucD(HttpServletRequest request) {
		  String e = request.getParameter("e");
		  User l=verDaoImpl.getUserBy(e);
		  int id=l.getId();
	      User user = verDaoImpl.getUser(id);
	      ModelAndView model = new ModelAndView("ModPD");
	      model.addObject("user", user);
	      return model;
	  }
}

