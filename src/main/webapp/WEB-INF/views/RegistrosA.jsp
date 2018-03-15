<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registros</title>
<STYLE type="text/css">
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
    margin-top: 30px;
    margin-right: 30px;
}

div.cuadro {
	padding: 16px;
    border: 5px solid #f1f1f1;
    width: 35%;
    margin: auto; 
}

form {
    border: 3px solid #f1f1f1;
    width: 40%;
    margin: auto;
}

input[type=text], input[type=password], input[type=date], textarea {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    font-family: Trebuchet MS;
    font-size:14;
}

select {
    width: 100%;
    padding: 16px 20px;
    border: none;
    border-radius: 4px;
    background-color: #f1f1f1;
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

div.verDis {
	padding: 16px;
    border: 5px solid #f1f1f1;
    width: 50%;
    margin: auto; 
}

div.verR {
	padding: 16px;
    border: 5px solid #f1f1f1;
    width: 80%;
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
<a href=Admin.html><img src="https://image.flaticon.com/icons/svg/25/25694.svg" alt="Home" width="50" height="50"></a><br>
</div>
<div class="cuadro" id="all">
            <table border=1 cellspacing=0 width=97% style="margin:auto">
            	<tr><th>Seleccionar</th>
            	<th colspan="2">Opciones</th></tr>
            	<tr>
                <td><img src="https://www.redeszone.net/app/uploads/2016/11/especificaciones-tecnicas.png" alt="Home" width="50" height="50">Esp. Tecnica</td>
                <td>N/A</td>
                <td><a href="ET.pdf?id_proyecto=${param.id_proyecto}" target="_blank">Generar ET</a><br></td></tr>
            	<tr>
                <td><img src="https://image.flaticon.com/icons/svg/74/74960.svg" alt="Home" width="50" height="50" title="Agregar informacion">Tareas</td>
                <td><a href="javascript:showhide('diseno')"?id_proyecto=${param.id_proyecto}>Agregar</a><br></td>
                <td><a href="javascript:showhide('verDiseno')"?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td>
                </tr>
                <tr>
                <td><img src="https://ecosagile.com/EcosAgile/SPA/images/moduli-e-processi.png" alt="Home" width="50" height="50" title="Agregar informacion">Modulos<br></td>
                <td><a href="javascript:showhide('modulos')"?id_proyecto=${param.id_proyecto}>Agregar</a><br></td>
                <td><a href="javascript:showhide('verModulos')"?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td></tr>
				<tr>
				<td><img src="https://userscontent2.emaze.com/images/8bcc1df3-5fd7-452a-b935-102d351b241b/897ac9fb-7778-4510-aa2e-823a44c5be72.png" alt="Home" width="50" height="50" title="Agregar informacion">Pruebas<br></td>
				<td><a href="javascript:showhide('pruebas')"?id_proyecto=${param.id_proyecto}>Agregar</a><br></td>
				<td><a href="javascript:showhide('verPruebas')"?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td></tr>
				<tr>
				<td><img src="https://www.csticorp.biz/wp-content/uploads/2014/07/Imagen8.jpg" alt="Home" width="50" height="50" title="Agregar informacion">Requerimientos<br></td>
				<td><a href=RequerimientosA.html?id_proyecto=${param.id_proyecto}>Agregar</a><br></td>
				<td><a href="javascript:showhide('verReq')"?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td></tr>
				<tr>
				<td><img src="http://finantechcolombia.com/wp-content/uploads/2013/11/Consultoria-financiera-en-riesgos-para-empresas-peque%C3%B1as-en-Colombia.jpg" alt="Home" width="50" height="50" title="Agregar informacion">Riesgos<br></td>
				<td><a href=RiesgosA.html?id_proyecto=${param.id_proyecto}>Agregar</a><br></td>
				<td><a href="javascript:showhide('verRiesgos')"?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td></tr>
            </table>
</div>

<div class="cuadro" id="diseno" style="display:none;">
	<h2>Elegir Modulo</h2>	
     <table border=1 cellspacing=0 style="margin:auto">
        <tr style="border-top-color:transparent"></tr>
           <tr><th>Modulo</th>
               <c:forEach var="req" items="${listModulos}" varStatus="status">
               <tr style="border-top-color:transparent">
               <td><a href=DisenioA.html?id=${req.id}&id_proyecto=${param.id_proyecto}>${req.nombre}</a></td>
               </tr>
               </c:forEach>             
    </table>
</div>

<div class="cuadro" id="pruebas" style="display:none;">
	<h2>Elegir Modulo</h2>	
     <table border=1 cellspacing=0 style="margin:auto">
        <tr style="border-top-color:transparent">
           	   <th>Modulo</th>
               <c:forEach var="req" items="${listModulos}" varStatus="status">
               <tr style="border-top-color:transparent">
               <td><a href=PruebasA.html?id=${req.id}&id_proyecto=${param.id_proyecto}>${req.nombre}</a></td>
               </tr>
               </c:forEach>             
    </table>
</div>

<div id="modulos" style="display:none;">
	<h2>Modulos</h2>
	<form:form id="regForm" modelAttribute="modulo" action="modulosProcessA" method="post">
                <div class="container">
                	<form:hidden path="proyectos" name="proyectos" id="proyectos" value="${param.id_proyecto}"/>
                    <form:label path="nombre">Nombre</form:label>
                    <form:input required="true" path="nombre" name="nombre" id="nombre" />
                    <form:label path="descripcion">Descripcion</form:label>
                    <form:textarea required="true" path="descripcion" name="descripcion" id="descripcion" col="40" rows="4" />
                    <form:label path="entrega">Fecha de entrega</form:label>
                    <form:input required="true" path="entrega" name="entrega" id="entrega" type="date" />                     
                    <form:button>Guardar</form:button>
                </div>
            </form:form>
</div>

<div class="verDis" id="verDiseno" style="display:none;">	
			<h2>Diseno</h2>
            <table border=1 cellspacing=0>
            <tr style="border-top-color:transparent">
                <th>Actividad</th>
                <th>Descripcion</th>
                <th>Entrega</th>
                <th>Comentarios</th>
                <th>Estatus</th></tr>
                <c:forEach var="req" items="${listDiseno}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.actividad}</td>
                    <td>${req.descripcion}</td>
                    <td>${req.entrega}</td>
                    <td>${req.comentarios}</td>
                    <td>${req.estatus}</td>
                    <td>
                        <a href="updateDisenoA?id=${req.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                </tr>
                </c:forEach>             
            </table>
</div>

<div class="verR" id="verPruebas" style="display:none;">	
			<h2>Pruebas</h2>
            <table border=1 cellspacing=0>
            <tr style="border-top-color:transparent">
                <th>Entrada</th>
                <th>Proceso</th>
                <th>Salida</th>
                <th>Observaciones</th>
                <th>Severidad</th>
                <th>Responsable</th>
                <th>Version</th>
                <th>Estatus</th></tr>
                
                <c:forEach var="req" items="${listPruebas}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.entrada}</td>
                    <td>${req.proceso}</td>
                    <td>${req.salida}</td>
                    <td>${req.observaciones}</td>
                    <td>${req.severidad}</td>
                    <td>${req.responsable}</td>
                    <td>${req.version}</td>
                    <td>${req.estatus}</td>
                    <td>
                        <a href="updatePruebasA?id=${req.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                </tr>
                </c:forEach>             
            </table>
</div>

<div class="verDis" id="verModulos" style="display:none;">	
			<h2>Modulos</h2>
            <table border=1 cellspacing=0>
            <tr style="border-top-color:transparent">
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Fecha de registro</th>
                <th>Fecha de entrega</th>
                <th>Estatus</th>                
                
                <c:forEach var="req" items="${listModulos}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.nombre}</td>
                    <td>${req.descripcion}</td>
                    <td>${req.alta}</td>
                    <td>${req.entrega}</td>
                    <td>${req.estatus}</td>
                    <td>
                        <a href="updateModulosA?id=${req.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                </tr>
                </c:forEach>             
            </table>
</div>

<div class="verR" id="verReq" style="display:none;">	
			<h2>Requerimientos</h2>
            <table border=1 cellspacing=0>
            <tr>
                <th>Tipo</th>
                <th>Actividad</th>
                <th>Descripcion</th>
                <th>Entrega</th>
                <th>Criticidad</th>
                <th>Accion</th>
                <th>Solucion</th>
                <th>Comentarios</th>
                <th>Estatus</th>
                </tr>
                <c:forEach var="req" items="${listRequerimientos}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.tipo}</td>
                    <td><a title="Modificar" href="updateRequerimientoA?id_req=${req.id_req}">${req.actividad}</a></td>
                    <td>${req.descripcion}</td>
                    <td>${req.entrega}</td>
                    <td>${req.criticidad}</td>
                    <td>${req.accion}</td>
                    <td>${req.solucion}</td>
                    <td>${req.comentarios}</td>
                    <td>${req.estatus}</td>
                </tr>
                </c:forEach>             
            </table>
</div>


<div class="verR" id="verRiesgos" style="display:none;">
			<h2>Riesgos</h2>	
            <table border=1 cellspacing=0>
            <tr style="border-top-color:transparent">
                <th>Riesgos</th>
                <th>Descripcion</th>
                <th>Probabilidad de Ocurrencia</th>
                <th>Efectos</th>
                <th>Accion</th>
                <th>Contingencia</th>
                <th>Clasificacion</th>
                <th>Version</th></tr>
                
                <c:forEach var="req" items="${listRiesgos}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td>${req.riesgo}</td>
                    <td>${req.descripcion}</td>
                    <td>${req.ocurrencia}%</td>
                    <td>${req.efectos}</td>
                    <td>${req.accion}</td>
                    <td>${req.contingencia}</td>
                    <td>${req.clasificacion}</td>
                    <td>${req.version}</td>
                    <td>
                        <a href="updateRiesgosA?id=${req.id}">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                </tr>
                </c:forEach>             
            </table>
</div>
</body>
</html>