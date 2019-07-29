<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<h2>Login</h2>
<form action="login" method="post">
	<p>Nombre</p><input name="nick" /> <span class="error">${usuario.errorNick}</span>
	<p>Contraseña</p><input type="password" name="password" type="hidden"/> <span class="error">${usuario.errorPassword}</span>
	<button>Login</button>
	<span class="error">${usuario.errorUsuario}</span>
</form>

<h2>Crear usuario</h2>
<form action="CreateUser" method="post">
	<p>Nombre</p><input name="newnick" /> <span class="error">${usuario.errorNewNick}</span> <br> 
	<p>Contraseña</p><input type="password" name="newpassword" type="hidden"/> <span class="error">${usuario.errorNewPassword}</span>
	<p>Repite Contraseña</p><input type="password" name="newpassword2" type="hidden"/> <span class="error">${usuario.errorNewPassword}</span> 
	<button>Crear</button>
</form>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
