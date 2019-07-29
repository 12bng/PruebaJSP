package com.ipartek.formacion.uf2218.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.modelo.ModeloException;
import com.ipartek.formacion.uf2218.modelo.Usuario;
import com.ipartek.formacion.uf2218.negocio.LogicaNegocio;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/CreateUser")
public class CreateUserServlet extends HttpServlet {
	private static final String VISTAS_LOGIN_JSP = "/WEB-INF/vistas/login.jsp";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

		String nick = request.getParameter("newnick");
		String password = request.getParameter("newpassword");
		String password2 = request.getParameter("newpassword2");

		// Empaquetar en objetos del modelo
		if (usuario == null) {
			try {
				usuario = new Usuario(nick, password);
			} catch (ModeloException e) {
				request.getRequestDispatcher(VISTAS_LOGIN_JSP).forward(request, response);
				return;
			}
		}

		if (!LogicaNegocio.existe(nick)) {
			if (LogicaNegocio.coincide(password, password2)) {
				
				LogicaNegocio.añadirUsuario(new Usuario(nick, password));
			} else {
				usuario.setErrorNewPassword("Las contraseñas no coinciden");
			}
		} else {
			usuario.setErrorNewNick("El usuario ya existe");
		}
		request.setAttribute("usuario", usuario);
		request.getRequestDispatcher(VISTAS_LOGIN_JSP).forward(request, response);
	}
}
