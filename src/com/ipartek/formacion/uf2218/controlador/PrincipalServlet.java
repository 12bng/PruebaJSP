package com.ipartek.formacion.uf2218.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.modelo.Usuario;

//import com.ipartek.formacion.uf2218.modelos.Producto;
import com.ipartek.formacion.uf2218.negocio.LogicaNegocio;

@WebServlet("/principal")
public class PrincipalServlet extends HttpServlet {
	private static final String VISTAS_ADMIN_JSP = "/WEB-INF/vistas/vistaAdmin.jsp";
	private static final String VISTAS_USUARIO_JSP = "/WEB-INF/vistas/vistaUsuario.jsp";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Iterable<Producto> productos = LogicaNegocio.obtenerProductos();
		// request.setAttribute("productos", productos);
		if ( LogicaNegocio.isAdmin(((Usuario) request.getSession().getAttribute("usuario")))) {
			request.getRequestDispatcher(VISTAS_ADMIN_JSP).forward(request, response);
		} else {
			request.getRequestDispatcher(VISTAS_USUARIO_JSP).forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
