<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

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
    width:50px;
    height:50px;
    float: right;
    margin-right:70px;
    margin-top:10px;
    padding-bottom: 5px;
}

select {
    width: 100%;
    padding: 16px 20px;
    border: none;
    border-radius: 4px;
    background-color: #f1f1f1;
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
<h2> Levantar ticket</h2>											
<form:form id="regForm" modelAttribute="issues" action="issuesProcessA" 
method="POST" enctype="multipart/form-data">
	<div class="container">
	<form:label path="proyecto">Proyectos</form:label>
	<form:select required="true" path="proyecto" name="proyecto" id="proyecto">
	<c:forEach var="req" items="${listProyectos}" varStatus="status">
	<option value="${req.id_proyecto}">${req.nombre}</option>
	</c:forEach> 
	</form:select>            
	<br><br>
	<!-- 
	<form:label path="proyecto">Modulo</form:label>
	<form:select required="true" path="proyecto" name="proyecto" id="proyecto">
	<c:forEach var="req" items="${listProyectos}" varStatus="status">
	<option value="${req.id_proyecto}">${req.nombre}</option>
	<option value="0">--DESCONOCIDO--</option>
	</c:forEach> 
	</form:select>            
	<br><br>
	<form:label path="proyecto">Requerimiento</form:label>
	<form:select required="true" path="proyecto" name="proyecto" id="proyecto">
	<c:forEach var="req" items="${listProyectos}" varStatus="status">
	<option value="${req.id_proyecto}">${req.nombre}</option>
	</c:forEach> 
 	</form:select>            
	<br><br>
	 -->
	<form:hidden name="id_sol" id="id_sol" path="id_sol" value="${id}"/>
	<form:label path="descripcion">Descripcion del issue</form:label>
	<form:textarea path="descripcion" name="descripcion" id="descripcion" col="30" rows="5"/>
	<form:label path="criticidad">Criticidad</form:label><br>
	<div class="radio"><form:radiobutton path="criticidad" name="criticidad" id="criticidad" value="baja"/> Baja
	<form:radiobutton path="criticidad" name="criticidad" id="criticidad" value="media"/>Media
	<form:radiobutton path="criticidad" name="criticidad" id="criticidad" value="alta"/>Alta</div><br>
	<form:label path="comentarios">Comentarios adicionales</form:label>
	<form:textarea path="comentarios" name="comentarios" id="comentarios" col="30" rows="4"/>
	<form:label path="descripcion">Archivo</form:label>
	<form:input type="file" name="archivo" id="archivo" path="archivo"/>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					                            
	<form:button>Guardar</form:button>
	 </div>
</form:form>
</div>
         
</body>
</html>

