package com.cloudsrcsoft.springmvc;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cloudsrcsoft.beans.*;
import com.cloudsrcsoft.dao.VerDaoImpl;

@Controller
public class ConsultasController {	
	@Autowired
	VerDaoImpl verDaoImpl;
	
	@RequestMapping(value="/VerProyectos.html")
	public ModelAndView listProyectos(ModelAndView model) throws IOException{
		List<Proyectos> listProyectos = verDaoImpl.verProyectos();
		model.addObject("listProyectos", listProyectos);
		model.setViewName("VerProyectos");
		return model;
	}
	
	@RequestMapping(value="/ProyectosLista.html")
	public ModelAndView listProyectosC(ModelAndView model, HttpServletRequest request) throws IOException{
		String e = request.getParameter("e");
		User l=verDaoImpl.getUserBy(e);
		int id=l.getId();
		List<Proyectos> listProyectos = verDaoImpl.verProyectosC(id);
		model.addObject("listProyectos", listProyectos);
		model.setViewName("VerProyectosC");
		return model;
	}
	
	@RequestMapping(value="/VerRequerimientos.html", method = RequestMethod.GET)
	public ModelAndView listReq(ModelAndView model, HttpServletRequest request) throws IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		List<Requerimientos> listRequerimientos = verDaoImpl.verRequerimientos(id);
		model.addObject("listRequerimientos", listRequerimientos);
		model.setViewName("VerRequerimientos");
		return model;
	}
	//lista de modulos para luego ingresar los req
	@RequestMapping(value="/ModReq.html**", method = RequestMethod.GET)
	public ModelAndView listReqM(ModelAndView model, HttpServletRequest request) throws IOException{
		int id = Integer.parseInt(request.getParameter("id_proyecto"));
		List<Modulo> listModulo = verDaoImpl.verModulos(id);
		model.addObject("listModulo", listModulo);
		model.setViewName("ListaModulosVer");
		return model;
	}
	//lista de modulos para luego ingresar las pruebas
	@RequestMapping(value="/ModPru.html**", method = RequestMethod.GET)
	public ModelAndView listReqME(ModelAndView model, HttpServletRequest request) throws IOException{
		int id = Integer.parseInt(request.getParameter("id_proyecto"));
		List<Modulo> listModulos = verDaoImpl.verModulos(id);
		model.addObject("listModulos", listModulos);
		model.setViewName("ListaModulos");
		return model;
	}
	
	@RequestMapping(value="/VerModulos.html", method = RequestMethod.GET)
	public ModelAndView listModulos(ModelAndView model, HttpServletRequest request) throws IOException{
		int id = Integer.parseInt(request.getParameter("id_proyecto"));
		List<Modulo> listModulos = verDaoImpl.verModulos(id);
		model.addObject("listModulos", listModulos);
		model.setViewName("VerModulos");
		return model;
	}
	
	@RequestMapping(value="/ReqCliente.html", method = RequestMethod.GET)
	public ModelAndView listReqCliente(ModelAndView model, HttpServletRequest request) throws IOException{
		int id = Integer.parseInt(request.getParameter("id_proyecto"));
		List<Requerimientos> listRequerimientos = verDaoImpl.verRequerimientosPro(id);
		model.addObject("listRequerimientos", listRequerimientos);
		model.setViewName("Requerimientos");
		return model;
	}
	
	@RequestMapping(value="/PruebasCliente.html", method = RequestMethod.GET)
	public ModelAndView listPruCliente(ModelAndView model, HttpServletRequest request) throws IOException{
		int id = Integer.parseInt(request.getParameter("id_proyecto"));
		List<Pruebas> listPruebas = verDaoImpl.verPruebas(id);
		model.addObject("listPruebas", listPruebas);
		model.setViewName("VerPruebasC");
		return model;
	}
	
	@RequestMapping(value="/VerDiseno.html", method = RequestMethod.GET)
	public ModelAndView listDis(ModelAndView model, HttpServletRequest request) throws IOException{
		int id = Integer.parseInt(request.getParameter("id_proyecto"));
		List<Diseno> listDiseno = verDaoImpl.verDiseno(id);
		model.addObject("listDiseno", listDiseno);
		model.setViewName("VerDiseno");
		return model;
	}
	
	@RequestMapping(value="/VerPruebas.html", method = RequestMethod.GET)
	public ModelAndView listPrue(ModelAndView model, HttpServletRequest request) throws IOException{
		int id = Integer.parseInt(request.getParameter("id_proyecto"));
		List<Pruebas> listPruebas = verDaoImpl.verPruebas(id);
		model.addObject("listPruebas", listPruebas);
		model.setViewName("VerPruebas");
		return model;
	}
	
	@RequestMapping(value="/VerRiesgos.html", method = RequestMethod.GET)
	public ModelAndView listRie(ModelAndView model, HttpServletRequest request) throws IOException{
		int id = Integer.parseInt(request.getParameter("id_proyecto"));
		List<Riesgos> listRiesgos = verDaoImpl.verRiesgos(id);
		model.addObject("listRiesgos", listRiesgos);
		model.setViewName("VerRiesgos");
		return model;
	}
	
	@RequestMapping(value="/VerIssues.html")
	public ModelAndView listIss(ModelAndView model) throws IOException{
		List<Issues> listIssues = verDaoImpl.verIssues();
		model.addObject("listIssues", listIssues);
		model.setViewName("VerIssues");
		return model;
	}
	
	//Vista de los superadmin para clases que no son de proyectos
	@RequestMapping(value="/VerRegistrosA.html")
	public ModelAndView listIssA(ModelAndView model) throws IOException{
		List<Issues> listIssues = verDaoImpl.verIssues();
		List<User> listUsuarios = verDaoImpl.verUsuarios();
		List<Empresa> listEmpresa = verDaoImpl.verEmpresa();
		List<Actividades> listAct = verDaoImpl.verActividades();
		List<Reportes> listRep = verDaoImpl.verReportes();
		List<SubTareas> listSub = verDaoImpl.verSub(-1);
		List<Tareas> listTareas = verDaoImpl.verTareas();		
		model.addObject("listAct", listAct);
		model.addObject("listRep", listRep);
		model.addObject("listEmpresa", listEmpresa);
		model.addObject("listIssues", listIssues);
		model.addObject("listUsuarios", listUsuarios);
		model.addObject("listSub", listSub);
		model.addObject("listTareas", listTareas);
		model.setViewName("VerAd");
		return model;
	}
	
	@RequestMapping(value="/VerReportes.html")
	public ModelAndView listR(ModelAndView model, HttpServletRequest request) throws IOException{
		List<Actividades> listAct = verDaoImpl.verActividades();
		List<Reportes> listRep = verDaoImpl.verReportes();
		model.addObject("listAct", listAct);
		model.addObject("listRep", listRep);
		model.setViewName("VerReportes");
		return model;
	}
	
	@RequestMapping(value="/VerReportesD.html")
	public ModelAndView listRD(ModelAndView model, HttpServletRequest request) throws IOException{
		List<Actividades> listAct = verDaoImpl.verActividades();
		String e = request.getParameter("e");
		User l=verDaoImpl.getUserBy(e);
		int id=l.getId();
		List<Reportes> listRep = verDaoImpl.verReportesD(id);
		model.addObject("listAct", listAct);
		model.addObject("listRep", listRep);
		model.setViewName("VerReportesD");
		return model;
	}
	
	@RequestMapping(value="/VerTickets.html")
	public ModelAndView listTickets(ModelAndView model, HttpServletRequest request) throws IOException{
		String e = request.getParameter("e");
		User l=verDaoImpl.getUserBy(e);
		int id=l.getId();
		List<Issues> listIssues = verDaoImpl.verIssuesC(id);
		model.addObject("listIssues", listIssues);
		model.setViewName("VerTickets");
		return model;
	}
	//VER US
	@RequestMapping(value="/VerUsuariosD.html**")
	public ModelAndView listUsersD(ModelAndView model) throws IOException{
		List<User> listUsuarios = verDaoImpl.verUsuarios();
		model.addObject("listUsuarios", listUsuarios);
		model.setViewName("ListaUsuarios");
		return model;
	}
	
	@RequestMapping(value="/VerEmpresas.html")
	public ModelAndView listEmp(ModelAndView model) throws IOException{
		List<Empresa> listEmpresa = verDaoImpl.verEmpresa();
		model.addObject("listEmpresa", listEmpresa);
		model.setViewName("VerEmpresas");
		return model;
	}
	
	@RequestMapping(value = "/verProyecto", method = RequestMethod.GET)
	  public ModelAndView verProyecto(HttpServletRequest request) {
	      int proyectoId = Integer.parseInt(request.getParameter("id_proyecto"));
	      List<Requerimientos> listRequerimientos = verDaoImpl.verRequerimientosPro(proyectoId);
	      List<Diseno> listDiseno = verDaoImpl.verDisenoPro(proyectoId);
	      List<Pruebas> listPruebas = verDaoImpl.verPruebasPro(proyectoId);
	      List<Riesgos> listRiesgos = verDaoImpl.verRiesgosPro(proyectoId);
	      Proyectos proyectos = verDaoImpl.getDetailsPro(proyectoId);
	      Empresa empresa=verDaoImpl.getDetailsEmp(proyectoId);
	      User userDes=verDaoImpl.getDetailsUs(proyectoId);
	      User userRes=verDaoImpl.getDetailsRes(proyectoId);
	      ModelAndView model = new ModelAndView("VerDetallePro");
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
	
	@RequestMapping(value = "/verProyectoA", method = RequestMethod.GET)
	  public ModelAndView verProyectoA(HttpServletRequest request) {
	      int proyectoId = Integer.parseInt(request.getParameter("id_proyecto"));
	      List<Requerimientos> listRequerimientos = verDaoImpl.verRequerimientosPro(proyectoId);
	      List<Diseno> listDiseno = verDaoImpl.verDisenoPro(proyectoId);
	      List<Pruebas> listPruebas = verDaoImpl.verPruebasPro(proyectoId);
	      List<Riesgos> listRiesgos = verDaoImpl.verRiesgosPro(proyectoId);
	      Proyectos proyectos = verDaoImpl.getDetailsPro(proyectoId);
	      Empresa empresa=verDaoImpl.getDetailsEmp(proyectoId);
	      User userDes=verDaoImpl.getDetailsUs(proyectoId);
	      User userRes=verDaoImpl.getDetailsRes(proyectoId);
	      ModelAndView model = new ModelAndView("VerDetalleProA");
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
	
	@RequestMapping(value = "/ArchivoTicket", method = RequestMethod.GET)
	  public ModelAndView download(HttpServletRequest request,
	        HttpServletResponse response) throws Exception {
			int id = Integer.parseInt(request.getParameter("id")); 
	        Issues file = verDaoImpl.find(id);	 
	        response.setContentType(file.getType());
	        response.setContentLength(file.getArchivo().length);
	        response.setHeader("Content-Disposition","attachment; filename=\"" + file.getNombre() +"\"");	 
	        FileCopyUtils.copy(file.getArchivo(), response.getOutputStream());	 
	        return null;	 
	  }
	
	@RequestMapping(value = "/ArchivoReq", method = RequestMethod.GET)
	  public ModelAndView downloadA(HttpServletRequest request,
	        HttpServletResponse response) throws Exception {
			int id = Integer.parseInt(request.getParameter("id")); 
	        Requerimientos file = verDaoImpl.findReq(id);	 
	        response.setContentType(file.getTipo_archivo());
	        response.setContentLength(file.getArchivo().length);
	        response.setHeader("Content-Disposition","attachment; filename=\"" + file.getNombre_archivo() +"\"");	 
	        FileCopyUtils.copy(file.getArchivo(), response.getOutputStream());	 
	        return null;	 
	  }
	
}