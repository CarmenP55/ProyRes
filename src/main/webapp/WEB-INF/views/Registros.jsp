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
                    <li class="active"><a href="irInicio.html">Inicio</a></li> 
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Proyectos<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="VerProyectos.html">Ver Proyectos</a></li>
							<li><a href="Proyectos.html">Agregar nuevo proyecto</a></li>						                          	
                        </ul>
                      </li>  
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Registrar<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href=ListaPro.html>Informacion de Proyectos</a></li>
							<li><a href=IssuesD.html?e="${pageContext.request.userPrincipal.name}">Tickets</a></li>
							<li><a href=Empresa.html>Empresas</a></li>
							<li><a href=register2.html>Usuarios</a></li>
                        </ul>
                    </li>                    
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Consultar<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href=ListaVer.html>Informacion de Proyectos</a></li>
							<li><a href=VerIssues.html>Tickets</a></li>
							<li><a href=VerEmpresas.html>Empresas</a></li>
							<li><a href=VerUsuariosD.html>Usuarios</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Reportes<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href=Reportes.html?e="${pageContext.request.userPrincipal.name}">Nuevo</a></li>
							<li><a href=VerReportesD.html?e="${pageContext.request.userPrincipal.name}">Mis reportes</a></li>
                        </ul>
                    </li>
                    <li><a href=PassD?e="${pageContext.request.userPrincipal.name}" class="icon-envelope">Mi cuenta</a></li>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
					<li><a href="javascript:formSubmit()" class="icon-envelope">Salir</a></li>
					</c:if>
                  </ul>
                </div><!--/.nav-collapse -->
              </div>
            </div>
          </div><br><br><br>
          <div class="col-sm-5">
            <table class="table table-bordered table-hover">
	            <tr bgcolor="#31B404">
            	<th>Elegir opcion</th>
            	<th>Agregar</th>
            	<th>Ver Registros</th>
            	</tr>
                <tr>
                <td><img src="https://image.flaticon.com/icons/svg/74/74960.svg" alt="Home" width="50" height="50">Agregar Tareas<br></td>
                <td><a href=ModDis.html?id_proyecto=${param.id_proyecto}>Agregar</a><br></td>
                <td><a href=VerDiseno.html?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td></tr>
                <tr>
                <tr>
                <td><img src="https://www.redeszone.net/app/uploads/2016/11/especificaciones-tecnicas.png" alt="Home" width="50" height="50">Especificacion Tecnica</td>
                <td>NA<br></td>
                <td><a href="ET.pdf?id_proyecto=${param.id_proyecto}" target="_blank">Ver</a></td></tr>
                <tr>
                <td><img src="https://ecosagile.com/EcosAgile/SPA/images/moduli-e-processi.png" alt="Home" width="50" height="50">Modulos<br></td>
                <td><a href=Modulos.html?id_proyecto=${param.id_proyecto}>Agregar</a><br></td>
                <td><a href="VerModulos.html?id_proyecto=${param.id_proyecto}">Ver registros</a><br></td></tr>
				<tr>
				<td><img src="https://userscontent2.emaze.com/images/8bcc1df3-5fd7-452a-b935-102d351b241b/897ac9fb-7778-4510-aa2e-823a44c5be72.png" alt="Home" width="50" height="50">Pruebas<br></td>
				<td><a href="ModPru.html?id_proyecto=${param.id_proyecto}">Agregar</a><br></td>
				<td><a href=VerPruebas.html?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td></tr>
				<tr>
				<td><img src="https://www.csticorp.biz/wp-content/uploads/2014/07/Imagen8.jpg" alt="Home" width="50" height="50">Requerimientos<br></td>
				<td><a href=Requerimientos.html?id_proyecto=${param.id_proyecto}>Agregar</a><br></td>
				<td><a href="ModReq.html?id_proyecto=${param.id_proyecto}">Ver registros</a><br></td></tr>
				<tr>				
				<td><img src="http://finantechcolombia.com/wp-content/uploads/2013/11/Consultoria-financiera-en-riesgos-para-empresas-peque%C3%B1as-en-Colombia.jpg" alt="Home" width="50" height="50">Riesgos<br></td>
				<td><a href=Riesgos.html?id_proyecto=${param.id_proyecto}>Agregar</a><br></td>
				<td><a href=VerRiesgos.html?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td></tr>
            </table>
                       
		</div>             
</div><!-- /.container -->

</body>
</html>