<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>VentanaUser</p>
</body>
</html>

<h2>Editar usuario</h2>
<form action="ModifieUser" method="post">
	<p>password</p><input name="modifieUserPassword" /> <br>
	<button>Modificar</button>
</form>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>