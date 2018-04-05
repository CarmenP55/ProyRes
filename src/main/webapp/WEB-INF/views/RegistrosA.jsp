<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registros</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <style type="text/css">
	/* make sidebar nav vertical */ 
	@media (min-width: 768px) {
	  .sidebar-nav .navbar .navbar-collapse {
		padding: 0;
		max-height: none;
	  }
	  .sidebar-nav .navbar ul {
		float: none;
	  }
	  .sidebar-nav .navbar ul:not {
		display: block;
	  }
	  .sidebar-nav .navbar li {
		float: none;
		display: block;
	  }
	  .sidebar-nav .navbar li a {
		padding-top: 12px;
		padding-bottom: 12px;
	  }
	}
	@media (min-width: 768px) {
	  /* uncomment if you would like the menu to be fixed */
	  /* .navbar {
		  position: fixed;
		  width: 170px;
		  z-index: 2;
	  } */
	}
	@media (min-width: 992px) {
	  .navbar {
		  width: 212px;
	  }
	}
	@media (min-width: 1200px) {
	  .navbar {
		  width: 262px;
	  }
	}
	.sidebar-nav .navbar-header{ float: none; }
</style>
<script>
function showhide(id) {
	var x= document.getElementById("all");
	var e = document.getElementById(id);
	x.style.display = (x.style.display == 'none') ? 'block' : 'none';
   	e.style.display = (e.style.display == 'block') ? 'none' : 'block';
 }
</script>
</head>
<body>
	<sec:authorize access="hasRole('ROLE_SUPER')">
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
	</sec:authorize>
<div class="container"> <br>    
          <div class="col-sm-4">
            <div class="sidebar-nav">
            <img src="${pageContext.request.contextPath}/resources/logo.jpg" width="220px" />      
              <div class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  <span class="visible-xs navbar-brand">Menu Principal</span>
                </div>
                <div class="navbar-collapse collapse sidebar-navbar-collapse">
                  <ul class="nav navbar-nav">
                    <li class="active"><a href="Admin.html">Inicio</a></li> 
                    <li><a href="ProyectosAd.html" class="icon-cogs">Proyectos</a></li>   
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Registros<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href=ListaProA.html>Informacion de Proyectos</a></li>							
                          	<li class="divider"></li>
                          	<li class="dropdown-header">Otros registros</li>
                          	<li><a href=IssuesAdmin.html?e="${pageContext.request.userPrincipal.name}">Tickets</a></li>
							<li><a href=EmpresaA.html>Empresas</a></li>
							<li><a href=register.html>Usuarios</a></li>
							<li><a href=Actividades.html>Actividades</a></li>
                        </ul>
                      </li>
                    <li><a href="VerRegistrosA.html" class="icon-twitter">Consultas</a></li>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
					<li><a href="javascript:formSubmit()" class="icon-envelope">Salir</a></li>
					</c:if>
                  </ul>
                </div><!--/.nav-collapse -->
              </div>
            </div>
          </div>      
          
          <div class="col-sm-5" id="all">                    
		  <br><br><br>
		  <table class="table table-bordered table-hover">
            <tr bgcolor="#31B404">
            	<th>Seleccionar</th>
            	<th colspan="2">Opciones</th></tr>
            	<tr>
                <td><img src="https://www.redeszone.net/app/uploads/2016/11/especificaciones-tecnicas.png" alt="Home" width="50" height="50">Esp. Tecnica</td>
                <td>N/A</td>
                <td><a href="ET.pdf?id_proyecto=${param.id_proyecto}" target="_blank">Generar ET</a><br></td></tr>
            	<tr>
                <td><img src="https://image.flaticon.com/icons/svg/74/74960.svg" alt="Home" width="50" height="50" title="Agregar informacion">Diseño</td>
                <td><a href="javascript:showhide('diseno')"?id_proyecto=${param.id_proyecto}>Agregar</a><br></td>
                <td><a href="javascript:showhide('verDiseno')"?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td>
                </tr>
                <tr>
                <td><img src="https://ecosagile.com/EcosAgile/SPA/images/moduli-e-processi.png" alt="Home" width="50" height="50" title="Agregar informacion">Modulos<br></td>
                <td><a href="javascript:showhide('modulos')"?id_proyecto=${param.id_proyecto}>Agregar</a><br></td>
                <td><a href="javascript:showhide('verModulos')"?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td></tr>
				<tr>
				<td><img src="https://userscontent2.emaze.com/images/8bcc1df3-5fd7-452a-b935-102d351b241b/897ac9fb-7778-4510-aa2e-823a44c5be72.png" alt="Home" width="50" height="50" title="Agregar informacion">Pruebas<br></td>
				<td><a href="javascript:showhide('pruebas')"?id_proyecto=${param.id_proyecto}>Agregar</a><br></td>
				<td><a href="javascript:showhide('verPruebas')"?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td></tr>
				<tr>
				<td><img src="https://www.csticorp.biz/wp-content/uploads/2014/07/Imagen8.jpg" alt="Home" width="50" height="50" title="Agregar informacion">Requerimientos<br></td>
				<td><a href=RequerimientosA.html?id_proyecto=${param.id_proyecto}>Agregar</a><br></td>
				<td><a href="javascript:showhide('verReq')"?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td></tr>
				<tr>
				<td><img src="http://finantechcolombia.com/wp-content/uploads/2013/11/Consultoria-financiera-en-riesgos-para-empresas-peque%C3%B1as-en-Colombia.jpg" alt="Home" width="50" height="50" title="Agregar informacion">Riesgos<br></td>
				<td><a href=RiesgosA.html?id_proyecto=${param.id_proyecto}>Agregar</a><br></td>
				<td><a href="javascript:showhide('verRiesgos')"?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td></tr>
            </table>	                     
          </div>                  

<div class="col-sm-4" id="diseno" style="display:none;">
	<h2>Elegir Modulo</h2>	
     <table class="table table-bordered table-hover">
            <tr bgcolor="#31B404"><th>Modulo</th>
               <c:forEach var="req" items="${listModulos}" varStatus="status">
               <tr style="border-top-color:transparent">
               <td><a href=DisenioA.html?id=${req.id}&id_proyecto=${param.id_proyecto}>${req.nombre}</a></td>
               </tr>
               </c:forEach>             
    </table>
</div>

<div class="col-sm-4" id="pruebas" style="display:none;">
	<h2>Elegir Modulo</h2>	
     <table class="table table-bordered table-hover">
            <tr bgcolor="#31B404">
           	   <th>Modulo</th>
               <c:forEach var="req" items="${listModulos}" varStatus="status">
               <tr style="border-top-color:transparent">
               <td><a href=PruebasA.html?id=${req.id}&id_proyecto=${param.id_proyecto}>${req.nombre}</a></td>
               </tr>
               </c:forEach>             
    </table>
</div>
<div class="col-sm-4" id="modulos" style="display:none; border: 3px solid #f1f1f1; padding:30px; margin-top:65px">		
	<h2>Modulos</h2>
	<form:form id="regForm" modelAttribute="modulo" action="modulosProcessA" method="post"  class="form-horizontal">                
                	<form:hidden path="proyectos" name="proyectos" id="proyectos" value="${param.id_proyecto}"/>
                    <form:label path="nombre">Nombre</form:label>
                    <form:input class="form-control" required="true" path="nombre" name="nombre" id="nombre" />
                    <form:label path="descripcion">Descripcion</form:label>
                    <form:textarea class="form-control" required="true" path="descripcion" name="descripcion" id="descripcion" col="40" rows="4" />
                    <form:label path="entrega">Fecha de entrega</form:label>
                    <form:input class="form-control" required="true" path="entrega" name="entrega" id="entrega" type="date" />                     
                    <br><form:button class="btn btn-success col-xs-4 col-sm-offset-8">Guardar</form:button> 
                
            </form:form>
</div>

<div class="col-sm-8" id="verDiseno" style="display:none;">	
			<h2>Diseno</h2>
            <table class="table table-bordered table-hover">
	            <tr bgcolor="#31B404">
                <th>Actividad</th>
                <th>Descripcion</th>
                <th>Entrega</th>
                <th>Comentarios</th>
                <th>Estatus</th>
                <th>Opciones</th>
                </tr>
                <c:forEach var="req" items="${listDiseno}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.actividad}</td>
                    <td>${req.descripcion}</td>
                    <td>${req.entrega}</td>
                    <td>${req.comentarios}</td>
                    <td>${req.estatus}</td>
                    <td>
                        <a href="updateDisenoA?id=${req.id}">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                </tr>
                </c:forEach>             
            </table>
</div>

<div class="col-sm-4" id="verPruebas" style="display:none;">	
			<h2>Pruebas</h2>
            <table class="table table-bordered table-hover">
            <tr bgcolor="#31B404">
                <th>Entrada</th>
                <th>Proceso</th>
                <th>Salida</th>
                <th>Observaciones</th>
                <th>Severidad</th>
                <th>Responsable</th>
                <th>Estatus</th>
                <th>Opciones</th>
                </tr>
                
                <c:forEach var="req" items="${listPruebas}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.entrada}</td>
                    <td>${req.proceso}</td>
                    <td>${req.salida}</td>
                    <td>${req.observaciones}</td>
                    <td>${req.severidad}</td>
                    <td>${req.res_nombre}</td>
                    <td>${req.estatus}</td>
                    <td>
                        <a href="updatePruebasA?id=${req.id}">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                </tr>
                </c:forEach>             
            </table>
</div>

<div class="col-sm-7" id="verModulos" style="display:none;">
			<h4>Modulos</h4>
            <table class="table table-bordered table-hover">
            <tr bgcolor="#31B404">
            	<th>Modulo</th>
                <th>Descripcion</th>
                <th>Fecha de entrega</th>
                <th>Estatus</th>                
                <th>Opciones</th>
                <c:forEach var="req" items="${listModulos}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.nombre}</td>
                    <td>${req.descripcion}</td>
                    <td>${req.entrega}</td>
                    <td>${req.estatus}</td>
                    <td>
                        <a href="updateModulosA?id=${req.id}">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                </tr>
                </c:forEach>             
            </table>
</div>

<div class="col-sm-9" id="verReq" style="display:none; width:fit-content;">	
			<h4>Requerimientos</h4>
            <table class="table table-bordered table-hover">
            <tr bgcolor="#31B404">
                <th>Actividad</th>
                <th>Descripcion</th>
                <th>Fecha de Entrega</th>
                <th>Criticidad</th>
                <th>Accion</th>
                <th>Comentarios</th>
                <th>Archivo</th>
                <th>Estatus</th>
                </tr>
                <c:forEach var="req" items="${listRequerimientos}" varStatus="status">
                
                <c:choose>
			    <c:when test="${req.estatus eq 'FINALIZADO'}">
			        <tr class="bg-success text-white" style="border-top-color:transparent">
			        <td>${req.actividad}</td>			        
			    </c:when>    
			    <c:when test="${req.estatus eq 'CANCELADO'}">
			        <tr class="bg-danger text-white" style="border-top-color:transparent">
			        <td><a title="Modificar" href="updateRequerimientoA?id_req=${req.id_req}">${req.actividad}</a></td>		        
			    </c:when>
			    <c:otherwise>
			        <tr style="border-top-color:transparent">
			        <td><a title="Modificar" href="updateRequerimientoA?id_req=${req.id_req}">${req.actividad}</a></td> 			        
			    </c:otherwise>
				</c:choose>
				
				<td>${req.descripcion}</td>
                    <td>${req.entrega}</td>
                    <td>${req.criticidad}</td>
                    <td>${req.accion}</td>
                    <td>${req.comentarios}</td>
                    <td><a href="ArchivoReq?id=${req.id_req}">${req.nombre_archivo}</a></td>
                    <td>${req.estatus}</td>
                </tr>
                </c:forEach>             
            </table>
</div>


<div class="col-sm-4" id="verRiesgos" style="display:none;">
			<h2>Riesgos</h2>	
            <table class="table table-bordered table-hover">
            <tr bgcolor="#31B404">            
                <th>Riesgos</th>
                <th>Descripcion</th>
                <th>Probabilidad de Ocurrencia</th>
                <th>Efectos</th>
                <th>Accion</th>
                <th>Contingencia</th>
                <th>Clasificacion</th>
                <th>Version</th>
                <th>Opciones</th>
                </tr>
                
                <c:forEach var="req" items="${listRiesgos}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.riesgo}</td>
                    <td>${req.descripcion}</td>
                    <td>${req.ocurrencia}%</td>
                    <td>${req.efectos}</td>
                    <td>${req.accion}</td>
                    <td>${req.contingencia}</td>
                    <td>${req.clasificacion}</td>
                    <td>${req.version}</td>
                    <td>
                        <a href="updateRiesgosA?id=${req.id}">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                </tr>
                </c:forEach>             
            </table>
</div>

</div><!-- /.container -->
</body>
</html>