<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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

input[type=text], input[type=password], input[type=file], textarea {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    font-family: Trebuchet MS;
    font-size:14;
}

input[type=date], input[type=time]{
    width: 49.5%;
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

div.head {    
    width:60px;
    height:60px;
    float: right;
    margin-right:70px;
    margin-top:10px;
}

div.cuadro {
	width:auto;
	margin:auto;
	padding-top:10px;
}

select {
    width: 100%;
    padding: 16px 20px;
    border: none;
    border-radius: 4px;
    background-color: #f1f1f1;
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
<a href=irInicio.html><img src="https://image.flaticon.com/icons/svg/25/25694.svg" alt="Home" width="50" height="50"></a>
</div>
<div class="cuadro">
	<h2>Desarrollo</h2>
	<form:form id="regForm" modelAttribute="reportes" action="reportesProcess" method="post">
    	<div class="container">
        	<form:label path="id_pro">Proyecto</form:label>
        	<form:select required="true" path="id_pro" name="id_pro" id="id_pro">
           	<c:forEach var="req" items="${listProyectos}" varStatus="status">
            <option value="${req.id_proyecto}">${req.nombre}</option>
            </c:forEach> 
            </form:select>            
            <br><br>
            <form:hidden path="id_usu" name="id_usu" id="id_usu" value="${id}"/>
            <form:label path="id_actividad">Actividad</form:label>
            <form:select required="true" path="id_actividad" name="id_actividad" id="id_actividad">
            <c:forEach var="req" items="${listAct}" varStatus="status">
            <option value="${req.id}">${req.nombre}</option>
            </c:forEach> 
            </form:select>            
            <br><br>         
            <br><form:label path="fecha_inicio">Fecha inicio</form:label><br>
            <form:input required="true" path="fecha_inicio" name="fecha_inicio" id="fecha_inicio" type="date"/>
            <form:input required="true" path="hora_inicio" name="hora_inicio" id="hora_inicio" type="time"/>
            <br><form:label path="fecha_fin">Fecha fin</form:label><br>
            <form:input required="true" path="fecha_fin" name="fecha_fin" id="fecha_fin" type="date"/>
            <form:input required="true" path="hora_fin" name="hora_fin" id="hora_fin" type="time"/>
            <form:label path="comentarios">Comentarios</form:label><br>
            <form:textarea path="comentarios" name="comentarios" id="comentarios" col="30" rows="4"/>
            <form:button>Guardar</form:button>
    	</div>
    </form:form>
</div>
</body>
</html>

