package com.ipartek.formacion.uf2218.accesoADatos;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.uf2218.modelo.Usuario;


public class ListaUsuarios implements Crudable<Usuario>, Serializable{

	DBConector conexion;
	private ListaUsuarios() {
	}

	private static ListaUsuarios instancia;

	public static ListaUsuarios getInstance() {
		if (instancia == null) {
			instancia = new ListaUsuarios();
			DBConector.getConnection();
		}

		return instancia;
	}
	// Fin patrón Singleton

	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	
	
	@Override
	public Iterable<String> obtenerTodosLosNombres() {
		
		ResultSet rs = DBConector.query("SELECT name FROM users");
		ArrayList<String> lista = null;
		try {
			while(rs.next()) {
				 lista.add(rs.getString(0));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	@Override
	public void cargarDB() {
		String request = "SELECT * FROM usuarios";
		// TODO Auto-generated method stub
	}
	
	@Override
	public Usuario obtenerPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Usuario objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Usuario objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(long id) {
		// TODO Auto-generated method stub
		
	}

}
