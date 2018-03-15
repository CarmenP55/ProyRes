<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Lanconta</title>
<STYLE type="text/css">
p{
	font-family: Trebuchet MS;
}

h2{
	text-align:center;
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
<div class="cuadro">
	<h2> Alta de Requerimientos</h2>
	<form:form id="regForm" modelAttribute="requerimientos" action="reqProcessA" method="post">
                <div class="container">
                			<form:hidden required="true" path="id_pro" name="id_pro" id="id_pro" value="${param.id_proyecto}"/>
                			<form:label path="id_mod">Modulo</form:label>
                			<form:select required="true" path="id_mod" name="id_mod" id="id_mod">
                			<c:forEach var="req" items="${listModulos}" varStatus="status">
                    		<option value="${req.id}">${req.nombre}</option>
                			</c:forEach> 
                			</form:select>            
                			<br><br>
                            <form:label path="tipo">Tipo</form:label>
                            <div class="radio"><form:radiobutton required="true" path="tipo" name="tipo" id="tipo" value="Funcional" />Funcional
                            <form:radiobutton required="true" path="tipo" name="tipo" id="tipo" value="No Funcional" />No Funcional</div>
                            <form:label path="actividad">Actividad</form:label>
                            <form:textarea required="true" path="actividad" name="actividad" id="actividad" col="30" rows="3" />
                            <form:label path="descripcion">Descripcion</form:label>
                            <form:textarea required="true" path="descripcion" name="descripcion" id="descripcion" col="30" rows="5" />
                            <form:label path="entrega">Fecha de entrega</form:label>
                            <form:input required="true" path="entrega" name="entrega" id="entrega" type="date" />
                            <form:label path="criticidad">Criticidad</form:label>
                            <div class="radio"><form:radiobutton required="true" path="criticidad" name="criticidad" id="criticidad" value="Baja" />Baja
                            <form:radiobutton required="true" path="criticidad" name="criticidad" id="criticidad" value="Media" />Media
                            <form:radiobutton required="true" path="criticidad" name="criticidad" id="criticidad" value="Alta" />Alta</div>
                            <form:label path="accion">Plan de accion</form:label>
                            <form:textarea required="true" path="accion" name="accion" id="accion" col="30" rows="5"/>
                            <form:label path="solucion">Fecha de entrega de solucion</form:label>
                            <form:input required="true" path="solucion" name="solucion" id="solucion" type="date"/>
                            <form:label path="comentarios">Comentarios adicionales</form:label>
                            <form:textarea path="comentarios" name="comentarios" id="comentarios" col="30" rows="5" />
                            <form:button>Guardar</form:button>
                     </div>
            </form:form>
</div>
</body>
</html>

