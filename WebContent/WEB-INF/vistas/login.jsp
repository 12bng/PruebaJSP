<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<form action="login" method="post">
	<input name="nick" /> <span class="error">${usuario.errorNick}</span>
	<input type="password" name="password" type="hidden"/> <span class="error">${usuario.errorPassword}</span>
	<button>Login</button>
	<span class="error">${usuario.errorUsuario}</span>
</form>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
