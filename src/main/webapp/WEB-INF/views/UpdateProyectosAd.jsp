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
	<sec:authorize access="hasRole('ROLE_ADMIN')">
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
<div class="head">
<a href=Admin.html><img src="https://image.flaticon.com/icons/svg/25/25694.svg" alt="Home" width="50" height="50"></a>
</div>
<div class="cuadro">
	<h2>Proyecto</h2>
	<form:form id="regForm" modelAttribute="proyectos" action="saveA" method="post">
                <div class="container">
                            <form:hidden path="id_proyecto" name="id_proyecto" id="id_proyecto"/>
                            <form:label path="nombre">Nombre del Proyecto</form:label>
                            <form:input required="true" path="nombre" name="nombre" id="nombre"/>
                            <form:label path="tipo">Tipo de Proyecto</form:label>
                            <div class="radio">
                            <form:radiobutton required="true" path="tipo" name="tipo" id="tipo" value="Nuevo" />Nuevo
                            <form:radiobutton required="true" path="tipo" name="tipo" id="tipo" value="Heredado" />Heredado</div>
                            <form:label path="empresa">Empresa</form:label>
                            <form:input required="true" path="empresa" name="empresa" id="empresa" disabled="true"/>
                            <form:label path="responsable">Responsable de la empresa</form:label> 
                            <form:input required="true" path="responsable" name="responsable" id="responsable" disabled="true"/>
                            <form:label path="descripcion">Descripcion del proyecto</form:label>
                            <form:textarea required="true" path="descripcion" name="descripcion" id="descripcion" col="40" rows="6" />
                            <form:label path="solicitud">Fecha de solicitud</form:label>
                            <form:input required="true" path="solicitud" name="solicitud" id="solicitud" type="date" disabled="true"/>
                            <form:label path="desarrollador">Desarrollador</form:label>
                			<form:input required="true" path="desarrollador" name="desarrollador" id="desarrollador" disabled="true"/>
                			<form:label path="modelo">Modelo a seguir</form:label>
                            <div class="radio">
                            <form:radiobutton path="modelo" name="modelo" id="modelo" value="Cascada" disabled="true"/>Cascada
                            <form:radiobutton required="true" path="modelo" name="modelo" id="modelo" value="Evolutivo" disabled="true"/>Evolutivo
                            <form:radiobutton required="true" path="modelo" name="modelo" id="modelo" value="Espiral" disabled="true" />Espiral
                            </div>
                            <form:label path="entrega">Fecha de entrega</form:label>
							<form:input required="true" path="entrega" name="entrega" id="entrega" type="date" />
							<form:label path="tecnologia">Lenguaje de desarrollo</form:label>
                            <form:input required="true" path="tecnologia" name="tecnologia" id="tecnologia"/>
                            <form:label path="repositorio">Repositorio del proyecto</form:label>
                            <form:input required="true" path="repositorio" name="repositorio" id="repositorio"/>
                            <form:label path="detalle">Acceso repositorio</form:label>
                            <form:textarea required="true" path="detalle" name="detalle" id="detalle" col="40" rows="4" />
                            <form:button>Guardar</form:button>
                     </div>
            </form:form>
</div>
</body>
</html>

