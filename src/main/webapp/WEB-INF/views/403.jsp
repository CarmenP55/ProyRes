<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style type="text/css">
div.cuadro {
	padding: 16px;
    border: 3px solid #f1f1f1;
    width: 85%;
    margin: auto;
}
</style>
</head>

<body>
	<div class="cuadro">
	<h2>HTTP Status 403 - Accesso denegado</h2>
	<c:choose>
		<c:when test="${empty username}">
			<h2>No tiene permisos para ver la pagina</h2>
		</c:when>
		<c:otherwise>
			<h2>Usuario: ${username} <br/>No tiene permisos para ver la pagina</h2>
		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>