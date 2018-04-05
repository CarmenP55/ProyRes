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
          </div><br><br><br>
          <div class="col-sm-5" style="border: 3px solid #f1f1f1; padding:30px">
			<h2>Riesgos</h2>
			<hr>
			<form:form id="regForm" modelAttribute="riesgos" action="updateRieA" method="post">
            	<form:hidden path="id" name="id" id="id"/>
                
                <form:label path="riesgo">Riesgo</form:label>
                <form:textarea required="true" path="riesgo" name="riesgo" id="riesgo" class="form-control" rows="4"  />
                
                <form:label path="descripcion">Descripción</form:label>
                <form:textarea path="descripcion" name="descripcion" id="descripcion" class="form-control" rows="4" /><br>
                
                <form:label path="ocurrencia">Probabilidad de ocurrencia</form:label>
                <div class="radio-inline"><form:radiobutton path="ocurrencia" name="ocurrencia" id="ocurrencia" value="25"/>-25</div>
                <div class="radio-inline"><form:radiobutton path="ocurrencia" name="ocurrencia" id="ocurrencia" value="50"/>50</div>
                <div class="radio-inline"><form:radiobutton path="ocurrencia" name="ocurrencia" id="ocurrencia" value="75"/>+75</div>
                
                <br><form:label path="efectos">Efectos</form:label>
                <form:textarea path="efectos" name="efectos" id="efectos" class="form-control" rows="4" />
                
                <form:label path="accion">Plan de accion</form:label><br>
                <form:textarea path="accion" name="accion" id="accion" class="form-control" rows="4" />
                
                <form:label path="contingencia">Plan de contingencia</form:label>                
                <form:textarea path="contingencia" name="contingencia" id="contingencia" class="form-control" rows="4" />
                
                <form:label path="clasificacion">Clasificacion</form:label>                
                <br><div class="radio-inline"><form:radiobutton path="clasificacion" name="clasificacion" id="clasificacion" value="Proyecto"/>Riesgos del Proyecto</div><br>
                <div class="radio-inline"><form:radiobutton path="clasificacion" name="clasificacion" id="clasificacion" value="Producto"/>Riesgos del Producto</div><br>
                <div class="radio-inline"><form:radiobutton path="clasificacion" name="clasificacion" id="clasificacion" value="Negocio"/>Riesgos del Negocio</div>
                <br>
                <form:button class="btn btn-success col-xs-4 col-sm-offset-8">Guardar</form:button>
            </form:form>

			</div>
                       
</div><!-- /.container -->
<br>
</body>
</html>

