<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Lanconta</title>
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
          <div class="col-sm-3">
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
							<li><a href=CrearTareas.html>Tareas</a></li>
							<li><a href=CrearSub.html>Subtareas</a></li>
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
        
          <div class="col-sm-5">	
			<h3>${proyectos.nombre}</h3>
            <table class="table table-bordered table-hover">
            <tr><th>Tipo de Proyecto</th><td>${proyectos.tipo}</td></tr>
            <tr><th>Empresa</th><td>${empresa.nombre}</td></tr>
            <tr><th>Responsable</th><td>${userRes.firstname} ${userRes.lastname}</td></tr>
            <tr><th>Descripcion</th><td>${proyectos.descripcion}</td></tr>
            <tr><th>Fecha solicitud</th><td>${proyectos.solicitud}</td></tr>
            <tr><th>Desarrollador</th><td>${userDes.firstname} ${userDes.lastname}</td></tr>
            <tr><th>Modelo</th><td>${proyectos.modelo}</td></tr>
            <tr><th>Fecha entrega</th><td>${proyectos.entrega}</td></tr>
            <tr><th>Estatus</th><td>${proyectos.estatus}</td></tr>
            </table>
            
            </div>
          <div class="col-sm-12" style="width:fit-content">				
            <h4>Requerimientos</h4>
            <table class="table table-bordered table-hover">
            <tr bgcolor="#31B404">
                <th>Tipo</th>
                <th>Actividad</th>
                <th>Descripcion</th>
                <th>Entrega</th>
                <th>Criticidad</th>
                <th>Accion</th>
                <th>Comentarios</th>
                <th>Estatus</th></tr>
                <c:forEach var="req" items="${listRequerimientos}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.tipo}</td>
                    <td>${req.actividad}</td>
                    <td>${req.descripcion}</td>
                    <td>${req.entrega}</td>
                    <td>${req.criticidad}</td>
                    <td>${req.accion}</td>
                    <td>${req.comentarios}</td>
                    <td>${req.estatus}</td>
                </tr>
                </c:forEach> 
            </table>
            
            <h4>Diseno</h4>
            <table class="table table-bordered table-hover">
            <tr bgcolor="#31B404">
                <th>Requerimiento</th>
                <th>Actividad</th>
                <th>Descripcion</th>
                <th>Entrega</th>
                <th>Comentarios</th>
                <th>Estatus</th></tr>
                <c:forEach var="req" items="${listDiseno}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.requerimiento}</td>
                    <td>${req.actividad}</td>
                    <td>${req.descripcion}</td>
                    <td>${req.entrega}</td>
                    <td>${req.comentarios}</td>
                    <td>${req.estatus}</td>
                </tr>
                </c:forEach>             
            </table>
            
            
            <h4>Pruebas</h4>
            <table class="table table-bordered table-hover">
            <tr bgcolor="#31B404">
                <th>Requerimiento</th>
                <th>Entrada</th>
                <th>Proceso</th>
                <th>Salida</th>
                <th>Observaciones</th>
                <th>Severidad</th>
                <th>Responsable</th>
                <th>Estatus</th></tr>
                <c:forEach var="req" items="${listPruebas}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.requerimiento}</td>
                    <td>${req.entrada}</td>
                    <td>${req.proceso}</td>
                    <td>${req.salida}</td>
                    <td>${req.observaciones}</td>
                    <td>${req.severidad}</td>
                    <td>${req.res_nombre}</td>
                    <td>${req.estatus}</td>
                </tr>
                </c:forEach>             
            </table>
            
            <h4>Riesgos</h4>
            <table class="table table-bordered table-hover">
            <tr bgcolor="#31B404">
                <th>Riesgos</th>
                <th>Descripcion</th>
                <th>Ocurrencia</th>
                <th>Efectos</th>
                <th>Accion</th>
                <th>Contingencia</th>
                <th>Clasificacion</th>
                <th>Version</th></tr>
                
                <c:forEach var="req" items="${listRiesgos}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.riesgo}</td>
                    <td>${req.descripcion}</td>
                    <td>${req.ocurrencia}</td>
                    <td>${req.efectos}</td>
                    <td>${req.accion}</td>
                    <td>${req.contingencia}</td>
                    <td>${req.clasificacion}</td>
                    <td>${req.version}</td>
                </tr>
                </c:forEach>             
            </table>
        
		</div>             
</div><!-- /.container -->
 
</body>
</html>

