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
	width: auto;
	margin: auto;
	float: auto;
	padding-top:30px;
	padding-left:480px;
	padding-right:80px;
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
<div class="head">
<a href=irInicio.html><img src="https://image.flaticon.com/icons/svg/25/25694.svg" alt="Home" width="50" height="50"></a><br>
</div>
<div class="cuadro">
            <table border=1 cellspacing=0>
            	<tr><th>Elegir opcion</th>
            	<th>Ver</th></tr>
                <tr>
                <td><a href="ModDisT.html?id_proyecto=${param.id_proyecto}"><img src="https://image.flaticon.com/icons/svg/74/74960.svg" alt="Home" width="50" height="50" title="Agregar informacion"></a>Agregar Tareas<br></td>
                <td><a href=VerTareas.html?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td></tr>
                <tr>
                <tr>
                <td><a href="ModDis.html?id_proyecto=${param.id_proyecto}"><img src="https://impulsando.academy/blog/content/images/2017/02/programacion-nuevo.jpg" alt="Home" width="50" height="50" title="Agregar informacion"></a>Implementar Tareas<br></td>
                <td><a href=VerDiseno.html?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td></tr>
                <tr>
                <td><img src="https://www.redeszone.net/app/uploads/2016/11/especificaciones-tecnicas.png" alt="Home" width="50" height="50">Especificacion Tecnica</td>
                <td><a href="ET.pdf?id_proyecto=${param.id_proyecto}" target="_blank">Ver</a></td></tr>
                <tr>
                <td><a href=Modulos.html?id_proyecto=${param.id_proyecto}><img src="https://ecosagile.com/EcosAgile/SPA/images/moduli-e-processi.png" alt="Home" width="50" height="50" title="Agregar informacion"></a>Modulos<br></td>
                <td><a href="VerModulos.html?id_proyecto=${param.id_proyecto}">Ver registros</a><br></td></tr>
				<tr>
				<td><a href="ModPru.html?id_proyecto=${param.id_proyecto}"><img src="https://userscontent2.emaze.com/images/8bcc1df3-5fd7-452a-b935-102d351b241b/897ac9fb-7778-4510-aa2e-823a44c5be72.png" alt="Home" width="50" height="50" title="Agregar informacion"></a>Pruebas<br></td>
				<td><a href=VerPruebas.html?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td></tr>
				<tr>
				<td><a href=Requerimientos.html?id_proyecto=${param.id_proyecto}><img src="https://www.csticorp.biz/wp-content/uploads/2014/07/Imagen8.jpg" alt="Home" width="50" height="50" title="Agregar informacion"></a>Requerimientos<br></td>
				<td><a href="ModReq.html?id_proyecto=${param.id_proyecto}">Ver registros</a><br></td></tr>
				<tr>

				<td><a href=Riesgos.html?id_proyecto=${param.id_proyecto}><img src="http://finantechcolombia.com/wp-content/uploads/2013/11/Consultoria-financiera-en-riesgos-para-empresas-peque%C3%B1as-en-Colombia.jpg" alt="Home" width="50" height="50" title="Agregar informacion"></a>Riesgos<br></td>
				<td><a href=VerRiesgos.html?id_proyecto=${param.id_proyecto}>Ver registros</a><br></td></tr>
            </table>
</div>
</body>
</html>