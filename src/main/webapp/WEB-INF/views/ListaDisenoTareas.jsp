<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>Lanconta</title>
<STYLE type="text/css">
a, a:visited {
	text-decoration:none;
	outline:none;
	color:#54a6de;
}

a:hover{
	text-decoration:underline;
}

#colorNav > ul{
	width: 750px; 
	margin:0 auto;
	padding:15px;
}

#colorNav > ul > li{ 
	list-style: none;
	box-shadow: 0 0 10px rgba(100, 100, 100, 0.2) inset,1px 1px 1px #CCC;
	display: inline-block;
	line-height: 1;
	margin: 1px;
	border-radius: 3px;
	position:relative;
	padding: 10px;
}

#colorNav > ul > li > a{
	color:white;
	font-size:20px;
	font-family: Trebuchet MS;
	padding: 15px 15px 15px 15px;
	
}

#colorNav li ul{
	position:absolute;
	list-style:none;
	text-align:center;
	width:150px;
	left:30%;
	margin-left:-90px;
	top:25px;
	
	font-family: 'Trebuchet MS';
	/* This is important for the show/hide CSS animation */
	max-height:0px;
	overflow:hidden;
	
	-webkit-transition:max-height 0.4s linear;
	-moz-transition:max-height 0.4s linear;
	transition:max-height 0.4s linear;
}

#colorNav li ul li{
	background-color:#313131;
}

#colorNav li ul li a{
	padding:12px;
	color:#fff !important;
	display:block;
}

#colorNav li ul li:nth-child(odd){ /* zebra stripes */
	background-color:#363636;
}

#colorNav li ul li:hover{
	background-color:#444;
}

#colorNav li ul li:first-child{
	border-radius:3px 3px 0 0;
	margin-top:25px;
	position:relative;
}

#colorNav li ul li:first-child:before{ /* the pointer tip */
	content:'';
	position:absolute;
	width:1px;
	height:1px;
	border:5px solid transparent;
	border-bottom-color:#313131;
	left:50%;
	top:-10px;
	margin-left:-5px;
}

#colorNav li ul li:last-child{
	border-bottom-left-radius:3px;
	border-bottom-right-radius:3px;
}

#colorNav li:hover ul{
	max-height:200px; /* Increase when adding more dropdown items */
}

#colorNav li{
	background-color:#434140;
}

p{
	font-family: Trebuchet MS;
}

h2{
	text-align:center;
}

td{
	font-family:Trebuchet MS;
	font-size:16;
	padding: 10px 10px 10px 10px;
}

th{
	padding:15px;
}

div.cuadro {
	width: auto;
	margin: auto;
	padding-top:30px;
	padding-left:220px;	
}

table tr {
    background-color: #eee;
}

table tr:nth-child(2) {
    background-color: #eee;
}
table tr:nth-child(even) {
    background-color: #eee;
}
 
table tr:nth-child(odd) {
    background-color: #fff;
}

div.head {
 	width:auto;
    height:60px;
    float: right;
    margin-bottom: 30px;
}

</style>

<script>
function showhide(id) {
	var x= document.getElementById("all");
	var e = document.getElementById(id);
	x.style.display = (x.style.display == 'none') ? 'block' : 'none';
   	e.style.display = (e.style.display == 'block') ? 'none' : 'block';
 }
</script>

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
<h2>Modulos</h2>
<div class="cuadro" id="modulos">	
            <table border=1 cellspacing=0>
            <tr style="border-top-color:transparent">
                <tr><th>Modulo</th>
                <c:forEach var="req" items="${listModulos}" varStatus="status">
                <tr style="border-top-color:transparent">
                    <td><a href=Tareas.html?id=${req.id}&id_proyecto=${param.id_proyecto}>${req.nombre}</a></td>
                </tr>
                </c:forEach>             
            </table>
</div>

</body>
</html>

