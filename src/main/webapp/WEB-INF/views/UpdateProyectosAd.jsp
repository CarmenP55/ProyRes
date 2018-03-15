<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Lanconta</title>
<STYLE type="text/css">
h2{
	text-align:center;
}
form {
    border: 3px solid #f1f1f1;
    width: 40%;
    margin: auto;
}

div.radio {
	width: 100%;
    padding: 5px 10px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    font-family: Trebuchet MS;
    font-size:14;
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

button {
    background-color: #4CAF50;
    color: white;
    padding: 0.4cm 0.4cm 0.4cm 0.4cm;
    border: none;
    cursor: pointer;
    width: 30%;
    float: right;
}

select {
    width: 100%;
    padding: 16px 20px;
    border: none;
    border-radius: 4px;
    background-color: #f1f1f1;
}

.container {
    padding: 16px;
    margin-bottom: 35px; 
}

div.head {    
    width:60px;
    height:60px;
    float: right;
    margin-right:70px;
    margin-top:10px;
}

div.cuadro {
	width: auto;
	margin:auto;
	padding-top:10px;

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
<a href=Admin.html><img src="https://image.flaticon.com/icons/svg/25/25694.svg" alt="Home" width="50" height="50"></a>
</div>
<div class="cuadro">
	<h2>Proyecto</h2>
	<form:form id="regForm" modelAttribute="proyectos" action="saveA" method="post">
                <div class="container">
                            <form:hidden path="id_proyecto" name="id_proyecto" id="id_proyecto"/>
                            <form:label path="nombre">Nombre del Proyecto</form:label>
                            <form:input required="true" path="nombre" name="nombre" id="nombre"/>
                            <form:label path="tipo">Tipo de Proyecto</form:label>
                            <div class="radio">
                            <form:radiobutton required="true" path="tipo" name="tipo" id="tipo" value="Nuevo" />Nuevo
                            <form:radiobutton required="true" path="tipo" name="tipo" id="tipo" value="Heredado" />Heredado</div>
                            <form:label path="empresa">Empresa</form:label>
                            <form:input required="true" path="empresa" name="empresa" id="empresa" disabled="true"/>
                            <form:label path="responsable">Responsable de la empresa</form:label> 
                            <form:input required="true" path="responsable" name="responsable" id="responsable" disabled="true"/>
                            <form:label path="descripcion">Descripcion del proyecto</form:label>
                            <form:textarea required="true" path="descripcion" name="descripcion" id="descripcion" col="40" rows="6" />
                            <form:label path="solicitud">Fecha de solicitud</form:label>
                            <form:input required="true" path="solicitud" name="solicitud" id="solicitud" type="date" disabled="true"/>
                            <form:label path="desarrollador">Desarrollador</form:label>
                			<form:input required="true" path="desarrollador" name="desarrollador" id="desarrollador" disabled="true"/>
                			<form:label path="modelo">Modelo a seguir</form:label>
                            <div class="radio">
                            <form:radiobutton path="modelo" name="modelo" id="modelo" value="Cascada" disabled="true"/>Cascada
                            <form:radiobutton required="true" path="modelo" name="modelo" id="modelo" value="Evolutivo" disabled="true"/>Evolutivo
                            <form:radiobutton required="true" path="modelo" name="modelo" id="modelo" value="Espiral" disabled="true" />Espiral
                            </div>
                            <form:label path="entrega">Fecha de entrega</form:label>
							<form:input required="true" path="entrega" name="entrega" id="entrega" type="date" />
							<form:label path="tecnologia">Lenguaje de desarrollo</form:label>
                            <form:input required="true" path="tecnologia" name="tecnologia" id="tecnologia"/>
                            <form:label path="repositorio">Repositorio del proyecto</form:label>
                            <form:input required="true" path="repositorio" name="repositorio" id="repositorio"/>
                            <form:label path="detalle">Acceso repositorio</form:label>
                            <form:textarea required="true" path="detalle" name="detalle" id="detalle" col="40" rows="4" />
                            <form:button>Guardar</form:button>
                     </div>
            </form:form>
</div>
</body>
</html>

