<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
          
          <br><br><br>
          <div class="col-sm-5" style="border: 3px solid #f1f1f1; padding:30px">                    
		  <h4>Dar de alta un proyecto</h4>
		  <hr>
		  	<form:form id="regForm" modelAttribute="proyectos" action="proyectosProcessA" method="post" class="form-horizontal">                            
                <form:label path="nombre">Nombre del Proyecto</form:label>
				<form:input class="form-control" required="true" path="nombre" name="nombre" id="nombre"/>
                <form:label path="tipo">Tipo de Proyecto</form:label><br>
                <div class="radio-inline"><form:radiobutton required="true" path="tipo" name="tipo" id="tipo" value="Nuevo" />Nuevo</div>
                <div class="radio-inline"><form:radiobutton required="true" path="tipo" name="tipo" id="tipo" value="Heredado" />Heredado</div>
                <form:hidden path="empresa" name="empresa" id="empresa" value="${param.id}"/>
                <form:hidden required="true" path="empresa" name="empresa" value="${param.id}" id="empresa" disabled="true"/>
                <form:label path="responsable">Responsable de la empresa</form:label>
                <form:select class="form-control" required="true" path="responsable" name="responsable" id="responsable">
                <br><br><c:forEach var="req" items="${listUsuarios}" varStatus="status">
                <option value="${req.id}">${req.firstname} ${req.lastname}</option>
                </c:forEach> 
                </form:select><br>
                <form:label path="descripcion">Descripcion del proyecto</form:label>
                <form:textarea class="form-control" required="true" path="descripcion" name="descripcion" id="descripcion" rows="6" />
                <form:label path="solicitud">Fecha de solicitud</form:label>
                <form:input class="form-control" required="true" path="solicitud" name="solicitud" id="solicitud" type="date"/>
                <form:label path="desarrollador">Desarrollador</form:label>
                <form:select class="form-control" required="true" path="desarrollador" name="desarrollador" id="desarrollador">
                <br><br><c:forEach var="req" items="${listUsuarios2}" varStatus="status">
                <option value="${req.id}">${req.firstname} ${req.lastname}</option>
                </c:forEach> 
                </form:select><br>
                <form:label path="modelo">Modelo a seguir</form:label><br>
                <div class="radio-inline"><form:radiobutton path="modelo" name="modelo" id="modelo" value="Cascada" />Cascada</div>
                <div class="radio-inline"><form:radiobutton required="true" path="modelo" name="modelo" id="modelo" value="Evolutivo" />Evolutivo</div>
                <div class="radio-inline"><form:radiobutton required="true" path="modelo" name="modelo" id="modelo" value="Espiral" />Espiral</div>
                <form:label path="entrega">Fecha de entrega</form:label>
				<form:input class="form-control" required="true" path="entrega" name="entrega" id="entrega" type="date" />
				<form:label path="tecnologia">Lenguaje de desarrollo</form:label>
                <form:input class="form-control" required="true" path="tecnologia" name="tecnologia" id="tecnologia"/>
                <form:label path="repositorio">Repositorio del proyecto</form:label>
                <form:input class="form-control" required="true" path="repositorio" name="repositorio" id="repositorio"/>
                <form:label path="detalle">Acceso repositorio</form:label>
                <form:textarea class="form-control" required="true" path="detalle" name="detalle" id="detalle" rows="4" />
                <form:button class="btn btn-success col-xs-4 col-sm-offset-8" id="proyectos" name="proyectos">Guardar</form:button>                               
            </form:form>	                     
          </div>            
          <br>                     
</div><!-- /.container -->
<br>

</body>
</html>

