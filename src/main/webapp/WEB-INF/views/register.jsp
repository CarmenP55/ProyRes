<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro</title>
<STYLE type="text/css">

h2{
	text-align:center;
	padding-top:30px;
}
form {
    border: 3px solid #f1f1f1;
    width: 30%;
    margin: auto;
}

input[type=text], input[type=password], input[type=date], input[type=email] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
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

select {
    width: 100%;
    padding: 16px 20px;
    border: none;
    border-radius: 4px;
    background-color: #f1f1f1;
}

div.head {
 	width:auto;
    height:60px;
    float: right;
    margin-bottom: 30px;
    margin-top: 30px;
    margin-right: 30px;
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
<a href=Admin.html><img src="https://image.flaticon.com/icons/svg/25/25694.svg" alt="Home" width="50" height="50"></a><br>
</div>
	<div class="cuadro">            
	<h2> Ingrese los datos</h2>
            <form:form id="regForm" modelAttribute="user" action="registerProcess" method="post">
                <div class="container">
                			<form:label path="firstname">Nombre</form:label>
                            <form:input required="true" path="firstname" name="firstname" id="firstname" />
                            <form:label path="lastname">Apellidos</form:label>
                            <form:input required="true" path="lastname" name="lastname" id="lastname" />
                            <form:label path="telefono">Telefono</form:label>
                            <form:input required="true" path="telefono" name="telefono" id="telefono" />
                            <form:label path="empresa">Empresa</form:label>
							<form:select required="true" path="empresa" name="empresa" id="empresa">
							<c:forEach var="req" items="${listEmpresa}" varStatus="status">
							<option value="${req.id}">${req.nombre}</option>
							</c:forEach> 
							</form:select><br><br>
                            <form:label path="email">Correo Electronico</form:label>
                            <form:input required="true" path="email" name="email" id="email" type="email"/>
                            <form:label path="password">Contraseña</form:label>
                            <form:password required="true" path="password" name="password" id="password" />
                            <form:label path="tipo">Tipo de usuario</form:label>
                            <form:select required="true" path="tipo" name="tipo" id="tipo">
                            <option value="FALSE">--SELECCIONAR--</option>
                    		<option value="ROLE_USER">CLIENTE</option>
                    		<option value="ROLE_ADMIN">ADMINISTRADOR</option>
                    		<option value="ROLE_SUPER">SUPERADMIN</option>
                			</form:select>
                			<br><br>
                            <form:label path="isDes">Es desarrollador?</form:label>
                            <form:checkbox path="isDes"/>
                            <form:button>Registrar</form:button>
                     </div>
            </form:form>
            </div>
        </body>
        </html>