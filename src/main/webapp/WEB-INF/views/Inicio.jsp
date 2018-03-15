<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
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
	width: 900px; 
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
	max-height:500px; /* Increase when adding more dropdown items */
}

#colorNav li{
	background-color:#434140;
}

p{
	font-family: Comic Sans MS;
	font-size: 30px;
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

div.cuadro {
	width: auto;
	margin: auto;
	padding-top:30px;
	padding-left:80px;
	padding-right:80px;
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

.msg {
		padding: 15px;
		margin-bottom: 20px;
		border: 1px solid transparent;
		border-radius: 4px;
		color: #31708f;
		background-color: #d9edf7;
		border-color: #bce8f1;
	}

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
	
	<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
	
<nav id="colorNav">
			<ul>
				<li>
					<a href="irInicio.html" class="icon-home">Inicio</a>
				</li>
				<li>
					<a class="icon-cogs">Proyectos</a>
					<ul>
						<li><a href="VerProyectos.html">Ver Proyectos</a></li>
						<li><a href="Proyectos.html">Agregar nuevo proyecto</a></li>
					</ul>
				</li>
				<li>
					<a class="icon-twitter">Registrar</a>
					<ul>
					<li><a href=ListaPro.html>Informacion de Proyectos</a></li>
					<li><a href=IssuesD.html>Tickets</a></li>
					<li><a href=Empresa.html>Empresas</a></li>
					<li><a href=register2.html>Usuarios</a></li>
					</ul>
				</li>
				<li>
					<a class="icon-beaker">Consultar</a>
					<ul>
						<li><a href=ListaVer.html>Informacion de Proyectos</a></li>
						<li><a href=VerIssues.html>Tickets</a></li>
						<li><a href=VerEmpresas.html>Empresas</a></li>
						<li><a href=VerUsuariosD.html>Usuarios</a></li>
					</ul>
				</li>
				<li>
					<a href=PassD?e="${pageContext.request.userPrincipal.name}" class="icon-envelope">Mi cuenta</a>
				</li>
				
				<li>
					<a class="icon-envelope">Reportes</a>
					<ul>
					<li><a href=Reportes.html?e="${pageContext.request.userPrincipal.name}">Nuevo</a></li>
					<li><a href=VerReportesD.html?e="${pageContext.request.userPrincipal.name}">Mis reportes</a></li>
					</ul>
				</li>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
				<li>
					<a href="javascript:formSubmit()" class="icon-envelope">Salir</a>
				</li>
				</c:if>
			</ul>
		</nav>
<div class="cuadro">
<p>Bienvenido: ${pageContext.request.userPrincipal.name}</p>
</div>
</body>
</html>