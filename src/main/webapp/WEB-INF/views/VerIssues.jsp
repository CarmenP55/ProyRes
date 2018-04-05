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
	
<div class="container"> <br>              
          <a href="irInicio.html" class="btn btn-info btn-lg">
          	<span class="glyphicon glyphicon-home"></span> Inicio
        	</a>    
          <br><br>
          <div style="width:140%; padding-right:30px">
            <table class="table table-bordered table-hover">
            <tr>
            	<th>Proyecto</th>
                <th>Solicitante</th>
                <th>Descripcion</th>
                <th>Criticidad</th>
                <th>Comentarios</th>
                <th>Estatus Desarrollo</th>
                <th>Estatus Cliente</th>
                <th>Fecha de registro</th>
                <th>Fecha de cierre</th>
                <th>Archivo</th>
                <th>Opciones</th>
                </tr>
                <tbody id="myTable">
                <c:forEach var="req" items="${listIssues}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.nombre_proyecto}
                    <td>${req.solicitante}</td>
                    <td>${req.descripcion}</td>
                    <td>${req.criticidad}</td>
                    <td>${req.comentarios}</td>
                    <c:choose>
				    <c:when test="${req.estatus_desarrollo eq 'NO_INICIADO'}">
				        <td class="bg-danger text-white">${req.estatus_desarrollo}</td>			        
				    </c:when>    
				    <c:when test="${req.estatus_desarrollo eq 'RESUELTO'}">
				        <td class="bg-info text-white">${req.estatus_desarrollo}</td>		        
				    </c:when>
				    <c:otherwise>
				        <td class="bg-warning text-white">${req.estatus_desarrollo}</td> 			        
				    </c:otherwise>
					</c:choose>
					                    
                    <td>${req.estatus_cliente}</td>
                    <td>${req.alta}</td>
                    <td>${req.cierre}</td>
                    
                    <c:choose>
				    <c:when test="${not empty req.nombre}">
				        <td><a href="ArchivoTicket?id=${req.id}">Archivo</a></td>			        
				    </c:when>
				    <c:otherwise>
                    <th></th>
                    </c:otherwise>
                    				    
				    </c:choose>
                    <td>
                        <a href="updateIssues?id=${req.id}">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                             
                </tr>
                </c:forEach>  
                </tbody>           
            </table>
        
		</div>           
</div><!-- /.container -->

</body>
<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
</html>

