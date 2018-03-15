<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
<a href=irInicio.html><img src="https://image.flaticon.com/icons/svg/25/25694.svg" alt="Home" width="50" height="50"></a>
</div>
<div class="cuadro">
	<h2> Diseño</h2>
	<form:form id="regForm" modelAttribute="diseno" action="updateDis" method="post">
                <div class="container">
                            <form:hidden path="id" name="id" id="id"/>
                			<form:label path="actividad">Actividad o Tarea</form:label>
                            <form:textarea required="true" path="actividad" name="actividad" id="actividad" col="30" rows="3"/>
                            <form:label path="descripcion">Descripción</form:label>
                            <form:textarea required="true" path="descripcion" name="descripcion" id="descripcion" col="30" rows="4" /><br>
                            <form:label path="entrega">Fecha de entrega</form:label>
                            <form:input required="true" path="entrega" name="entrega" id="entrega" type="date"/>
                            <form:label path="codigo">Codigo o configuracion</form:label>
                            <form:textarea required="true" path="codigo" name="codigo" id="codigo" col="40" rows="6"/>
                            <form:label path="argumentos">Argumentos</form:label>
                            <form:textarea required="true" path="argumentos" name="argumentos" id="argumentos" col="20" rows="3"/>
                            <form:label path="codigo">Salida</form:label>
                            <form:textarea required="true" path="salida" name="salida" id="salida" col="20" rows="3"/>
                            <form:label path="comentarios">Comentarios adicionales</form:label><br>
                            <form:textarea path="comentarios" name="comentarios" id="comentarios" col="30" rows="4"/>
                            <form:button>Guardar</form:button>
                     </div>
            </form:form>
</div>
</body>
</html>

