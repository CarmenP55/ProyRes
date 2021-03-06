<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Lanconta</title>
<STYLE type="text/css">

form {
    border: 3px solid #f1f1f1;
    width: 40%;
    margin: auto;
}

input[type=text], input[type=password], input[type=date], input[type=file], textarea {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    font-family: Trebuchet MS;
    font-size:14;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 0.4cm 0.4cm 0.4cm 0.4cm;
    border: none;
    cursor: pointer;
    width: 30%;
    float: right;
}

.container {
    padding: 16px;
    margin-bottom: 35px; 
}

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

p{
	font-family: Trebuchet MS;
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

div.cuadroAdd {
	padding: 16px;
    border: 5px solid #f1f1f1;
    width: 24%;
    margin: auto;    
}

div.cuadroSee {
	padding: 16px;
    border: 5px solid #f1f1f1;
    width: 90%;
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
		<h2 style="text-decoration: underline">Seleccione la opci�n</h2>	
		<h2><a href="javascript:showhide('add')">Agregar Proyecto</a></h2>
		<h2><a href="javascript:showhide('see')">Ver Proyectos</a></h2>
</div>		

<div id="see" style="display:none">
<div class="cuadroSee">	
			<h2>Proyectos</h2>
            <table border=1 cellspacing=0>
            <tr>
                <th>Proyecto</th>
                <th>Tipo de Proyecto</th>
                <th>Descripcion</th>
                <th>Fecha solicitud</th>
                <th>Modelo</th>
                <th>Lenguaje de desarrollo</th>
                <th>Repositorio</th>
                <th>Acceso</th>
                <th>Fecha entrega</th>
                <th>Estatus</th></tr>
                <c:forEach var="proyectos" items="${listProyectos}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${proyectos.nombre}</td>
                    <td>${proyectos.tipo}</td>
                    <td>${proyectos.descripcion}</td>
                    <td>${proyectos.solicitud}</td>
                    <td>${proyectos.modelo}</td>
                    <td>${proyectos.tecnologia}</td>
                    <td>${proyectos.repositorio}</td>
                    <td>${proyectos.detalle}</td>
                    <td>${proyectos.entrega}</td>
                    <td>${proyectos.estatus}</td>
                    <td><a href="verProyectoA?id_proyecto=${proyectos.id_proyecto}">Ver</a>
                    <a href="Proyecto.pdf?id_proyecto=${proyectos.id_proyecto}" target="_blank">PDF</a>
                    <a href="editProyectoA?id_proyecto=${proyectos.id_proyecto}">Editar</a>
                    </td>
                </tr>
                </c:forEach>             
            </table>
</div>
</div>

<div id="add" style="display:none">
<div class="cuadroAdd">	
            <table border=1 cellspacing=0 style="margin:auto">
            <tr style="border-top-color:transparent">
                <th></th>
                <th>Empresa</th>
                <c:forEach var="req" items="${listEmpresas}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.id}</td>
                    <td>${req.nombre}</td>
                    <td>
                        <a href="AltaA?id=${req.id}">Nuevo</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                </tr>
                </c:forEach>             
            </table>
</div>
</div>		
</body>
</html>

