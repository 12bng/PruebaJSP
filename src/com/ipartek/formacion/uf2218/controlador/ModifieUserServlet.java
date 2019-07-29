package com.ipartek.formacion.uf2218.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.accesoADatos.ListaUsuarios;
import com.ipartek.formacion.uf2218.modelo.Usuario;

/**
 * Servlet implementation class ModifieUserServlet
 */
@WebServlet("/ModifieUser")
public class ModifieUserServlet extends HttpServlet {
	private static final String VISTAS_LOGIN_JSP = "/WEB-INF/vistas/login.jsp";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifieUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario user = new Usuario(((Usuario) request.getSession().getAttribute("usuario")).getNick(), request.getParameter("modifieUserPassword"));
		ListaUsuarios.getInstance().modificar(user); 
		System.out.println("Contraseña cambiada");
		request.getSession().invalidate();
		request.getRequestDispatcher(VISTAS_LOGIN_JSP).forward(request, response);
	}

}
