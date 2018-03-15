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
	<h2> Riesgos</h2>
	<form:form id="regForm" modelAttribute="riesgos" action="updateRieA" method="post">
                <div class="container">
                			<form:hidden path="id" name="id" id="id"/>
                            <form:label path="riesgo">Riesgo</form:label>
                            <form:textarea required="true" path="riesgo" name="riesgo" id="riesgo" col="30" rows="4"  />
                            <form:label path="descripcion">Descripción</form:label>
                            <form:textarea path="descripcion" name="descripcion" id="descripcion" col="30" rows="4" /><br>
                            <form:label path="ocurrencia">Probabilidad de ocurrencia</form:label>
                            <div class="radio"><form:radiobutton path="ocurrencia" name="ocurrencia" id="ocurrencia" value="25"/>-25
                            <form:radiobutton path="ocurrencia" name="ocurrencia" id="ocurrencia" value="50"/>50
                            <form:radiobutton path="ocurrencia" name="ocurrencia" id="ocurrencia" value="75"/>+75</div>
                            <form:label path="efectos">Efectos</form:label>
                            <form:textarea path="efectos" name="efectos" id="efectos" col="30" rows="4" />
                            <form:label path="accion">Plan de accion</form:label><br>
                            <form:textarea path="accion" name="accion" id="accion" col="30" rows="4" />
                            <form:label path="contingencia">Plan de contingencia</form:label>
                            <form:textarea path="contingencia" name="contingencia" id="contingencia" col="30" rows="4" />
                            <form:label path="clasificacion">Clasificacion</form:label>
                            <div class="radio">
                            <form:radiobutton path="clasificacion" name="clasificacion" id="clasificacion" value="Proyecto"/>Riesgos del Proyecto<br>
                            <form:radiobutton path="clasificacion" name="clasificacion" id="clasificacion" value="Producto"/>Riesgos del Producto<br>
                            <form:radiobutton path="clasificacion" name="clasificacion" id="clasificacion" value="Negocio"/>Riesgos del Negocio
                            </div>
                            <form:button>Guardar</form:button>
                     </div>
            </form:form>

</div>
</body>
</html>

