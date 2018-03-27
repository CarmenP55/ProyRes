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
	<sec:authorize access="hasRole('ROLE_USER')">
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
                    <li class="active"><a href="Cliente.html">Inicio</a></li> 
                    <li><a href=ProyectosLista.html?e="${pageContext.request.userPrincipal.name}" class="icon-beaker">Proyectos</a></li> 
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Tickets<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href=Issues?e="${pageContext.request.userPrincipal.name}">Levantar ticket</a></li>
							<li><a href=VerTickets.html?e="${pageContext.request.userPrincipal.name}">Mis tickets</a></li>
                        </ul>
                     </li>
                    <li><a class="icon-twitter">Guias rapidas</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Mi cuenta<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href=PassC?e="${pageContext.request.userPrincipal.name}">Actualizar datos</a></li>
                        </ul>
                     </li>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
					<li><a href="javascript:formSubmit()" class="icon-envelope">Salir</a></li>
					</c:if>
                  </ul>
                </div><!--/.nav-collapse -->
              </div>
            </div>
          </div><br><br><br>   
          <div class="col-sm-5" style="border: 3px solid #f1f1f1; padding:30px">
			<h4>Actualizar datos</h4>
			<hr>
			<form:form id="regForm" modelAttribute="user" action="updateUsuC" method="post">
            	<form:hidden path="id" name="id" id="id"/>
                <form:label path="firstname">Nombre</form:label>
                <form:input class="form-control" path="firstname" name="firstname" id="firstname" />
                <form:label path="lastname">Apellidos</form:label>
                <form:input class="form-control" path="lastname" name="lastname" id="lastname"/>
                <form:label path="telefono">Telefono</form:label>
                <form:input path="telefono" class="form-control" name="telefono" id="telefono" />
                <form:label path="email">Correo Electronico</form:label>
                <form:input path="email" name="email" id="email" class="form-control" type="email"/>
                <form:label path="password">Contraseņa</form:label>
                <form:input path="password" name="password" id="password" class="form-control" />
                <br>
                <form:button class="btn btn-success col-xs-4 col-sm-offset-8">Guardar</form:button>
            </form:form>
		</div>          
</div><!-- /.container -->
</body>
</html>

