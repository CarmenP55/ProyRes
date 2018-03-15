<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	width: 650px; 
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
	max-height:400px; /* Increase when adding more dropdown items */
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

</style>
</head>
<body>

<sec:authorize access="hasRole('ROLE_SUPER')">
		<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
	</sec:authorize>
<nav id="colorNav">
			<ul>
				<li><a href="Admin.html" class="icon-home">Inicio</a></li>
				<li>
					<a href="ProyectosAd.html" class="icon-cogs">Proyectos</a>
				</li>
				<li>
					<a class="icon-twitter">Registros</a>
					<ul>
					<li><a href=ListaProA.html>Informacion de Proyectos</a></li>
					<li><a href=IssuesAdmin.html>Tickets</a></li>
					<li><a href=EmpresaA.html>Empresas</a></li>
					<li><a href=register.html>Usuarios</a></li>
					<li><a href=Actividades.html>Actividades</a></li>
					<li><a href=CrearTareas.html>Tareas</a></li>
					<li><a href=CrearSub.html>Subtareas</a></li>
					</ul>
				</li>
				
				<li>
					<a href="VerRegistrosA.html" class="icon-twitter">Consultar</a>
				</li>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
				<li>
					<a href="javascript:formSubmit()" class="icon-envelope">Salir</a>
				</li>
				</c:if>
			</ul>
		</nav>
<div class="cuadro">
</div>
</body>
</html>