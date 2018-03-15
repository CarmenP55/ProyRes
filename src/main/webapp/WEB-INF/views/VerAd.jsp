<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Lanconta</title>
<STYLE type="text/css">
a, a:visited {
	text-decoration:none;
	outline:none;
	color:#54a6de;
}

a:hover{
	text-decoration:underline;
}

#colorNav > ul{
	width: 750px; 
	margin:0 auto;
	padding:15px;
}

#colorNav > ul > li{ 
	list-style: none;
	box-shadow: 0 0 10px rgba(100, 100, 100, 0.2) inset,1px 1px 1px #CCC;
	display: inline-block;
	line-height: 1;
	margin: 1px;
	border-radius: 3px;
	position:relative;
	padding: 10px;
}

#colorNav > ul > li > a{
	color:white;
	font-size:20px;
	font-family: Trebuchet MS;
	padding: 15px 15px 15px 15px;
	
}

#colorNav li ul{
	position:absolute;
	list-style:none;
	text-align:center;
	width:150px;
	left:30%;
	margin-left:-90px;
	top:25px;
	
	font-family: 'Trebuchet MS';
	/* This is important for the show/hide CSS animation */
	max-height:0px;
	overflow:hidden;
	
	-webkit-transition:max-height 0.4s linear;
	-moz-transition:max-height 0.4s linear;
	transition:max-height 0.4s linear;
}

#colorNav li ul li{
	background-color:#313131;
}

#colorNav li ul li a{
	padding:12px;
	color:#fff !important;
	display:block;
}

#colorNav li ul li:nth-child(odd){ /* zebra stripes */
	background-color:#363636;
}

#colorNav li ul li:hover{
	background-color:#444;
}

#colorNav li ul li:first-child{
	border-radius:3px 3px 0 0;
	margin-top:25px;
	position:relative;
}

#colorNav li ul li:first-child:before{ /* the pointer tip */
	content:'';
	position:absolute;
	width:1px;
	height:1px;
	border:5px solid transparent;
	border-bottom-color:#313131;
	left:50%;
	top:-10px;
	margin-left:-5px;
}

#colorNav li ul li:last-child{
	border-bottom-left-radius:3px;
	border-bottom-right-radius:3px;
}

#colorNav li:hover ul{
	max-height:200px; /* Increase when adding more dropdown items */
}

#colorNav li{
	background-color:#434140;
}

h2{
	text-align:center;
}

td{
	font-family:Trebuchet MS;
	font-size:16;
	padding: 10px 10px 10px 10px;
}

th{
	padding:15px;
}

table {
	margin: auto;
}

table tr {
    background-color: #eee;
}

table tr:nth-child(2) {
    background-color: #eee;
}
table tr:nth-child(even) {
    background-color: #eee;
}
 
table tr:nth-child(odd) {
    background-color: #fff;
}

div.head {
 	width:auto;
    height:60px;
    float: right;
    margin-bottom: 30px;
}

div.headBack {
 	width:auto;
    height:60px;
    float: left;
    margin-bottom: 30px;
}

div.cuadro {
	padding: 16px;
    border: 5px solid #f1f1f1;
    width: 20%;
    margin: auto;    
}

div.cuadroUser {
	padding: 16px;
    border: 3px solid #f1f1f1;
    width: 75%;
    margin: auto;    
}

div.cuadroEmp {
	padding: 16px;
    border: 3px solid #f1f1f1;
    width: 55%;
    margin: auto;    
}

div.cuadroIssues {
	padding: 16px;
    border: 3px solid #f1f1f1;
    width: 120%;
    margin: auto;    
}
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
<div class="head">
<a href=Admin.html><img src="https://image.flaticon.com/icons/svg/25/25694.svg" alt="Home" width="50" height="50"></a>
</div>

<div class="cuadro" id="all">
		<h2 style="text-decoration: underline">Consultar</h2>	
		<h2><a href="javascript:showhide('issues')">Tickets</a></h2>
		<h2><a href="javascript:showhide('empresa')">Empresas</a></h2>
		<h2><a href="javascript:showhide('usuarios')">Usuarios</a></h2>
		<h2><a href="javascript:showhide('act')">Actividades</a></h2>
		<h2><a href="javascript:showhide('tareasM')">Tareas</a></h2>
		<h2><a href=VerReportes.html?e="${pageContext.request.userPrincipal.name}">Reportes</a></h2>
</div>		
		<div id="usuarios" style="display:none">
		<h2>Usuarios</h2>
		<div class="cuadroUser">
            <table border=1 cellspacing=0>
            <tr style="border-top-color:transparent">
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Email</th>
                <th>Telefono</th>
                <th>Empresa</th>
                <th>Tipo de usuario</th>
                <th>Estatus</th>
                <th>Opciones</th>
                </tr>
                
                <c:forEach var="req" items="${listUsuarios}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.firstname}</td>
                    <td>${req.lastname}</td>
                    <td>${req.email}</td>
                    <td>${req.telefono}</td>
                    <td>${req.empresa}</td>
                    <td>${req.tipo}</td>
                    <td>${req.estatus}</td>
                    <td>
                        <a href="updateUsuarios?id=${req.id}">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
            </div>
		</div>
		
	<div id="issues" style="display:none;">
	<h2>Tickets</h2>
	<div class="cuadroIssues">	
	<table border=1 cellspacing=0>
            <tr style="border-top-color:transparent">
                <th>Area</th>
                <th>Solicitante</th>
                <th>Telefono</th>
                <th>Descripcion</th>
                <th>Criticidad</th>
                <th>Comentarios</th>
                <th>Estatus Desarrollo</th>
                <th>Estatus Cliente</th>
                <th>Nombre</th>
                <th>Tipo</th>
                <th>Descargar archivo</th>
                <th>Opciones</th>
                </tr>
                
                <c:forEach var="req" items="${listIssues}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.area}</td>
                    <td>${req.solicitante}</td>
                    <td>${req.numero}</td>
                    <td>${req.descripcion}</td>
                    <td>${req.criticidad}</td>
                    <td>${req.comentarios}</td>
                    <td>${req.estatus_desarrollo}</td>
                    <td>${req.estatus_cliente}</td>
                    <td>${req.nombre}</td>
                    <td>${req.type}</td>
                    
                    <td><a href="download.htm?id=${req.id}">${req.nombre}</a></td>                    
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
	<table border=1 cellspacing=0>
            <tr style="border-top-color:transparent">
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
	<table border=1 cellspacing=0>
            <tr style="border-top-color:transparent">
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
	<table border=1 cellspacing=0>
            <tr style="border-top-color:transparent">
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
	<table border=1 cellspacing=0>
            <tr style="border-top-color:transparent">
            	<th>Ref</th>
                <th>Tarea</th>
                <th>Descripcion</th>
                <th>Opciones</th>
                
                <c:forEach var="req" items="${listTareas}" varStatus="status">
                <tr style="border-top-color:transparent">
                	<td>${req.id}</td>
                    <td>${req.nombre}</td>
                    <td>${req.descripcion}</td>
                    <td><a href="javascript:showhide('tareas')?id=${req.id}">Subtareas</a></td>                    
                </tr>
                </c:forEach>             
            </table>
            </div>
</div>

</body>
</html>

