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
	<h2>Sub Tareas</h2>
	<form:form id="regForm" modelAttribute="subtareas" action="subProcess" method="post">
                <div class="container">            
                	<form:label path="id_tarea">Tarea</form:label>
                	<form:select required="true" path="id_tarea" name="id_tarea" id="id_tarea">
                	<c:forEach var="req2" items="${listTareas}" varStatus="status">
                    <option value="${req2.id}">${req2.nombre}</option>
                	</c:forEach> 
                	</form:select>            
                	<br><br>
                    	
                	<form:label path="nombre">Subtarea</form:label>
                    <form:textarea required="true" path="nombre" name="nombre" id="nombre" col="30" rows="2"/>
                    <form:label path="descripcion">Descripción</form:label>
					<form:textarea required="true" path="descripcion" name="descripcion" id="descripcion" col="30" rows="4" /><br>                                        
                    <form:button>Guardar</form:button>
               </div>
            </form:form>
</div>
</body>
</html>

