package com.ipartek.formacion.uf2218.negocio;

import java.util.ArrayList;

import com.ipartek.formacion.uf2218.accesoADatos.ListaUsuarios;
import com.ipartek.formacion.uf2218.modelo.Usuario;

public class LogicaNegocio {
	static ListaUsuarios listaUsuarios = ListaUsuarios.getInstance();

	public static boolean isAutenticado(Usuario usuario) {
		return listaUsuarios.login(usuario.getNick(), usuario.getPassword());
	}

	public static boolean isAdmin(Usuario usuario) {
		return listaUsuarios.isAdmin(usuario.getNick());
	}
	public static String tablaUsers(){
		String tabla ="";
		ArrayList<Usuario> lista = listaUsuarios.cargarDB();
		for(Usuario usuario: lista) {
			tabla = tabla + "<tr><td>" +usuario.getNick()+ "</td><td>"+usuario.isAdmin()+"</td> </tr>";
		}
		return tabla;
	}
}
