<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login</title>
<style>
	.error {
		padding: 15px;
		margin-bottom: 20px;
		border: 1px solid transparent;
		border-radius: 4px;
		color: #a94442;
		background-color: #f2dede;
		border-color: #ebccd1;
	}

	.msg {
		padding: 15px;
		margin-bottom: 20px;
		border: 1px solid transparent;
		border-radius: 4px;
		color: #31708f;
		background-color: #d9edf7;
		border-color: #bce8f1;
	}

	#login-box {
		border: 3px solid #f1f1f1;
		width: 300px;
		padding: 20px;
		margin: 100px auto;
		background: #fff;
		-webkit-border-radius: 2px;
		-moz-border-radius: 2px;
	}
	
	h2{
		text-align:center;
	}
	
	input[type=password], input[type=email] {
	    width: 100%;
	    padding: 12px 20px;
	    margin: 8px 0;
	    display: inline-block;
	    border: 1px solid #ccc;
	    box-sizing: border-box;
	}	
	
	.container {
	    padding: 16px;
	}
	
	input[type=email]:focus {
	    border-color:#333;
		}
	
	input[type=submit] {
	    padding:15px 15px; 
	    background:#ccc; 
	    float:right;
	    border:0 none;
	    cursor:pointer;
	    -webkit-border-radius: 5px;
	    border-radius: 5px; 
	}
</style>
</head>
<body onload='document.loginForm.username.focus();'>
	<div id="login-box">
	<h2> Iniciar sesi&oacute;n</h2>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		
		<form name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>
			<div class="container">
					Correo electronico:
					<input type='email' name='username' required>
					Contrasena:
					<input type='password' name='password' />
					<input name="submit" type="submit" value="Ingresar" required/>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
	</div>

</body>
</html>

