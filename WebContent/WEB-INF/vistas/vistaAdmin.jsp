<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "com.ipartek.formacion.uf2218.negocio.LogicaNegocio" %> 
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>VentanaAdmin</p>
<table>
<thead><tr><td>Nick</td><td>isAdmin</td></tr></thead>
<tbody><%= LogicaNegocio.tablaUsers() %></tbody>
</table>


</body>
</html>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>