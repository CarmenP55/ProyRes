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
	<div class="col-sm-9">	
	<div class="cuadro" id="all">
		<h4 style="text-decoration: underline">Consultar</h4>
		<hr>	
		<h4><a href="javascript:showhide('issues')">Tickets</a></h4>
		<h4><a href="javascript:showhide('empresa')">Empresas</a></h4>
		<h4><a href="javascript:showhide('usuarios')">Usuarios</a></h4>
		<h4><a href="javascript:showhide('act')">Actividades</a></h4>
		<h4><a href="javascript:showhide('tareasM')">Tareas</a></h4>
		<h4><a href=VerReportes.html?e="${pageContext.request.userPrincipal.name}">Reportes</a></h4>
	</div>		
		<div id="usuarios" style="display:none">
		<h2>Usuarios</h2>
		<div class="cuadroUser">
            <table class="table table-bordered table-hover">
            <tr bgcolor="#31B404">
                <th>Nombre</th>
                <th>Correo</th>
                <th>Telefono</th>
                <th>Empresa</th>
                <th>Tipo de usuario</th>                
                <th>Opciones</th>
                </tr>
                
                <c:forEach var="req" items="${listUsuarios}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.firstname} ${req.lastname}</td>
                    <td>${req.email}</td>
                    <td>${req.telefono}</td>
                    <td>${req.empresa}</td>
                    <td>${req.tipo}</td>
                    <td>
                        <a href="updateUsuarios?id=${req.id}">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </td>                             
                </tr>
                </c:forEach>             
            </table>
            </div>
		</div>
		
	<div id="issues" class="col-sm-8" style="display:none;">
	<h2>Tickets</h2>
	<div class="cuadroIssues">	
	<table class="table table-bordered table-hover">
            <tr bgcolor="#31B404">
            	<td>Proyecto</td>
                <th>Solicitante</th>
                <th>Descripcion</th>
                <th>Criticidad</th>
                <th>Comentarios</th>
                <th>Estatus Desarrollo</th>
                <th>Estatus Claiente</th>
                <th>Descargar archivo</th>
                <th>Opciones</th>
                </tr>
                
                <c:forEach var="req" items="${listIssues}" varStatus="status">
                <tr style="border-top-color:transparent">
                	<td>${req.nombre_proyecto}
                    <td>${req.solicitante}</td>
                    <td>${req.descripcion}</td>
                    <td>${req.criticidad}</td>
                    <td>${req.comentarios}</td>
                    <td>${req.estatus_desarrollo}</td>
                    <td>${req.estatus_cliente}</td>    
                     
                    <c:choose>
				    <c:when test="${not empty req.nombre}">
				        <td><a href="ArchivoTicket?id=${req.id}">Archivo</a></td>			        
				    </c:when>	
				    <c:otherwise>
				    <td></td></c:otherwise>			    
				    </c:choose>
				                   
                    <td>
                        <a href="updateIssuesA?id=${req.id}">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
            </div>
	</div>

	<div id="empresa" style="display:none;">
	<h2>Empresas</h2>
	<div class="cuadroEmp">
	<table class="table table-bordered table-hover">
            <tr bgcolor="#31B404">
            	<th>Ref</th>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Giro</th>
                <th>Opciones</th>
                <c:forEach var="req" items="${listEmpresa}" varStatus="status">
                <tr style="border-top-color:transparent">
                	<td>${req.id}</td>
                    <td>${req.nombre}</td>
                    <td>${req.descripcion}</td>
                    <td>${req.giro}</td>
                    <td>
                        <a href="updateEmpresaA?id=${req.id}">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                </tr>
                </c:forEach>             
            </table>
            </div>
	</div>

	<div id="act" style="display:none;">
	<h2>Actividades</h2>
	<div class="cuadroEmp">
	<table class="table table-bordered table-hover">
            <tr bgcolor="#31B404">
            	<th>Ref</th>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Cliente?</th>
                
                <c:forEach var="req" items="${listAct}" varStatus="status">
                <tr style="border-top-color:transparent">
                	<td>${req.id}</td>
                    <td>${req.nombre}</td>
                    <td>${req.descripcion}</td>
                    <td>${req.cliente}</td>
                </tr>
                </c:forEach>       
                      
            </table>
            </div>
	</div>


	<div id="tareas" style="display:none;">
	<h2>Sub Tareas</h2>
	<div class="cuadroEmp">
	<table class="table table-bordered table-hover">
            <tr bgcolor="#31B404">
            	<th>Ref</th>
                <th>Tarea</th>
                <th>Sub Tarea</th>
                <th>Descripcion</th>
                
                <c:forEach var="req" items="${listSub}" varStatus="status">
                <tr style="border-top-color:transparent">
                	<td>${req.id}</td>
                	<td>${req.nombre_tarea}</td>
                    <td>${req.nombre}</td>
                    <td>${req.descripcion}</td>
                    
                </tr>
                </c:forEach>             
            </table>
            </div>
	</div>

	<div id="tareasM" style="display:none;">
	<h2>Tareas</h2>
	<div class="cuadroEmp">
	<table class="table table-bordered table-hover">
            <tr bgcolor="#31B404">
            	<th>Tarea</th>
                <th>Sub Tarea</th>
                <th>Descripcion</th>
                
                <c:forEach var="req" items="${listSub}" varStatus="status">
                <tr style="border-top-color:transparent">
                	<td>${req.nombre_tarea}</td>
                    <td>${req.nombre}</td>
                    <td>${req.descripcion}</td>                   
                </tr>
                </c:forEach>             
            </table>
            </div>
	</div>
</div>			                       
</div><!-- /.container -->

</body>
</html>

