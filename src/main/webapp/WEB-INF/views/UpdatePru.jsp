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
	<h2>Pruebas</h2>
		<form:form id="regForm" modelAttribute="pruebas" action="updatePru" method="post">
        	<div class="container">
            	<form:hidden path="id" name="id" id="id"/>
                <form:label path="entrada">Entrada</form:label>
                <form:textarea required="true" path="entrada" name="entrada" id="entrada" col="30" rows="3" /><br>
                <form:label path="proceso">Proceso</form:label>
                <form:textarea required="true" path="proceso" name="proceso" id="proceso" col="30" rows="3"/>
                <form:label path="salida">Salida</form:label>
                <form:textarea required="true" path="salida" name="salida" id="salida" col="30" rows="4"/>
                <form:label path="observaciones">Observaciones</form:label>
                <form:textarea required="true" path="observaciones" name="observaciones" id="observaciones" col="30" rows="5"/>
                <form:label path="severidad">Nivel de severidad</form:label><br>
                <div class="radio">
                <form:radiobutton required="true" path="severidad" name="severidad" id="severidad" value="5"/> No hay errores<br>
                <form:radiobutton required="true" path="severidad" name="severidad" id="severidad" value="1"/> No es posible continuar en el sistema<br>
                <form:radiobutton required="true" path="severidad" name="severidad" id="severidad" value="2"/>No es posible terminar una función<br>
                <form:radiobutton required="true" path="severidad" name="severidad" id="severidad" value="3"/>Funciones restringidas<br>
                <form:radiobutton required="true" path="severidad" name="severidad" id="severidad" value="4"/>Error, se continua el proceso</div><br>
                <form:label path="responsable">Responsable</form:label>
                <div class="radio"><form:radiobutton required="true" path="responsable" name="responsable" id="responsable" value="Fernando Torres"/>Fernando Torres<br>
                <form:radiobutton required="true" path="responsable" name="responsable" id="responsable" value="David Gutierrez"/>Juan David Gutierrez<br>
                <form:radiobutton required="true" path="responsable" name="responsable" id="responsable" value="Victor Castillo"/>Victor Castillo</div><br>
                <form:label path="estatus">Estatus</form:label>
                <div class="radio"><form:radiobutton required="true" path="estatus" name="estatus" id="estatus" value="Exitosa"/>Exitosa<br>
                <form:radiobutton required="true" path="estatus" name="estatus" id="estatus" value="Fallida"/>Fallida</div><br>
                <form:button>Guardar</form:button>
            </div>
        </form:form>           
</div>
</body>
</html>

