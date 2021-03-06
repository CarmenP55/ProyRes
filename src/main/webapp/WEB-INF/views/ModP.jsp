<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

input[type=text], input[type=password], input[type=date], input[type=email], textarea {
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
	<sec:authorize access="hasRole('ROLE_USER')">
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
<a href=Cliente.html><img src="https://image.flaticon.com/icons/svg/25/25694.svg" alt="Home" width="50" height="50"></a>
</div>
<div class="cuadro">
	<h2>Actualizar datos</h2>
	<form:form id="regForm" modelAttribute="user" action="updateUsuC" method="post">
                <div class="container">
                			<form:hidden path="id" name="id" id="id"/>
                            <form:label path="firstname">Nombre</form:label>
                            <form:input path="firstname" name="firstname" id="firstname" disabled="true" />
                            <form:label path="lastname">Apellidos</form:label>
                            <form:input path="lastname" name="lastname" id="lastname" disabled="true"/>
                            <form:label path="telefono">Telefono</form:label>
                            <form:input path="telefono" name="telefono" id="telefono" />
                            <form:label path="email">Correo Electronico</form:label>
                            <form:input path="email" name="email" id="email" type="email" disabled="true"/>
                            <form:label path="password">Contraseņa</form:label>
                            <form:input path="password" name="password" id="password" />
                            <form:button>Guardar</form:button>
                     </div>
            </form:form>
</div>
</body>
</html>

